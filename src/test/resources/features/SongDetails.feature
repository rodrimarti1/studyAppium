Feature: Song Details screen
  In order to see the Mini Player
  As a user
  I have to tap on a collection in the Library screen and then select a song

  @songDetails
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

  @songDetails
  Scenario Outline: User taps on the next song button
    Given User has selected collection <collectionName> and song <songName>
    When User taps on the headphones button
    And User taps on the next song button
    Then Song next song named <nextSongName> should start playing

    Examples:
      | collectionName | songName | nextSongName |
      | "Hymns" | "The Morning Breaks" | "The Spirit of God" |

  @songDetails
  Scenario Outline: User taps on the previous song button
    Given User has selected collection <collectionName> and song <songName>
    When User taps on the headphones button
    And User taps on the next song button twice
    And User taps on the previous song button once
    Then Song previous song named <previousSongName> should start playing

    Examples:
      | collectionName | songName | previousSongName |
      | "Hymns" | "Now Let Us Rejoice" | "Truth Eternal" |

  @songDetails
  Scenario Outline: Songs should keep playing after screen rotation
    Given User has selected and played collection <collectionName> and song <songName>
    When User rotates phone screen
    Then Song should keep playing

    Examples:
      | collectionName | songName |
      | "Hymns" | "Now Let Us Rejoice" |

  @songDetails
  Scenario Outline: Songs should keep playing after switching tabs
    Given User has selected and played collection <collectionName> and song <songName>
    When User switches to the <tabName> tab
    And User goes back to collection <collectionName> and song <songName>
    Then Song should keep playing

    Examples:
      | tabName | collectionName | songName |
      | "Topics"| "Hymns" | "Now Let Us Rejoice" |
      | "Playlists"| "Hymns" | "Now Let Us Rejoice" |
      | "Downloads"| "Hymns" | "Now Let Us Rejoice" |