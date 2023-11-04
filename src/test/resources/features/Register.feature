Feature: Registration Functinality

Scenario: User creates an account with only mandatory fields
Given User navigates to register account page
When  User enters the details into below fields
|firstname|Kane|
|lasttname|William|
|telephone|1122334455|
|passwrod|kane123|
|confirmpassword|kane123|
And  User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to register account page
When  User enters the details into below fields
|firstname|Andy|
|lasttname|Guest|
|telephone|7869574545|
|passwrod|adfaf231|
|confirmpassword|adfaf231|
And  User selects privacy policy
And User selects Yes for news letter
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates an duplicate account
Given User navigates to register account page
When  User enters the details into below fields with duplicate email
|firstname|Kane|
|lasttname|William|
|email|kane123@gmail.com|
|telephone|1122334455|
|passwrod|kane123|
|confirmpassword|kane123|
And  User selects privacy policy
And User selects Yes for news letter
And User clicks on continue button
Then User account should get a proper warning message

Scenario: User creates an account without any fields
Given User navigates to register account page
When  User doesnt enter any details into fields
And User clicks on continue button
Then User account should get a proper warning message for mandatory fields

