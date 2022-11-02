#Author
#Date
#Description


Feature: Feature to select third item from products page, 
then add it to favorites then go to your accounts favorites part and check the item.

		Scenario: Select the third item from products page
	Given user clicks to the third item
	When user clicks the favorite icon
	And pop up shows up
	And user click to the close button on pop up
	Then user is navigated to the product detail page 


	 Scenario: go to the favorites and check it
	Given user clicks to the my account
	When user clicks favorites
	Then user is navigated to favorites page
	Then item will be checked
	
	 