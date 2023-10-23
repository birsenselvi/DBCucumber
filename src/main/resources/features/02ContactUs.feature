Feature: Contact Us Functionality

  @ContactUs
  Scenario: Send Message Successfully
    Given user on homepage
    When user clicks CONTACTUS on menu with Enum
    Then the CONTACT page should be visible
    When user submits the contact form as follows
      | name    | veli             |
      | email   | veli@dneme.com   |
      | subject | velideneme       |
      | message | velimessage      |
      | file    | c:/temp/Java.txt |
    Then accept popup
    Then the text "Success! Your details have been submitted successfully." is visible

  @ContactUs1
  Scenario: Send Message Successfully
    Given user on homepage
    When user clicks CONTACTUS on menu with Enum
    Then the CONTACT page should be visible
    When user fill the registerform as follows with list
      | input | Name              | veli             |
      | input | Email             | veli@dneme.com   |
      | input | Subject           | velideneme       |
      | input | Your Message Here | velimessage      |
      | button | upload_file       | c:/temp/Java.txt |
      | button | submit     |   |

    Then accept popup
    Then the text "Success! Your details have been submitted successfully." is visible