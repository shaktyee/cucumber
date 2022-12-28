Feature: login functionality

Scenario: validate login and logout functionality with valid user credentials

Given user launch chrome browser
When user open app "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And user enter email as "admin@yourstore.com" and password as "admin"
And user click on Login
Then page Title should be "Dashboard / nopCommerce administration"
When user click on Logout link
Then page Title should be "Your store. Login"
And close the browser
		