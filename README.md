# cucumber-spring
Acceptance Tests for a Spring Boot REST Webservice using Cucumber Spring integration

## Project Description
This project is to demonstrate how Cucumber Spring integration can be used to implement Acceptance Tests Driven Development (ATDD) for a Spring Boot Microservice. Project was developed using:
1. Spring Boot 2.4.0 - for the REST Webservice
2. H2 - For the in memory database
3. Lombok - annotations and clean code
4. Cucumber - 6.10.4 - latest version
5. Sprint Test and Sprint Boot Test - to enabled Cucumber spring integration

## Reasons to implement ATDD
1. Greater collaboration between developers and QA Engineers during feature implementation, therby leading to lesser defects
2. Clear and concise acceptance criteria in the form of BDD scenarios
3. Early feedback
4. Executing acceptance tests as part of build pipeline leads to Improved code quality

## Design

### Spring Boot REST Webservice: 
1. A simple REST service to add/retrive details of books has been developed
2. Main Application can be found at _src/main/java/com/automation/SpringBootApp.java_

### Acceptance Tests:
1. Acceptance Test written as Cucumber feature file can be found at _src/test/resources/features/Books.feature_ 
2. This test submits a POST request for the /api/books service with a sample book details
3. Cucumber Spring integration is implemented in the class - _src/test/java/com/automation/demo/integration/SpringIntegration.java_

### Prerequisites to Run the project
1. Environment Requirements: Maven v3.5.4 or later, Java 1.8 or later, Eclipse or IntelliJ IDE

## Execution Instructions
1. After cloning the project, compile using the IDE Maven plugin or `mvn clean compile`
2. Review the code to understand the flow
3. _src/main/java_ - has the code for the Spring Boot REST Webservice
4. _src/test/java_ - has the code for Cucumber tests implementation
5. _src/test/resources_ - has the feature file

### Command Line:

`mvn clean install` - This will run the cucumber acceptance tests before the project is packaged into JAR. Any tests failure will stop the project to be packaged

### Run Configuration:

Alternative way to run the project is by use of:
TestRunner at _src/test/java/com/automation/demo/TestRunner.java_ or
Using IDE Run configuration, for IntelliJ:
   
   1. Right click project and click Run as
   2. Select Maven Build
   3. Enter goals - clean install
   4. Click Run

### Reports Location:
After execution, reports can be accessible via the link displayed in the maven logs (provided by Cucumber latest version).

When this project is integrated in a Jenkis pipeline, _cucumber.json_ file in _target/cucumber-reports_ can be integrated in the Build using Jenkins Cucumber plugin