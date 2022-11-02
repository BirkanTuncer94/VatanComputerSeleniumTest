#Author
#Date
#Description


Feature: Feature to test login, write samsung, approve to find some items

		Scenario: login to the website
	Given user clicks to the login button
	When user enters email and password
	And click on login button
	Then user is navigated to the home page again 


	 Scenario: Write samsung to the search bar and check it
	Given user clicks to the search bar
	When user enters word
	And click on search button
	Then user is navigated to products page
	
	 