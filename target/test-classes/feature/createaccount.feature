#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@important
Feature: Create Account
  Background: Amazon website should be open on the browser
Given Amazon website should be open on the browser by clicking url "https://www.amazon.ca". 

@tag1
  Scenario: User is allowed to navigate to Create Account.
     
    When  Go to hello,Sign in and then click on Start here link.
    
   Then User must able to click on the link and moved to Create Account page.
    
  
@tag2
  Scenario: Checking the functionality of Create Account with Valid Data.
 
    When Go to hello,Sign in and then click on Start here link.
    And Enter valid name in Your Name field.
    And Enter valid emailid or mobile number in Mobile number or email field.
    And Enter valid password of six characters in Password field.
    And Enter same password as Password field in Again Password field.
    And Click on Verify email.
    
    Then All the valid input data must be accepted and account of the user must be created..
  
     
@tag3
Scenario: Checking the functionality of Create Account with Invalid Data.
     
    When Go to hello,Sign in and then click on Start here link.
    And Leave name as blank in Your Name field.
    And Leave emailid or mobile number as blank in Mobile number or email field.
    And Leave password as blank in Password field.
    And Leave Password field as blank in Again Password field.
    And Click on Continue button.
    
    Then User must be on the same page.
    
