Feature: Customer Login

  As a registered customer,
  I want to log in with my credentials,
  So that I can access my account.

  Scenario: Customer logs in with valid credentials
    Given the customer is on the login page
    When the customer enters valid credentials
    And the customer clicks the login button
    Then the customer is directed to the my account page