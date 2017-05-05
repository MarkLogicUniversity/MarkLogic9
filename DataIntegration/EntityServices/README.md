# Entity Services
Here you'll find the supporting code and examples for the Entity Services training tutorial.  Some basic familiarity with MarkLogic Server is assumed.

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

##Setup the Database and Query Console for the Examples
The Entity Services examples are implemented in a MarkLogic Query Console workspace. Content will be imported to the **Documents** database.
<ul>
	<li>With MarkLogic Server setup and running, there are no special database requirements.
	<li>The following steps assume MarkLogic has been installed on your local computer. If not, substitute the server name of `localhost` with  the appropriate MarkLogic server name.
	<li>Import the Entity-Services Query Console Workspace.
	<ol>
		<li>With MarkLogic started, in a browser go to the URL of `http://localhost:8000`
		<li>Log in with your MarkLogic admin account.
		<li>On top of the Query window, on the right-hand side of the web page, click the Workspace dropdown.
		<li>Select **Import Workspace...**
		<li>Browse to the `DataIntegration` folder then the `EntityServices` folder.
		<li>Select the `Entity-Services.xml` file then click the **Open** button.
		<li>Click the **Import** button.
	</ol>
	<li>Begin the examples with the **Load Data** tab in the `Entity-Services` workspace.
		<ol>
			<li>Select the **Load Data** tab.
			<li>Ensure the **Database:** dropdown is set to **Documents**.
			<li>Click the **Run** button to begin loading the example content to the **Documents** database.
		</ol>
	<li>Continue to follow the video and examine the other tabs in the workspace.
</ul>

###Note about the `Code Generate` tab in the Query Console Workspace
After generating the code, one of the generated files must be modified to continue running the examples.

In the MarkLogic `\Modules` directory within the MarkLogic installation directory:
<ol>
	<li>Edit the file `Race-0.0.1.xqy` in any text editor.
	<li>Around line 33, insert the following ***after*** the last `import module ...` statement:
	
	import module namespace functx = "http://www.functx.com"  
		at "/MarkLogic/functx/functx-1.0-doc-2007-01.xqy";
	
<li>Around line 159, change line:

```
=>   map:with('duration',               xs:dayTimeDuration($source-node/duration))  
```
to:

```
=>   map:with('duration',               functx:dayTimeDuration((), (), xs:decimal($source-node/duration), ()))
```	

<li>Save the file.
<li>Proceed on to the `Raw to instance` Query Console workspace tab. 
</ol>