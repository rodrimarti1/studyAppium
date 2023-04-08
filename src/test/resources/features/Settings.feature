
Feature: Settings Screen
  In order to see the Settings screen
  As a user
  I have to tap on the Ellipse menu and select the Settings option

  @settings
  Scenario: User lands in Library page and is able to see the Ellipse Menu
    Given User taps on the Ellipse Menu and selects Settings option
    When Settings page is visible
    Then User should be able to see the following options:
      | Sheet Music |
      | Preferred Type |
      | Size           |
      | Theming |
      | Adjust sheet music for dark mode |
      | Lyrics  |
      | Font Style |
      | Support    |
      | Send Feedback |
      | Featured Apps |
      | About |

  @settings
  Scenario: User is in Settings screen and taps on the back button
    Given User taps on the Ellipse Menu and selects Settings option
    When User taps on the Settings screen back button
    Then User is taken back to the Library screen

  @about
  Scenario: User is in Settings screen and taps on About option
    Given User is in Settings screen
    When User taps on the About option
    Then User should see the following options:
      | Terms of Use |
      | Updated 2021-04-13 |
      | Privacy Notice |
      | Updated 2021-04-06 |
      | Acknowledgements |
      | © 2023 by Intellectual Reserve, Inc. All rights reserved. |
    And User should see the App Instance button

  @about
  Scenario: User is in About screen and taps on the back button
    Given User is in About screen
    When User taps on the About screen back button
    Then User is taken back to the Settings screen

  @feedback
  Scenario: User is in Send Feedback screen and sees the following fields
    Given User is in Settings screen and taps on Send Feedback option
    When App renders Send Feedback Screen
    Then User should see the following options in the Send Feedback Screen:
      | Name (Optional) |
      | Email |
      | Category |
      | Description |
    And User should see the Attachments button
    And User should see the Send button

  @feedback
  Scenario Outline: User is fill out all fields in Send Feedback screen and submits the form
    Given User is in Send Feedback screen
    When User enters text to all required fields: <Name> <Email> <Category> <Description>
    Then Send Feedback form can be successfully submitted

    Examples:
      | Name | Email | Category | Description |
      | "Test Automation User" | "test-automation-user@chruchofjesuschrist.org" | "Compliment" | "This feedback has been submitted by Sacred Music's test automation suite" |

  @feedback
  Scenario: User attempts to submit Send Feedback form when required fields have been left empty
    Given User is in Send Feedback screen
    When User taps on Submit button
    Then User should the following error messages:
      | Please enter a valid email address |
      | Please select a category |
      | Please enter a description |