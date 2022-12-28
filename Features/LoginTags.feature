Feature: Login Functionality

@ibm_sanity
Scenario: validate login and logout functionality with valid user credentials

Given user launch chrome browser
When user open app "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter email as "admin@yourstore.com" and password as "admin"
And user click on Login
Then page Title should be "Dashboard / nopCommerce administration"
When user click on Logout link
Then page Title should be "Your store. Login"
And close the browser

@ibm_regression
Scenario Outline: validate login functionality with multiple user 

Given user launch chrome browser
When user open app "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter email as "<email>" and password as "<pass>"
And user click on Login
Then page Title should be "Dashboard / nopCommerce administration"
When user click on Logout link
Then page Title should be "Your store. Login"
And close the browser



Examples:

		| 						email 										|						pass 							|
		|				admin@yourstore.com							| 					admin							|
		|				admin123@yourstore.com					| 					admin123					|