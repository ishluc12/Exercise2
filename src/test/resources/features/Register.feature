Feature: Registering user account

  Scenario: user want to register an account
    Given That as a customer is on homepage
    When A customer click on sing in on navigation bar
    Then the login form is opened

  Scenario: customer is on login form
    When A customer click on Register link on login form
    Then A form of registering customer is opened

  Scenario: Customer filling the register form
    And A customer is on register page
    When A customer enter valid credential
    Then A successful message is displayed

