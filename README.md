# Virtual-Facility-Coding-Challenge Project
    @c-gray, @faisalnwz or @miltonlopezjr Please read the following Instructions below and you will be able to run it.
# How to pull Project from eclipse
    Go to Eclipse Upper Left Corner, Click on File then you're able to see a dropdown, 
    click on Import, and a new window will appear.
    Then click on Git folder when extended you will be able to see (Project from git) 
    and Select it Then Click on next, again another window will appear and select clone URL
    displayed URL Window Enter the flowing URL 
    (https://github.com/QA-Alam/Virtual-Facility-Coding-Challenge.git) And hit next, 
    select next again and then finish. 
    When installing is finished, you have to do maven life cycle 
    a. Maven Clean 
    b. Maven Install
    c. Maven Update 
    When maven update is completed then under project, you're able to see Sanity.xml file, 
    right click on xml file and run as a TestNG then it will run.
    When it is done, you're able to see under project, extend report folder under the folder
    there is another file named (ExtentReportResults.html)
    Right click on this file and open with web browser and you will be able to see report and if test cases
    fail you will be able to see with screen shot report.
# Requirements to Run Project.
    Java, Maven, TestNG, Apache POI, Log 4J, JDBC, Extend Report Automation Starter
    This is a simple project that would allow anyone to get up and running with Java, Maven, Selenium and TestNG. 
    It also explains how to execute a simple test that will assert the title of a page.
    Currently the project has one test that will navigate to (https://www.binance.com/en) and 
    verify the title matches Virtual Facility
# Table of Contents
    There are a few things we need before running the tests. These are:
    Java Installation / Update
    Setting up Eclipse
    Installing TestNG
    Setting up Maven
    Running the Project
    Not mandatory if needed Install Oracle 11g, SqlDeveloper

# Environments variable Setup:
    From Terminal/Cmd
    Special Notes
    Java Installation / Update
    Check your system to see if you have the 1.8 Java version installed.
    Command:
    $ java -version
    If you do not have the latest Java installed, find out how to install Java.
    Ensure your JAVA_HOME environment to the location of the installed JDK. Find out how to do that.
    Setting up Eclipse
    Navigate to the Eclipse download page and download eclipse for Java EE developers.
    Installing TestNG
    Installing a Plugin:
    Inside Eclipse, click on the Help menu
    Select Install New Software.
    Install New Software-1
    Locating the Plugin:
    Click the Add button
    Enter http://beust.com/eclipse in the Location field
    Install New Software-2
    Selecting the Plugin:
    Ensure the TestNG checkbox is selected
    Click the "Next" button to the right bottom
    Install New Software
    Finishing up:
    Accept the terms of the license agreement
    Click on the Finish button
    Install New Software
    Setting up Maven
    Download Maven.
# Maven Installation:
    Unzip the distribution archive to the directory you wish to install Maven. 
    I extracted maven to my Documents folder
    Add Maven to the PATH. More information can be found in the README.txt in the zip folder.
    Here's an example:
    how I added Maven to my PATH on MacOS. I added the following to the ~/.bash_profile.
    $ export PATH=/Users/admin/Documents/Software/apache-maven-3.6.0/bin:$PATH
    Then sourced (execute) the content of the ~/.bash_profile
    $ source ~/.bash_profile
    Verify Maven was correctly installed

# Check Maven Version Command from CMD:
    $ mvn -version
    Maven dependencies are crucial to running any Maven project.

# Maven dependencies:
    Maven dependencies contains key references to libraries that a Maven project needs to execute. 
    The pom.xml in the root of a Maven project file stores the dependencies (similar to the package.json 
    for Node and gemfile for Ruby) for a project.

# How to Run the Project from eclipes:
    From Eclipse
    Import this project into Eclipse
    Right click the project, then select Run as Maven Clean, Maven Install then the tests will start running.
    Following the above steps executes the configurations found in the testing.xml file by default.
    From the Command Line
    Navigate to the location of project then execute mvn clean then mvn install/test.

# Also I placed all the browsers under the project Driver folder:
    So you’re able to run Chrome browser, 
    IE browser, Microsoft Edge, Gecko Driver which is an extension of Firefox Driver and Headless browser. 
    By default it runs on Chrome Browser but if you want to run with another browser so you have to go 
    src/main/java extend virtualfacility.config.copy then open the file under and change the browser name. 

# If you want to see all the log files: 
    Under the project I have a folder with the file log which under there is all log files.

# Expected output: 
    After successfully running testcases you will be able to see On the Project ExendsReport Folder click on folder                        (ExtentReportResults.html) Right Click on file, Open with Chrome Browser, then you?re able to see extends 
    reports each test cases all    steps verify With Assertions, if it fails Any test cases display Report with screen shot.
# Expected Test Output:
    (If Needed DB Report): Install Oracle 11G, SqlDeveloper Then Create UserNAme = QA, PassWord = Alam
    A) Create Table with Below Command 
    CREATE TABLE VirtualFacility (
    TEST_ID varchar(1000),
    DESCRIPTION varchar(4000),
    Expected varchar(4000),
    Actual varchar(4000),
    Status varchar(1000));
# Run in SqlDeveloper 
    With this query (Select * from VirtualFacility;) If created table displayed A)TEST_ID, B)DESCRIPTION C)Expected,
    D)Actual, E)Status    Empty C) This command has to be Remove from (Select This code and Eclipse Upper Lept Conner 
    Source Then Click on (Remove Block Command)
    
        /*
	 * @BeforeSuite public void dbTabledelete() throws Throwable {
	 * 
	 * DatabaseList.delecteTable(); }
	 */
    After Excitation Completed if you run again this query  (Select * from VirtualFacility;) you're Able to see 
    Data base Report status.

# Special Notes:
    Ensure Chrome Browser Latest Version,
    Ensure FF version 48 or higher is installed

# Extra Notes.
      1-	Java Programming language
      2-	Selenium WebDriver  version – 3.11.0
      3-	Maven Build tool  version – 3.6.0
      4-	Eclipse IDE
      5-	TestNG  version 6.14.3
      6-	JDBC
      7-	Apache POI
      8-	GitHub
      9-	Extend Report
# Also I placed all the browsers under the project Driver folder:
     So you’re able to run Chrome browser, IE browser, Microsoft Edge, Gecko Driver which is an extension 
     of Firefox Driver and Headless browser. By default it runs on Chrome Browser but if you want to run
     with another browser so you have to go src/main/java extend virtualfacility.config.copy 
     then open the file under and change the browser name. 

# If you want to see all the log files:
     Under the project I have a folder with the file log which under there is all log files.
     I’m also using Selenium Page Factory concept for all elements store as an object repository, 
     Utility package for all common utility, Extend Report for Generate Reports with Screen Shots, 
     and either TestNG XML file for running test cases or Bat file. 
     Also, with this Framework you will be able to configure for Virtual Facility project and gradually
     you can implement this with use      test cases as well as future test cases. 

# I faced a couple of challenges while building Frameworks and executing test cases:
    A.	Identification Object, I overcame this with XPath Method
    B.	Synchronization, I overcame this with different kinds of wait like implicit, explicit, pageload
    C.	Input Text Box, I overcame this using different explicit wait.
    D.	I had to configure all tools so I had to match all tools versions.
    E.	I faced a couple of exceptions, I overcame this with Try Catch block. 
    
# OutCome Result:
    [RemoteTestNG] detected TestNG version 6.14.3
    I am in onStart method Virtual Facility Test
    INFO [main] (BasePage.java:63)- ******** I am a chrome browser*********
    Starting ChromeDriver 75.0.3770.8 (681f24ea911fe754973dda2fdc6d2a2e159dd300-refs/branch-heads/3770@{#40}) on port 17529
    Only local connections are allowed.
    Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
    [1567518439.796][WARNING]: This version of ChromeDriver has not been tested with Chrome version 76.
    Sep 03, 2019 9:47:20 AM org.openqa.selenium.remote.ProtocolHandshake createSession
    INFO: Detected dialect: W3C
    I am in onTestStart method Virtual_Facility_Coding_Challenge_1 start
    INFO [main] (MasterPageFactory.java:201)- ******** User Able to Click BNB_BTC Link *********
    INFO [main] (MasterPageFactory.java:204)- ******** User Able to Click BNB_BTC Link successfully *********
    INFO [main] (MasterPageFactory.java:206)- ******** User Able to verify Stock Chart *********
    INFO [main] (MasterPageFactory.java:209)- ******** User Able to verify Stock Chart successfully *********
    INFO [main] (MasterPageFactory.java:211)- ******** User Able to verify Stock limit *********
    INFO [main] (MasterPageFactory.java:214)- ******** User Able to verify Stock limit successfully *********
    INFO [main] (MasterPageFactory.java:216)- ******** User Able to verify market limit *********
    INFO [main] (MasterPageFactory.java:219)- ******** User Able to verify market limit successfully*********
    INFO [main] (MasterPageFactory.java:221)- ******** User Able to verify 24h price Changing *********
    I am in onTestSuccess method Virtual_Facility_Coding_Challenge_1 succeed
    INFO [main] (BasePage.java:63)- ******** I am a chrome browser*********
    Starting ChromeDriver 75.0.3770.8 (681f24ea911fe754973dda2fdc6d2a2e159dd300-refs/branch-heads/3770@{#40}) on port 21596
    Only local connections are allowed.
    Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
    [1567518486.120][WARNING]: This version of ChromeDriver has not been tested with Chrome version 76.
    Sep 03, 2019 9:48:07 AM org.openqa.selenium.remote.ProtocolHandshake createSession
    INFO: Detected dialect: W3C
    I am in onTestStart method Virtual_Facility_Coding_Challenge_2 start
    INFO [main] (MasterPageFactory.java:136)- ******** User Able to enter price *********
    INFO [main] (MasterPageFactory.java:141)- ******** User Able to enter price successfully*********
    INFO [main] (MasterPageFactory.java:145)- ******** User Able to enter Stock Quantity *********
    INFO [main] (MasterPageFactory.java:149)- ******** User Able to enter Stock Quantity successfully *********
    INFO [main] (MasterPageFactory.java:153)- ******** User Able to enter total amount *********
    INFO [main] (MasterPageFactory.java:158)- ******** User Able to enter total amount successfully *********
    INFO [main] (MasterPageFactory.java:254)- ******** User Able to Click on login button *********
    INFO [main] (MasterPageFactory.java:257)- ******** User Able to Click on login button successfully*********
    INFO [main] (MasterPageFactory.java:259)- ******** User Able to verify login box page appear *********
    INFO [main] (MasterPageFactory.java:262)- ******** User Able to verify login box page appear successfully*********
    INFO [main] (MasterPageFactory.java:264)- ******** User Able to verify login page title *********
    INFO [main] (MasterPageFactory.java:267)- ******** User Able to verify login page title successfully*********
    I am in onTestSuccess method Virtual_Facility_Coding_Challenge_2 succeed
    I am in onFinish method Virtual Facility Test

    ===============================================
    Virtual Facility Test Suite
    Total tests run: 2, Failures: 0, Skips: 0
    ===============================================


    