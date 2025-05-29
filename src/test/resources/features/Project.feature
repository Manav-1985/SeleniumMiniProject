Feature: End-to-End Purchase Flow on Magento

  Scenario: Successful purchase of jackets from Magento
    Given the user is on the homepage and clicks Sign In
  	When the user logs in with valid credentials
  	And navigates to the Men Jackets section
  	And select all jackets
  	And adds up all the prices
  #	Then the number in the cart should match the number of selected products
  	And the cart should show a remove button for each item
  	When the user proceeds to checkout
  	And fills in personal details and clicks Next
  	Then the payment info, shipping info, and total price should be displayed
  #	And the item total should be correct
  	When the user clicks on Place Order
  	Then the order confirmation message should be displayed
