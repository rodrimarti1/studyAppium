Feature: Languages Screen
  In order to see the Language screen
  As a user
  I want to tap on the Ellipse Menu and tap on the Languages Option

  @languages
  Scenario: User taps Languages option in Ellipse Menu and is taken to Language page
    Given The app has fully loaded and user lands in Library screen
    When User taps on the Ellipse Menu and selects Languages option
    Then User is taken to the Languages page

  @languages
  Scenario Outline: User selects a language from the Languages list and the app is translated to that language
    Given User has navigated to the Languages screen
    When User searches for <language> language and selects it from the languages list
    Then User should be taken to the library screen
    And Album called <album> should be displayed

    Examples:
      | language | album |
      | Portuguese | Músicas para Crianças |
      | Spanish     | Canciones para los niños |
