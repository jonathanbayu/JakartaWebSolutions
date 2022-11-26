Feature: login then purchase products

	Scenario: login with valid email and password
    Given user visit homapage
    When user click sign in
    And user input valid email and password
    Then user should see welcome message
    
  Scenario: purchase a products
    When user open jacket category
    And user buy jacket size XS and color black
    And user buy another jacket size L and color red
    And user open pants category
    And user buy pants size 32 and color black
    And user proceed to checkout
    And user fill the form
    And user proceed to payments
    And user place an order
    Then user should see order number
   
  Scenario: show orders page
    When user open click order number
    Then user should see the order 