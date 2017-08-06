# JustEat Technical Test
This project contains tests to run against [JustEat](https://www.just-eat.co.uk/) website. It test the following basic scenarios on the website. 
* I should be able to find restaurants in my area
* I should be able to filter the results based on cuisine
* I should be able to filter the restaurant by its name

## Platform
Test has been implemented using
* MacOS v10.12 
* Java v1.8
* Selenium v3
* Maven v3
* Intelli J Idea v2017.1.4 

## Instructions for execution
* Machine with Java 1.8 installed is required for execution. 
* Tests are implemented for google chrome, chromedriver (for mac) is bundled within the project for quick execution. 
* You need to install and setup maven if you wish to run test from command line
`mvn clean test` from the project directory should trigger the execution
* You can also run the test from an IDE like Intelli J Idea as it has maven plugin built in the community edition
`src/test/java/web/ui/BasicTest` is the test class which when run trigger all the tests or 
you can run `src/main/resources/features/BasicTest.feature` directly if cucumber, gherkin plugins are installed in IDE 
* To run the test on eclipse or other IDE, you need to install a maven plugin if it is not already in the distribution