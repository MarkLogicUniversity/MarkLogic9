# Entity Services
Here you'll find the supporting code and examples for the Entity Services training tutorial.  Some basic familiarity with MarkLogic Server is assumed.

## Getting Started
1. Download MarkLogic:
	* http://developer.marklogic.com
2. Install, start, and initialize MarkLogic on your local machine:
	* http://docs.marklogic.com/guide/installation

## Setup the Database and Query Console for the Examples
The Entity Services examples are implemented in a MarkLogic Query Console workspace. Content will be imported to the **Documents** database.

* With MarkLogic Server setup and running, there are no special database requirements.
* The following steps assume MarkLogic has been installed on your local computer. If not, substitute the server name of `localhost` with  the appropriate MarkLogic server name.
* Import the Entity-Services Query Console Workspace.
	1. With MarkLogic started, in a browser go to the URL of `http://localhost:8000`
	2.  Log in with your MarkLogic admin account.
	3. On top of the Query window, on the right-hand side of the web page, click the Workspace dropdown.
	4. Select **Import Workspace...**
	5. Browse to the `DataIntegration` folder then the `EntityServices` folder.
	6. Select the `Entity-Services.xml` file then click the **Open** button.
	7. Click the **Import** button.
* Begin the examples with the **Load Data** tab in the `Entity-Services` workspace.
	1. Select the **Load Data** tab.
	2. Ensure the **Database:** dropdown is set to **Documents**.
	3. Click the **Run** button to begin loading the example content to the **Documents** database.
* Continue to follow the video and examine the other tabs in the workspace.

### Note about the `Code Generate` tab in the Query Console Workspace
After generating the code, one of the generated files must be modified to continue running the examples.

In the MarkLogic `\Modules` directory within the MarkLogic installation directory:

1. Edit the file `Race-0.0.1.xqy` in any text editor.
2. Around line 33, insert the following ***after*** the last `import module ...` statement:
	
	```
	import module namespace functx = "http://www.functx.com"  
		at "/MarkLogic/functx/functx-1.0-doc-2007-01.xqy";
	```
	
3. Around line 159, change line:
	
	```
	=>   map:with('duration',               xs:dayTimeDuration($source-node/duration))  
	```
	to:
	
	```
	=>   map:with('duration',               functx:dayTimeDuration((), (), xs:decimal($source-node/duration), ()))
	```	

4. Save the file.
5. Proceed on to the `Raw to instance` Query Console workspace tab. 
