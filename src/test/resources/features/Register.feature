@register
Feature: Registering user account

  Scenario: Customer successfully registers an account
    Given the customer is on the Toolshop homepage
    When the customer clicks on the "Sign In" link
    And the customer clicks on the "Register your account" register link
    And the customer fills in the registration form
    And the customer clicks the "Register" button
    Then the customer should be redirected to the login page with login form
