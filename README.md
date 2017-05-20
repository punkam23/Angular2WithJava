[![Build Status](https://travis-ci.org/marco76/SpringAngular2TypeScript.svg?branch=master)](https://travis-ci.org/marco76/SpringAngular2TypeScript) [![star this repo](http://githubbadges.com/star.svg?user=marco76&repo=SpringAngular2TypeScript&style=default)](https://github.com/marco76/SpringAngular2TypeScript)
[![fork this repo](http://githubbadges.com/fork.svg?user=marco76&repo=SpringAngular2TypeScript&style=default)](https://github.com/marco76/SpringAngular2TypeScript/fork)

# SpringAngular2TypeScript

This is an example of implementation of a single page application using MVVC patter.
More information will be adde , about each single componnet used in the application for his deployment.

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
