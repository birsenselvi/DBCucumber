Feature: Product functionality
  Scenario: Add a product to the cart
    Given user on homepage
    Then user clicks PRODUCTS on menu with Enum
    And user search for "Blue"
    And user add "Blue Top" to the Cart
    Then the text "Your product has been added to cart." is visible
    Then I clicks the "Continue Shopping" button
    And the text "Your product has been added to cart." is not visible
