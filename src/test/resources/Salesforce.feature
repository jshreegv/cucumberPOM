
Feature: Login to Salesforce Application

Background: User navigates to Salesforce
 		Given User is on Salesforce Login page
 		
 		
  Scenario: Login error message
  	When User is on "LoginPage"      
    When User enter username as "admin123"
    When User clicks on Login button
    Then Error message must be displayed

 
  Scenario: Login with valid credentials
  	When User is on "LoginPage"
    When User enter username as "jshree@tekarch.com"
    When User enter password as "december21"
    When User clicks on Login button
    When User is on "HomePage"
    Then verify home page is displayed
 
  
  Scenario: Check Remember Me
  	When User is on "LoginPage"
    When User enter username as "jshree@tekarch.com"
    When User enter password as "december21"
   	When User selects the check remember me check box
    When User clicks on Login button
  	When User is on "HomePage"
    Then verify home page is displayed
  	When User clicks on usermenu drop down button
  	When User clicks on logout button
  	When User is on "LoginPage"
 		Then verify username in username text box
 
 
 Scenario: Forgot Password
  	When User is on "LoginPage"
    When User clicks on Forgot Your Password link
    When User is on "ForgotPasswordPage"
    When User enters username as "jshree@tekarch.com"
    When User clicks on Continue button
 		Then Password reset message page is displayed as "Check Your Email"
 
 
 Scenario: Login with invalid credentials
 		When User is on "LoginPage"
    When User enter wrong username as "123"
    When User enter wrong password as "22131"
    When User clicks on Login button
    Then Error message is displayed and validate the error message 	
  	
  
 