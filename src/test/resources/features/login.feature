Feature: login to https://magento.softwaretestingboard.com/

  Scenario: login with valid email and password
    Given user visit homapage
    When user click sign in
    And user input valid email and password
    Then user should see welcome message