
#@Author: Sivasankaramalan G

Feature: Validation of Amazon Mobile application for Adding Items in Cart

  Background: 
    Given Launch the Amazon app
    When User clicks on "Start shopping" button
    And Verify "Home page" is displayed
    And User clicks on "hamburger" button
    And Login to amazon app
  
  Scenario: Login to Amazon App and Search for a Product
    And Validate text "Amazon Logo" is displayed
    And User clicks on "Amazon" button
    And Validate "Search Bar" is displayed
   	And Verify the Suggestion on the Home Page
   	And Choose the current location
    And Search for the product "65-inch TV"
    And Validate "65-inch TV" is displayed
    And User selects the product from the list
    And Verify product details are displayed
    And User Verifies the details of the selected Product
    And User Add's the product to the Cart
    Then User closes the app

  Scenario: Verify the Cart and Items in Cart
    And Navigate to the Cart menu
    And Verify the Product in Cart
    And User clicks on "Proceed to Buy" button
    Then User closes the app