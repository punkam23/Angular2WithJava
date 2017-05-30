

# Angular 2 with Java backend example

This is an example about implementing a single page application using MVVC pattern.
More information will be added , about each single component used in the application for his deployment.

Please note that this code is very experimental and regularly modified.


Stack:
- Spring Boot on the backend
- AngularJS 2 on the frontend
- TypeScript as frontend language
- packaging optimized by webpack

Prerequisites:
- install maven and npm

####For development (js server + java server):
1. Package the java project or launch Application.java from your IDE

 * mvn clean
 * mvn install (this command will generate the war of the application in targer folder)

2. launch the backend spring boot application, it runs in localhost:8082
   Open an command line in the root of the application.
   With this command spring boot will start the server

    * java -jar [PARENT_MODULE]/server/target/server-0.1.4-SNAPSHOT.war
3. Launch the webpack server for the frontend
   Open an command line in the root of the application.
    * cd [PARENT_MODULE]/webClient/src
    * npm start

4. go on http://localhost:8080

#####For production (only one war, Javascript souces optimized):
1. in the parent project directory execute
    * mvn clean package
2. launch the backend spring boot application, it runs in localhost:8082
    * java -jar [PARENT_MODULE]/server/target/server-0.14-SNAPSHOT.war
3. open your browser and visit http://localhost:8082


# Protractor Automation example

Protractor is an end-to-end test framework for Angular and AngularJS applications
Built on top of WebDriverJS, which uses native events and browser-specific
drivers to interact with your application as a user would. You no longer need to add waits and sleeps to your test


Use npm to install Protractor
    1.  npm install -g protractor

The webdriver-manager is a helper tool to easily get an instance of a Selenium Server running
    1.  webdriver-manager update
    2.  webdriver-manager start

Protractor needs two files to run, a spec file and a configuration file.
    1.  Open new terminal
    2.  Goto cd webClient/testProtractor
    3.  run the test,
            protractor conf.js

