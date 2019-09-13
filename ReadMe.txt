1. Test Data:
    1. UserName : sivatest.go@gmail.com
    2. Password : Test@123
    3. Desired Capabilities : Change the Value for respective Devices (Device Name and UDID) 

2. BDD Framework:
    - Cucumber is a testing framework which supports Behaviour Driven Development (BDD).
    - It defines application behaviour in plain meaningful English text using a simple grammar defined by a language called Gherkin.

3. Execution Flow:
   -  Runner class  >>  Feature file  >> Step Definition
   - Feature File is an entry point to the Cucumber tests. A single feature file can contain one or many scenarios. 
   - Step Definition is a java method in a class/file with an annotation(like: @Given, @When, @then, etc) attached to it
   - Runner Class will set up the interaction between feature file and step definition file.

4. Test Report:
    - Path to the test Report : ("user.dir”)/target/cucumber-reports/ {Report Name}.html
    - Open the report  (.html) file in any of the browser for better validation.
