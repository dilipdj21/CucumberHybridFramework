Feature: Search Functinality

Scenario: User searches for valid product
Given User opens the application 
When  User enters valid product "HP" into search box field
And  User clicks on search button
Then User should get valid product displayed in search results

Scenario: User searches for invalid product
Given User opens the application 
When  User enters invalid product "honda" into search box field
And  User clicks on search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the application 
When  User doesnt enter any product in search field
And  User clicks on search button
Then User should get a message about no product matching