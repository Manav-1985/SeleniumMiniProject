Feature: End-to-End Purchase Flow on Magneto

  Scenario: Successful purchase of jackets from Magneto
    Given  open url and click on Sign In
    When log in with valid credentials
    Then navigate to Men Jackets section
    And select all jackets 
    And Add the prices
    Then verifying the number on the cart matches number of products selected
    And opening cart and checks remove is available for each item
    Then proceed to checkout
    And fill in personal details and continues
    Then verify payment info, shipping info, and total
    And verify item total is correct
    Then click on finish
    And get the order confirmation message
