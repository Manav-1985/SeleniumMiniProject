Feature: End-to-End Purchase Flow on Magneto

  Scenario: Successful purchase of jackets from Magneto
    Given open url and click on Sign In
    When log in with valid credentials
    Then navigate to Men Jackets section
    #And sort by price
    And select all jackets 
    And add all the prices
    Then verifying the number on the cart matches number of products selected
    And opening cart and checks remove is available for each item
    Then proceed to checkout
    And fill in personal details and click next
    #Then verify payment info, shipping info, and total price is displayed
    #And verify item total is correct
    Then click on Place Order
    Then get the order confirmation message
