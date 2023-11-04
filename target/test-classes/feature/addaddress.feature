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
Feature: Add Address

  Background: Amazon website should be open on the browser.
    Given Amazon website is opened by the user on the browser by clicking url "https://www.amazon.ca".
    And User must be Signedin.

    @AddAddressPage
   Scenario: Checking the functionality if the user is navigated to Add Address page.
    When Click on Account & lists.
      And Click on Your Addresses.
   Then User must navigate to Add Address page.
  
  @AddAddressValidData
   Scenario: Checking the functionality of Your Address with Valid Data.
     When Click on Account & lists.
    And Click on Your Addresses.
    And Click on Add Address.
    And Select country as Canada.
    And Enter Valid Full Name in Full Name field.
    And Enter Valid Phone Number in Phone Number field.
   And Enter Valid Address in Address first field.
    And Enter Valid Address in Address second field.
    And Enter a city of Canada
    And Select an option from drop down list of Province.
    And Enter a valid postal code.
    And Click on Add AddressButton.
    And Select Original Address RadioButton.
    And Click on Save Address.
   Then Address must be saved in customer account address module.
  
  @AddAddressInvalidData
  Scenario Outline: Checking the functionality of Your Address with Invalid Data.
    When Click on Account & lists.
    And Click on Your Addresses.
    And Click on Add Address.
    And Select country as Canada.
    And Enter invalid <Full Name> in Full Name field.
    And Enter invalid <Phone Number> in Phone Number field.
    And Enter invalid <Afirst field> in Address first field.
    And Enter invalid <Asecond field> in Address second field.
    And Enter an invalid <City> of Canada.
    And Select an option from drop down list of Province.
    And Enter an invalid <Postal Code> in postal code.
    And Click on Add AddressButton.
    Then User must be on the add address page.

    Examples: 
      | Full Name   | Phone Number | Afirst field | Asecond field | City     | Postal Code |
      | Jenny James |   2192378825 |              |               | Brampton | N1G3K0      |
      |             |   2192378825 | Apt. 112     | King Street   | Brampton | N1G3K0      |
      | Jenny James |              | Apt. 112     | King Street   | Brampton | N1G3K0      |
      | Jenny James |   2192378825 | Apt. 112     | King Street   |          | N1G3K0      |
      | Jenny James |   2192378825 | Apt. 112     | King Street   | Brampton |             |
