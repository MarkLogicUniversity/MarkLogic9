
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.datamovement.DataMovementManager;
import com.marklogic.client.datamovement.JobTicket;
import com.marklogic.client.datamovement.WriteBatcher;
import com.marklogic.client.io.DocumentMetadataHandle;
import com.marklogic.client.io.FileHandle;
import com.marklogic.client.io.Format;
import com.marklogic.client.io.StringHandle;

/* This is a main class for the Introduction to the Data Movement SDK 
 * demo.
 */
@XmlRootElement
public class DataMovementWriteBatcherApp {
	// change the below setting for your MarkLogic
	//	host information. By default, this will load
	//	the documents to your "Documents" database
	//	on your local computer. It will log into the
	//	App Server on port 8000 with the username of "username"
	//	and the password of "password". Make sure you use
	//	a username and password that has permissions for
	//	the database.
	private static String HOST = "";
	private static int PORT = 0;
	private static String username = "";
	private static String password = "";
	
	// path to the documents to load into the Documents database
	private static String docPath = "";
	// default size of each batch of documents to write
	private static int batchSize = 50;
	// default number of threads to create to process each batch
	private static int threadCount = 10;
		
	private static DatabaseClient marklogic;
	
	public static void main(String[] args) {
		// print out the current working directory. The properties file should
		//	be in this directory.
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream("config.properties");

			// load the properties file
			prop.load(input);

			// get the property value and print it out
			HOST = prop.getProperty("host");
			PORT = Integer.parseInt(prop.getProperty("port"));
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			batchSize = Integer.parseInt(prop.getProperty("batchsize"));
			threadCount = Integer.parseInt(prop.getProperty("threads"));
			docPath = prop.getProperty("contentpath");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// Set up the connection to the MarkLogic cluster. 
		// Client instances are designed for reuse. In a real application 
		// you’d use something like dependency injection to manage this 
		// externally and share it with other classes.
		marklogic = DatabaseClientFactory
		  .newClient(HOST, PORT, 
		    new DatabaseClientFactory.DigestAuthContext(username, password)
		  );
		
		// DataMovementManager is the core class for doing asynchronous jobs against
		// a MarkLogic cluster.		
		final DataMovementManager manager = marklogic.newDataMovementManager();
		
		final WriteBatcher writer = createWriteBatcher(manager);
		final long startTime = System.nanoTime(); 
		
		// Start an asynchronous job with the above configuration.
		// Use the JobTicket to refer to this job later, for example
		// to track status.
		// This is a one-time job configuration
		final JobTicket ticket = manager.startJob(writer);
		
		AddContent(writer, docPath);
		
		// Normally, we'd write the batches asynchronously.
		//writer.flushAsync();
		
		// Override the default asynchronous behavior and make the current
		// thread wait for all documents to be written to MarkLogic. 
		writer.flushAndWait();
		
		// Finalize the job by its unique handle generated in startJob() above. 
		manager.stopJob(ticket);
	
		final long endTime = System.nanoTime() - startTime;
		System.out.format("Elapsed time to process: %f seconds %n", (endTime * 0.000000001));
	}
	
	private static WriteBatcher createWriteBatcher(DataMovementManager manager) {	
		
		// In this case, we’re writing data in batches
		WriteBatcher myWriter = manager
		  .newWriteBatcher()
		  // Configure parallelization and memory tradeoffs
		  .withJobName("SocialMedia Loader")
		  .withBatchSize(batchSize)
		  .withThreadCount(threadCount)
		  // Configure listeners for asynchronous lifecycle events
		  // Success:
		  .onBatchSuccess(batch -> {
		        System.out.format("batch # %s, so far: %s %n",batch.getJobBatchNumber(), batch.getJobWritesSoFar());
		    })
		  // Failure:
		  .onBatchFailure((batch, throwable) -> throwable.printStackTrace());
		
		return myWriter;
	}
	
	private static void AddContent(WriteBatcher writer ) {
		// add our docs to write to the database
		// (★) Implementation that adds 10,000 synthetic JSON documents into a 
		//      collection named 'raw'.
		//      In a real application you’d probably get JSON or XML documents 
		//      from a message bus, another database, a web service, the file system,
		//      or any number of other I/O source available to Java.
		final String[] statuses = { "active", "in-progress", "closed" };
		final DocumentMetadataHandle meta = new DocumentMetadataHandle()
		  .withCollections("raw");
		final int numDocs = 10000;
		System.out.format("Total number of batches to process: %s %n", numDocs/batchSize);
		
		for (int i = 0; i < numDocs; i++) {
		  final String id = UUID.randomUUID().toString();
		  final String now = Instant.now().toString();
		  final String status = statuses[new Random().nextInt(statuses.length)];
		  // Call add() as many times as you need, even from multiple threads.
		  writer.add("/" + id + ".json", meta,
		      // Brain-dead example of creating JSON from a String
		      // Use the Java Client API’s I/O adapters (i.e. *Handle) to formulate 
		      // JSON or XML documents from other sources.
		      new StringHandle(
		        "{ \"id\": \"" + id 
		        + "\",\n\"timestamp\": \"" + now
		        + "\",\n\"status\": \"" + status + "\"}"
		      ).withFormat(Format.JSON));
		}
	}
	
	private static void AddContent(WriteBatcher writer, String docPath ) {
		// add our docs to write to the database
		// (★) Implementation that adds documents from a given directory path into a 
		//      collection named 'raw'.
		//      In a real application you’d probably get JSON or XML documents 
		//      from a message bus, another database, a web service, the file system,
		//      or any number of other I/O source available to Java.
		final DocumentMetadataHandle meta = new DocumentMetadataHandle()
		  .withCollections("raw");
		if (docPath.isEmpty()) {
			// no given path? just return.
			return;
		}
		else {			
			try {
			    Files.walk(Paths.get(docPath))
			         .filter(Files::isRegularFile)
			         .forEach(p -> {
			                   String uri = "/dmsdk/" + p.getFileName().toString();
			                   // System.out.format("Filename URI: %s %n", uri);
								
			                   FileHandle handle = 
			                       new FileHandle().with(p.toFile());
			                   writer.add(uri, meta, handle);
			                 });
			} catch (IOException e) {
			    e.printStackTrace();
			}
		}
	}
}
