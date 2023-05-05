Feature: Song Details screen
  In order to see the Mini Player
  As a user
  I have to tap on a collection in the Library screen and then select a song

  @songDetails
  Scenario Outline: User taps on a song and the mini player is displayed
    Given User has selected collection <collectionName> and song <songName>
    When User taps on the More Options
    And User taps on the Play button
    And User selects Audio Type <audioType>
    Then Mini player is displayed

    Examples:
      | collectionName | songName | audioType |
      | "Hymns" | "The Morning Breaks" | "Accompaniment" |

  @songDetails
  Scenario Outline: User taps on the next song button
    Given User has selected and played collection <collectionName> with audio type <audioType>
    And User maximizes music player
    When User taps on the next song button
    Then Song next song named <nextSongName> should start playing

    Examples:
      | collectionName | audioType | nextSongName |
      | "Hymns" | "Accompaniment" | "The Spirit of God" |

  @songDetails
  Scenario Outline: User taps on the previous song button
    Given User has selected and played collection <collectionName> with audio type <audioType>
    And User maximizes music player
    When User taps on the next song button twice
    And User taps on the previous song button once
    Then Song previous song named <previousSongName> should start playing

    Examples:
      | collectionName | audioType | previousSongName |
      | "Hymns" | "Accompaniment" | "The Spirit of God" |

  @songDetails
  Scenario Outline: Songs should keep playing after screen rotation
    Given User has selected and played collection <collectionName> and song <songName> with audio type <audioType>
    When User rotates phone screen
    Then Song should keep playing

    Examples:
      | collectionName | songName | audioType |
      | "Hymns" | "Now Let Us Rejoice" | "Accompaniment" |

  @songDetails
  Scenario Outline: Songs should keep playing after switching tabs
    Given User has selected and played collection <collectionName> and song <songName> with audio type <audioType>
    When User switches to the <tabName> tab
    Then Song should keep playing

    Examples:
      | tabName | collectionName | songName | audioType |
      | "Topics"| "Hymns" | "Now Let Us Rejoice" | "Accompaniment" |
      | "Playlists"| "Hymns" | "Now Let Us Rejoice" | "Accompaniment" |
      | "Downloads"| "Hymns" | "Now Let Us Rejoice" | "Accompaniment" |