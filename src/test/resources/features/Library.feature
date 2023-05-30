@library

Feature: Library Screen
  In order to see the Library screen
  As a user
  I want the SM Android app to successfully launch

  Scenario: User lands in Library screen after SM Android App successfully launches
    Given User launches the SM Android App
    When The app loads
    Then User should land in library page

  Scenario: User lands in Library screen and taps on the Ellipse Menu
    Given Users lands in Library Screen
    When User taps on the Ellipse Menu
    Then Users should see Language and Settings options
