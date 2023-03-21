
Feature: Settings Screen
  In order to see the Settings screen
  As a user
  I have to tap on the Ellipse menu and select the Settings option

  @settings
  Scenario: User lands in Library page and is able to see the Ellipse Menu
    Given User taps on the Ellipse Menu and selects Settings option
    When Settings page is visible
    Then User should be able to see the following options:
      | Display |
      | Theme |
      | System Default |
      | Dark Sheet Music |
      | Show dark background for sheet music in dark theme |
      | Additional Info |
      | Featured Apps |
      | Send Feedback |
      | About |

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