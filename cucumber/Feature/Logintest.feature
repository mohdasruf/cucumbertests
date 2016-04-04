Feature: Login Action

@PositiveScenario
Scenario Outline: Successful Login with Valid Credentials
	Given User is on Home Page
	When User Navigate to LogIn Page
	And User enters "<Username>" and "<Password>"
	Then Message displayed Login Successfully
Examples:
	|Username|Password|
	|d681982@gmail.com|Dsr-301282|
	|d681982@gmail.com|Dsr-301282|
	
@NegativeScenario
Scenario: Successful Login with InValid Credentials
	Given User is on Home Page
	When User Navigate to LogIn Page
	And User enters invalid Username and Password
	Then Message displayed Login unSuccessfull

