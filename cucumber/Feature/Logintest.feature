Feature: Login Action

@PositiveScenario
Scenario Outline: Successful Login with Valid Credentials
	Given User is on Home Page
	When User Navigate to LogIn Page
	And User enters "<Username>" and "<Password>"
	Then Message displayed Login Successfully
Examples:
	|Username|Password|
	|xxx@gmail.com|XXX|
	|xxx@gmail.com|XXX|
	
@NegativeScenario
Scenario: Successful Login with InValid Credentials
	Given User is on Home Page
	When User Navigate to LogIn Page
	And User enters invalid Username and Password
	Then Message displayed Login unSuccessfull

