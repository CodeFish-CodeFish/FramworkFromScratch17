@regression
Feature: Testing the Registration/Removing Customer Account Functionality

  Scenario: Happy Path Registration
    Given User navigates to the AutomationExercise and validates the 'Automation Exercise'
    When User clicks signUp Login button and validates the 'New User Signup!' visible
    And User provides username,email address and click sign up button
    And User verify 'ENTER ACCOUNT INFORMATION' message is visible
    And User provides 'Mr',password,and '8/13/1991' to enter account page
    And User selects sign up for our newsletter and Receive special offers from our partners boxes
    And User provides 'Ahmet','Baldir','CodeFish','2200','east deonw','United States','IL','Des Plaines','60343' and '2345422343' to the boxes
    And User clicks Create account button and validates 'ACCOUNT CREATED!' from the page
    And User clicks Continue button and validates 'Logged in as ' is visible
    Then User clicks Delete Account button and validates 'ACCOUNT DELETED!' is visible
    And User clicks Continue button


