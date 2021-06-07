
Feature: Customers

 	Background: Login to nopcommerce.com
 		Given User is on Login Page
 		When User enters credentials
 		And Click on Login button
		Then User must navigate to Dashboard page
 		
 	@AddCustomers @AllTest
  Scenario Outline: Add new Customers
    When User navigates to customer page
    And Click on Add New button
    Then User must see Customer info form
    When User enters customer info as email <password> <firstname> <lastname> <DOB>
    And Click on Save button
    Then Customer must see <message>
    
    Examples: 
      | password  | firstname | lastname  | DOB 					|message|
      | "Test123" | "John"    | "Jackman"  | "4/25/1975"  |"The new customer has been added successfully."|
  
  @SearchCustomers @AllTest    
	Scenario Outline: Search Customer
		When User navigates to customer page
		And Search with <firstname> and <lastname>
		When User click on search Button
		Then User should see searched customer
		
		 Examples: 
      | firstname | lastname  |
      | "John"    | "Jackman" |