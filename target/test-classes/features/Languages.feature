Feature: Languages Screen
  In order to see the Language screen
  As a user
  I want to tap on the Ellipse Menu and tap on the Languages Option

  Scenario: User taps Languages option in Ellipse Menu and is taken to Language page
    Given The app has fully loaded and user lands in Library screen
    When User taps on the Ellipse Menu and selects Languages option
    Then User is taken to the Languages page