# Introduction to the Optic API
Here you'll find the supporting code and examples for the **Introduction to the Optic API** training tutorials.  Some basic familiarity with MarkLogic Server is assumed.

## Getting Started

1. Download MarkLogic:
	* http://developer.marklogic.com
2. Install, start, and initialize MarkLogic on your local machine:
	* http://docs.marklogic.com/guide/installation

## Setup the Database and Query Console for the Examples
The **Introduction to the Optic API** examples are implemented in a MarkLogic Query Console workspace. Content will be imported to the **Documents** database.

* With MarkLogic Server setup and running, there are no special database requirements.
* The following steps assume MarkLogic has been installed on your local computer. If not, substitute the server name of `localhost` with  the appropriate MarkLogic server name.

### Setup the Documents database and import data
>Note: The following steps are to be done only once before beginning any of the three tutorials: **Using Template Driven Extraction**, **Using SQL** and **Introduction to the Optic API**.

If you have already done the **TDE-Optic-Setup** steps below, skip to the **Import the "Using Optic API" example workspace** below.

Otherwise, please do the following.

* Browse to the downloaded `/MarkLogic9/DataIntegration` folder then the `tde-sql-optic` folder.
* Refer to the instructions in the **README.md** file in the `tde-sql-optic` folder.
* Proceed to the next steps for importing the **Using Optic API** example workspace.

### Import the "Using Optic API " example workspace
The following steps are used for the **Introduction to the Optic API** tutorial.

* Import the **Using Optic API** Query Console Workspace.
	1. With MarkLogic started, in a browser go to the URL of `http://localhost:8000`
	2. Log in with your MarkLogic admin account.
	3. On top of the Query window, on the right-hand side of the web page, click the Workspace dropdown.
	4. Select **Import Workspace...**
	5. Browse to the downloaded `/MarkLogic9/DataIntegration` folder then the `OpticAPI` folder.
	6. Select the `Using Optic API.xml` file then click the **Open** button.
	7. Click the **Import** button.
* Continue to follow the video and examine the other tabs in the workspace.

