@Regression
Feature: Newyorker Categories Product, Get More Club and Vouchers Test cases

  @Smoke
  Scenario: Testcase 1 Validating the Products page details
    Given I want to launch NewYorker home page
    When I click Go select Herren and accecpt the cookies
    And I close the Registration model window
    Then I validate NewYorker Men Home page elements
    When I click Hamburger menu and select Products
    Then I validate the elements in products page
   
   @Sanity1
  Scenario: Testcase 2 Validating the Get More Club page details
    Given I want to launch NewYorker home page
    When I click Go select Herren and accecpt the cookies
    And I close the Registration model window
    Then I validate NewYorker Men Home page elements
    When I click Hamburger menu and select Get More Club
    Then I validate the elements in Get More Club page
    
    @Sanity
  Scenario: Testcase 3 Validating the Vouchers page flow
    Given I want to launch NewYorker home page
    When I click Go select Herren and accecpt the cookies
    And I close the Registration model window
    Then I validate NewYorker Men Home page elements
    When I click Hamburger menu and select Vouchers
    And I navigate to the flow of buy vouchers
    Then I validate the elements in Vouchers payment page
   
     