@Author : Sivasankaramalan  Gunasekarasivam

BDD Framework for Mobile Applications Automation with Appium

Introduction:

	1. Cucumber is a testing framework which supports Behaviour Driven Development (BDD).
	
	2. It defines application behavior in plain meaningful English text using a simple grammar defined by a language called Gherkin.

Execution Flow:

	Runner class  >>  Feature file  >> Step Definition
	
What is Cucumber Feature File?

	1. Feature File is an entry point to the Cucumber tests.
	2. This is the file where you will describe your tests in Descriptive(Gherkin) language (like English).
	3. It is an essential part of Cucumber, as it serves as an automation test script as well as the live document.
	4. A single feature file can contain one or many scenarios
	
Sample Feature File:

Feature: working with zoo site

	Scenario: 
		login to the zoo website
		Given navigate to the zoo
		When clicking on "contact_link"
		Then check title is of "Contact"
		And close the browser

	Scenario: 
		check title
		Given navigate to the zoo
		When clicking on "adoption_link"
		Then check title is of "Adoption
		And close the browser
	
Keywords:

	Feature: Defines what feature you will be testing in the tests below
	Scenario: Defines the scenario that you will test
	Given: Tells the pre-condition of the test
	When:  Defines the condition of the test
	And: Defines additional conditions of the test
	Then: States the postcondition. You can say that it is an expected result of the test.
	
What is Step Definition File?

	A Step Definition is a java method in a class/file with an annotation(like: @Given, @When, @then, etc) attached to it, followed by the pattern(like: “^click on "([^"])"$”).
	This pattern is used to link the Step Definition to all the matching (Gherkin)Steps => this code is what Cucumber would execute when it sees a Gherkin Step. Cucumber finds the Step Definition file with the help of Glue code in Cucumber Options.
	
Cucumber Runner Class:

	This class will set up the interaction between the feature file and step definition file.
	
What is Cucumber Options?:

	In layman language @CucumberOptions are like property files or settings for your test. @CucumberOptions enables us to do all the things that we could have done if we have used the cucumber command line.
	This is very helpful and of utmost importance, if we are using IDE such as eclipse only to execute our project.

Parameterization:

	Parameterization in cucumber is basically done when you have the same scenario but few events are changing, to perform parameterization in cucumber, enter the keyword(event) in double-quotes.
	
Background:

	Background Keyword is written at the very starting of the feature file, Any statement or group of statements added to the background will execute before the execution of all the scenarios mentioned in that feature file.	

	
