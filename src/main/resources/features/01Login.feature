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
    And user fills the New User Sigup form as follows then clicks signup
      | name  | newuser         |
      | email | email@gmail.com |
    Then login should be successful


  @login1
  Scenario: Login with By
    Given user on homepage
    And   user clicks LOGIN on menu with Enum
    When  user fill the input "Email Address" as "atezgider@gmail.com"
    And   user fill the input "Password" as "atezgider"
    And   user clicks the button "Login"

  @aaaa
  Scenario: scenario register user
    Given user on homepage
    Then title should be "Automation Exercise"
    And user clicks LOGIN on menu with Enum
    Then verify the text "New User Signup!" is visible
    And user fills the New User Sigup form as follows then clicks signup
      | name  | newuser         |
      | email | email@gmail.com |
    Then verify the text "ENTER ACCOUNT INFORMATION" is visible
    And user fill the registerform as follows
      | Password      | passs      |
      | days          | 13         |
      | months        | February   |
      | years         | 1988       |
      | First name    | First name |
      | Last name     | Last name  |
      | Company       | Company    |
      | Address *     | Address 1  |
      | Address 2     | Address 2  |
      | Country       | Canada     |
      | State         | State      |
      | City          | City       |
      | Zipcode       | 45678      |
      | Mobile Number | 123456     |

    And user clicks the button "Create Account"
    Then  the text "ACCOUNT CREATED!" is visible

    And   user clicks LOGIN on menu with Enum
    When  user clicks DELETEACCOUNT on menu with Enum
    Then  the text "ACCOUNT DELETED!" is visible

  @aaaa
  Scenario: Register User 3
    Given user on homepage
    Given title should be "Automation Exercise"
    * user clicks LOGIN on menu with Enum
    Given the text "New User Signup!" is visible
    And user fills the New User Sigup form as follows then clicks signup
      | name  | newUser1            |
      | email | newuser123@user.com |
    Given the text "ENTER ACCOUNT INFORMATION" is visible
    When  user fill the registerform as follows with list
      | radio    | Mr                                        | Mr                                        |
      | input    | Password                                  | pass                                      |
      | select   | days                                      | 12                                        |
      | select   | months                                    | January                                   |
      | select   | years                                     | 1990                                      |
      | checkbox | Sign up for our newsletter!               | Sign up for our newsletter!               |
      | checkbox | Receive special offers from our partners! | Receive special offers from our partners! |
      | input    | First name                                | First name                                |
      | input    | Last name                                 | Last name                                 |
      | input    | Company                                   | Company                                   |
      | input    | Address *                                 | Address 1                                 |
      | input    | Address 2                                 | Address 2                                 |
      | select   | Country                                   | Canada                                    |
      | input    | State                                     | State                                     |
      | input    | City                                      | City                                      |
      | input    | Zipcode                                   | 123456                                    |
      | input    | Mobile Number                             | 123456789                                 |
    And   user clicks the button "Create Account"
    Then  the text "ACCOUNT CREATED!" is visible

    And   user clicks LOGIN on menu with Enum
    When  user clicks DELETEACCOUNT on menu with Enum
    Then  the text "ACCOUNT DELETED!" is visible




