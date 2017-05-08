# tde-sql-optic
Here you'll find the supporting code and examples for the **Using Template Driven Extraction**, **Using SQL** and **Introduction to the Optic API** training tutorials.  Some basic familiarity with MarkLogic Server is assumed.

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
The following steps are to be done only once before beginning any of the three tutorials: **Using Template Driven Extraction**, **Using SQL** and **Introduction to the Optic API**.

* Import the **TDE-Optic-Setup** Query Console Workspace.
	1. With MarkLogic started, in a browser go to the URL of `http://localhost:8000`
	2. Log in with your MarkLogic admin account.
	3. On top of the Query window, on the right-hand side of the web page, click the Workspace dropdown.
	4. Select **Import Workspace...**
	5. Browse to the downloaded `/MarkLogic9/DataIntegration` folder then the `tde-sql-optic` folder.
	6. Select the `TDE-Optic-Setup.xml` file then click the **Open** button.
	7. Click the **Import** button.
* Ensure the path to the `/MarkLogic9/DataIntegration/tde-sql-optic` folder is correct in the first tab. 
* Run the script in the first tab. The other two tabs are to clean up when you no longer want the examples in the **Documents** database.
* Proceed to the next steps for importing either the **Using TDE**, **Using SQL** or **Using Optic API** example workspaces. Refer to the **README.md** files in the appropriate folders.
