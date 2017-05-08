# Using Template Driven Extraction
Here you'll find the supporting code and examples for the **Using Template Driven Extraction** training tutorials.  Some basic familiarity with MarkLogic Server is assumed.

## Getting Started
1. Download MarkLogic:
	* http://developer.marklogic.com
2. Install, start, and initialize MarkLogic on your local machine:
	* http://docs.marklogic.com/guide/installation

## Setup the Database and Query Console for the Examples
The **Using Template Driven Extraction**, **Using SQL** and **Introduction to the Optic API** examples are implemented in a MarkLogic Query Console workspace. Content will be imported to the **Documents** database.

* With MarkLogic Server setup and running, there are no special database requirements.
* The following steps assume MarkLogic has been installed on your local computer. If not, substitute the server name of `localhost` with  the appropriate MarkLogic server name.

### Setup the Documents database and import data
>Note: The following steps are to be done only once before beginning any of the three tutorials: **Using Template Driven Extraction**, **Using SQL** and **Introduction to the Optic API**.

If you have already done the **TDE-Optic-Setup** steps below, skip to the **Import the "Using TDE" example workspace** below.

Otherwise, please do the following.

* Browse to the downloaded `/MarkLogic9/DataIntegration` folder then the `tde-sql-optic` folder.
* Refer to the instructions in the **README.md** file in the `tde-sql-optic` folder.
* Proceed to the next steps for importing the **Using TDE** example workspace.

### Import the "Using TDE" example workspace
The following steps are used for the **Using Template Driven Extraction** tutorial.

* Import the **Using TDE** Query Console Workspace.
	1. With MarkLogic started, in a browser go to the URL of `http://localhost:8000`
	2. Log in with your MarkLogic admin account.
	3. On top of the Query window, on the right-hand side of the web page, click the Workspace dropdown.
	4. Select **Import Workspace...**
	5. Browse to the downloaded `/MarkLogic9/DataIntegration` folder then the `TDE` folder.
	6. Select the `Using TDE.xml` file then click the **Open** button.
	7. Click the **Import** button.
* Continue to follow the video and examine the other tabs in the workspace.
