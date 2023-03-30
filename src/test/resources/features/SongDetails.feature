@songDetails

Feature: Song Details screen
  In order to see the Mini Player
  As a user
  I have to tap on a collection in the Library screen and then select a song

  Scenario Outline: User taps on a song and the mini player is displayed
    Given User has selected collection <collectionName> and song <songName>
    When User taps on the headphones button
    Then Mini player is displayed
    And More Options button is displayed
    And Previous Song button is displayed
    And Pause button is displayed
    And Next Song button is displayed
    And Current Time counter is displayed
    And Progress Bar is displayed
    And Duration Time counter is displayed
    And Selected song should start playing

    Examples:
      | collectionName | songName |
      | "Hymns" | "The Morning Breaks" |