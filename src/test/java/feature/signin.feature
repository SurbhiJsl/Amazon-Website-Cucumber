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
Feature: Signin

  Background: Amazon website should be open on the browser.
    Given User must be open the website by clicking url "https://www.amazon.ca".

  @SigninValidEmail
  Scenario: User should be able to signin in his/her account with valid email.
    When Go to Hello, Sign in and then Click on Sign in button.
    And Enter valid email id in Mobile number or email field.
    And Click on Continue button to enter password.
    And Enter valid password in Password field.
    And Click on Sign in button.
    Then User is navigated to his or her account.

  @SigninValidMobileNumber
  Scenario: User should be able to signin in his/her account with valid mobile number.
    When Go to Hello, Sign in and then Click on Sign in button.
    And Enter valid mobile number in Mobile number or email.
    And Click on Continue button to enter password.
    And Enter valid password in Password field.
    And Click on Sign in button.
    Then User is navigated to his or her account.

  @SigninInvalidPassword
  Scenario Outline: Checking the functionality of Sign in with Invalid password.
    When Go to Hello, Sign in and then Click on Sign in button.
    And Enter <emailormobile> in Mobile number or email id.
    And Click on Continue button to enter password.
    And Enter invalid <password> in Password field.
    And Click on Sign in button.
    Then User must not be able to login with invalid password.

    Examples: 
      | emailormobile           | password |
      | vebeti5990@zamaneta.com |          |
      | vebeti5990@zamaneta.com | Veb      |

  @SigninInvalidEmail
  Scenario Outline: Checking the functionality of Sign in with Blank Email id.
    When Go to Hello, Sign in and then Click on Sign in button.
    And Leave email or mobile number in email or Mobile number field as blank.
    And Click on Continue button to enter password.
    Then User must not be able to login with invalid blank email id.
