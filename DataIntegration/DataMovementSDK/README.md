# Introduction to the Data Movement SDK
Here you'll find the supporting code and examples for the Introduction to the Data Movement SDK training tutorial.  Some basic familiarity with MarkLogic Server is assumed.

##Getting Started
<ol>
<li>Download MarkLogic:
  <ul>
    <li>http://developer.marklogic.com
  </ul>
<li>Install, start, and initialize MarkLogic on your local machine:
  <ul>
    <li>http://docs.marklogic.com/guide/installation
  </ul>
</ol>

##Setup the Database for the Examples
<ul>
<li>With MarkLogic Server setup and running, there are no special database requirements. The tutorial uses the <b>Documents</b> database for the code examples. 
</ul>

##Java Code examples
The demonstrations of the Data Movement SDK are in several formats. The following folders contain these examples.
<ol>
	<li>`java-source`
		<ul>
		<li>`DataMovementQueryBatcherApp.java` - Java source code demonstrating a Query Batcher job. The code illustrates getting connections to a REST instance with the Java API, starting a Data Movement SDK job and creating a QueryBatcher to delete documents from the MarkLogic Documents database. The file can be opened in any text editor. 
		<li>`DataMovementWriteBatcherApp.java` - Java source code demonstrating a Write Batcher job. The code illustrates getting connections to a REST instance with the Java API, starting a Data Movement SDK job and creating a WriteBatcher to write socialmedia content from a directory to the MarkLogic Documents database. The file can be opened in any text editor. 
		</ul>
	<li>`jars` - contains runnable demonstrations from the above source code.
	<ul>
		<li>`query-batcher` - Delete the content loaded to the Documents database after running the write-batcher example. To run this example, do the following.
			<ol>
				<li>You will need Java 1.8+ installed and working.
				<li>Open a command prompt and change to the `query-batcher` folder.
				<li>Edit the `config.properties` file with the following:
				<ul>
					<li>`host` - default value is MarkLogic running on your localhost.
					<li>`port` - default value is the App Services MarkLogic application server. This should be left at the default value.
					<li>`username` - set this value to a MarkLogic user with the admin Role or a MarkLogic username that has read and update permissions to the content in the Documents database.
					<li>`password` - set this value to the password for the username.
					<li>`batchsize` - default value deletes 2500 documents per batch of work. This can be modifed, however, the default value has been tested and performs as expected. 
				</ul>
				<li>On a command line, type `java -jar dmQuery.jar` then press ENTER. Messages will be printed to the console window showing progress.
			</ol>
		<li>`write-batcher` - Writes content from the socialmedia folder to the Documents database. To run this example, do the following.
			<ol>
				<li>You will need Java 1.8+ installed and working.
				<li>Open a command prompt and change to the `write-batcher` folder.
				<li>Edit the `config.properties` file with the following:
				<ul>
					<li>`host` - default value is MarkLogic running on your localhost.
					<li>`port` - default value is the App Services MarkLogic application server. This should be left at the default value.
					<li>`username` - set this value to a MarkLogic user with the admin Role or a MarkLogic username that has insert and update permissions to the content in the Documents database.
					<li>`password` - set this value to the password for the username.
					<li>`batchsize` - default value deletes 50 documents per batch of work. This can be modifed, however, the default value has been tested and performs as expected. 
					<li>`threads` - default value of 20 threads for the Write Batcher job. This can be modifed, however, the default value has been tested and performs as expected.
					<li>`contentpath` - default value points to the `socialmedia` folder in the current `write-batcher` folder.
				</ul>
				<li>On a command line, type `java -jar dmWrite.jar` then press ENTER. Messages will be printed to the console window showing progress.
			</ol>
	</ul>
	<li>`eclipse` - This folder contains an Eclipse project archive. The project archive can be imported into Eclipse by doing the following steps.
	<ol>
		<li>In Eclipse, go to the **File** menu then **Import...**
		<li>Under **General**, select **Existing Projects into Workspace**, as in the following screenshot.
		![Eclipse Project Import Step 1](project-import-step-1.png)
		<li>Select the archive file `intro-data-movement.zip` in the `eclipse` folder, similar to the screenshot below.
		![Eclipse Project Import Step 2](project-import-step-2.png)
		<li>Click the **Finish** button.
	</ol>
</ol>
