@Regression
Feature: Newyorker MyAccount Page Test Cases
 
  @Sanity
 Scenario: Testcase 4 Login to the portal navigate to MyAccount and find birth date
    Given I want to launch NewYorker home page
    When I click Go select Herren and accecpt the cookies
    And I close the Registration model window
    When I login to the portal
    And I navigate to MyAccount
    Then I validate the Date of Birth field
    And I logout from the portal