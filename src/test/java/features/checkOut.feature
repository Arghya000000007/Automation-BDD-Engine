@checkout
Feature: Checkout functionality

Scenario Outline: search and addtoCart product
Given User on website home page
 When User search with shortName "<Name>" and extracted actual name of product
 And Add "3" items of selected product to cart
 Then User proceeds to checkout and validate the "<Name>" items in checkout page
 And Verify user has ability to use promo code and plcae the order
 
 Examples:
|	Name	|
|	Tom		|

 
 
