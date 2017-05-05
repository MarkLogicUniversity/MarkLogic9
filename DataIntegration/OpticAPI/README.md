# Introduction to the Optic API
Here you'll find the supporting code and examples for the **Introduction to the Optic API** training tutorials.  Some basic familiarity with MarkLogic Server is assumed.

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
The **Introduction to the Optic API** examples are implemented in a MarkLogic Query Console workspace. Content will be imported to the **Documents** database.
<ul>
	<li>With MarkLogic Server setup and running, there are no special database requirements.
	<li>The following steps assume MarkLogic has been installed on your local computer. If not, substitute the server name of `localhost` with  the appropriate MarkLogic server name.
</ul>

###Setup the Documents database and import data
>Note: The following steps are to be done only once before beginning any of the three tutorials: **Using Template Driven Extraction**, **Using SQL** and **Introduction to the Optic API**.

If you have already done the **TDE-Optic-Setup** steps below, skip to the **Import the "Using Optic API" example workspace** below.
<ul>
	<li>Import the **TDE-Optic-Setup** Query Console Workspace.
	<ol>
		<li>With MarkLogic started, in a browser go to the URL of `http://localhost:8000`
		<li>Log in with your MarkLogic admin account.
		<li>On top of the Query window, on the right-hand side of the web page, click the Workspace dropdown.
		<li>Select **Import Workspace...**
		<li>Browse to the downloaded `/MarkLogic9/DataIntegration` folder then the `tde-sql-optic-setup` folder.
		<li>Select the `TDE-Optic-Setup.xml` file then click the **Open** button.
		<li>Click the **Import** button.
	</ol>
	<li>Run the script in the first tab. The other two tabs are to clean up when you no longer want the examples in the **Documents** database.
	<li>Proceed to the next steps for importing the **Using Optic API** example workspace.
</ul>

###Import the "Using Optic API " example workspace
The following steps are used for the **Introduction to the Optic API** tutorial.
<ul>
	<li>Import the **Using Optic API** Query Console Workspace.
	<ol>
		<li>With MarkLogic started, in a browser go to the URL of `http://localhost:8000`
		<li>Log in with your MarkLogic admin account.
		<li>On top of the Query window, on the right-hand side of the web page, click the Workspace dropdown.
		<li>Select **Import Workspace...**
		<li>Browse to the downloaded `/MarkLogic9/DataIntegration` folder then the `OpticAPI` folder.
		<li>Select the `Using Optic API.xml` file then click the **Open** button.
		<li>Click the **Import** button.
	</ol>
	<li>Continue to follow the video and examine the other tabs in the workspace.
</ul>

