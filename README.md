# Automated tests in Java with Cucumber and Selenium WebDriver #

This Repository related to testing hudl website login using Selenium and Cucumber.

Test scenarios described in the feature files located here ./src/test/resources/features/Login.feature

## Installation ##

You need to have [Java 8 JDK] installed along with [maven]

To run the tests locally with Chrome, install ChromeDriver, add its location to your system PATH and add webdriver.chrome.driver=path/to/the/driver to your local variables.

To install all dependencies, run 

```console
$ mvn clean install
```

## Running tests ##

```console
$ mvn test
```

By default, tests will run on Chrome. To change that, specify `-Dbrowser={browser}` where `{browser}` is either `chrome` or `firefox`. If you haven't added the chrome driver path to your local variables, you can add it directly in the run command with the option `-Dwebdriver.chrome.driver=path/to/the/driver`.

You can also select specific scenarios to execute using `-Dcucumber.options="--tags @your_tag"`. here tag is @FunctionTests

## Project Execution ##
-Open IntelliJ
-Import project
-Build Project
-Run Maven Clean, Install and Test

Or Using Zip file
Using Zip and command line

Download Zip
-Unzipped project
-Go to project location using terminal
-run commands a) mvn clean b) mvn test

##Generating the test report##
This project is using Allure Report to automatically generate test report Command line to generate it in two ways:

mvn allure:serve: To open report in browser
mvn allure:report: To generate project report at target/site/allure-maven-plugin folder

Sample reports attached in email

##Inside Website Testing Framework hudl:##
src/test/java This folder contains 3 packages

-automatedtest.hudl
>BASE PAGE
>DRIVER
>PAGES
>STEP DEF
-runners

Inside -automatedtests.hudl - We have base page to include all common methods
infrastructure.driver setup driver and close
Pages include - all POM Model
stepDef Includes step definitions based on feature files

src/test/resources

1. features
2. allure.properties
3. config.properties

screenshot_1<img width="1425" alt="screenshot_1" src="https://user-images.githubusercontent.com/43905401/123493007-15005c80-d613-11eb-9289-70ca03e51f0d.png">

screenshot_2<img width="1425" alt="screenshot_2" src="https://user-images.githubusercontent.com/43905401/123493013-1a5da700-d613-11eb-868d-ef9d0b0d80df.png">

