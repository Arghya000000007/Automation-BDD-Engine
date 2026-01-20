@search
Feature: Search product functionality

Scenario Outline: Search experience for product search in both home and offer page
Given User on website home page
When User search with shortName "<Name>" and extracted actual name of product
Then User search with same short name "<Name>" in offer page if product exist 
Then Validate if product name in landing and offer page is same

Examples:
|	Name	|
|	Tom		|
|   Beet    |