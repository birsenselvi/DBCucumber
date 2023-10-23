Feature: Login
  Scenario: LogenOranghm
    Given user navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When  user try to login with data in the excel file"src/test/java/login/MOCK_DATA.xlsx"

