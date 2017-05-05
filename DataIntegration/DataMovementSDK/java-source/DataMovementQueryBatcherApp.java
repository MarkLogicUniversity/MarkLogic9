import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.datamovement.DataMovementManager;
import com.marklogic.client.datamovement.DeleteListener;
import com.marklogic.client.datamovement.JobTicket;
import com.marklogic.client.datamovement.QueryBatcher;
import com.marklogic.client.query.StructuredQueryBuilder;
import com.marklogic.client.query.StructuredQueryDefinition;

public class DataMovementQueryBatcherApp {

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
	
	// default size of each batch of documents to delete
	private static int batchSize = 2500;
		
	private static DatabaseClient marklogic;
	
	public static void main(String[] args) {
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
		
		marklogic = DatabaseClientFactory
				  .newClient(HOST, PORT, 
				    new DatabaseClientFactory.DigestAuthContext(username, password)
				  );
		
		final DataMovementManager manager = marklogic.newDataMovementManager();
		final StructuredQueryBuilder sqb = new StructuredQueryBuilder();
		final StructuredQueryDefinition query = sqb.collection("raw");

		System.out.format("Deleting all documents from the database with REST instance on port %d", PORT);
		
		final QueryBatcher batcher = manager
		  .newQueryBatcher(query)
		  .withBatchSize(batchSize)
		  // Run the query at a consistent point in time.
		  // This means that the matched documents will be the same 
		  // across batches, even if the underlying data is changing.
		  .withConsistentSnapshot()
		  // Included QueryBatchListener implementation that deletes
		  // a batch of URIs. 
		  .onUrisReady(new DeleteListener())
		  .onQueryFailure(throwable -> throwable.printStackTrace());
		
		JobTicket ticket = manager.startJob(batcher);
		batcher.awaitCompletion();
		manager.stopJob(ticket);
	}
	
}
