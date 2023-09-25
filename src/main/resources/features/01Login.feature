Feature: Login

@login
  Scenario: scenario Login to website
    Given user on homepage
    When user clicks LOGIN on menu with Enum
   # When user clicks LOGIN on menu
    And user fills the login form as "user"
    And user should be successful

@signup
  Scenario: scenario register to website
    Given user on homepage
    And user clicks SIGNUP on menu with Enum
    And user fills the New User Sigup form as follows
      | name  | newuser         |
      | email | email@gmail.com |
    Then login should be successful
  Scenario: kayit
    Given user on homepage
    When user save "1000" as "miktar"
    Then "miktar" degeri "1000" olmali





