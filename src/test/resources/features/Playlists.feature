Feature: Playlists screen
  In order to see the Playlists screen
  As a user
  I have to tap on Playlists option in the navigation bar

  @playlists
  Scenario: User navigates to Playlists screen and sees empty state
    Given User taps on the Playlists option in the navigation bar
    When User lands in Playlists screen
    Then User sees Playlists screen empty state

  @playlists
  Scenario Outline: User creates a new playlist
    Given User taps on the Playlists option in the navigation bar
    When User taps on the New Playlist button
    And User fills out Title field with text <playlistName>
    And User fill out Description field with text <descriptionText>
    And User taps on the Save button
    Then User should see a confirmation message with text <confirmationText>
    And User should see new <playlistName> playlist listed

      Examples:
      | playlistName | descriptionText | confirmationText |
      | "Test Playlist 1" | "This is a test playlist" | "Playlist Created" |

  @playlists
  Scenario Outline: User deletes an existing playlist
    Given User has navigated to the Playlist screen
    And User has created a new playlist named <playlistName>
    When User taps on the Delete Playlist option in the Ellipse Menu of the playlist named <playlistName>
    Then User should no longer be able to see the playlist

      Examples:
      | playlistName |
      | "Test Playlist for deletion" |

  @playlists
  Scenario Outline: User adds songs to an existing playlist from Library screen
    Given User has created a new playlist named <playlistName> and navigated to the Library screen
    And User has selected collection <collectionName> and song <songName>
    When User taps on the Add to Playlist button in the Ellipse Menu
    And User selects Playlist named <playlistName>
    And User chooses View Playlist option in the confirmation modal
    Then User should see song named <songName> added to the playlist named <playlistName>

      Examples:
      | playlistName | collectionName | songName | audioType |
      | "Test Playlist for adding songs" | "Hymns" | "The Morning Breaks" | "Accompaniment" |

  @playlists
  Scenario Outline: User adds songs to an existing playlist from Search
    Given User has created a new playlist named <playlistName> and clicked on it
    And User taps on the Add a Song button
    When User searches and selects <songName> song
    And User taps on the Add Songs option in the pop up
    Then User should see song named <songName> added to the newly created playlist
    And User should see the following options in the Ellipse Menu of each song
      | Play Song |
      | Play Next |
      | Play Last |
      | Add to Playlist |
      | Remove from Playlist |
      | Download Song        |
      #| Share Song           | To be enabled in the future
      #| Album                | To be enabled in the future

    Examples:
      | playlistName |  songName |
      | "Add songs from using search option" | "The Morning Breaks" |

  @playlists
  Scenario Outline: User removes songs from an existing playlist
    Given User has created a new playlist named <playlistName> and added song named <songName> to it
    When User taps on the More Options menu for that song
    And User taps on the Remove from Playlist button
    Then User should no longer see the song in the playlist

    Examples:
      | playlistName |  songName |
      | "Remove songs from playlist" | "The Morning Breaks" |

  @playlists
  Scenario Outline: User plays a playlist
    Given User has created a new playlist named <playlistName> and added song named <songName> to it
    When User taps on the Playlist Play button
    Then Mini player should be displayed
    And Mini player should reproduce song named <songName>

    Examples:
      | playlistName |  songName |
      | "Play a playlist" | "The Morning Breaks" |

  @playlists
  Scenario Outline: User shuffles a playlist
    Given User has created a new playlist named <playlistName> and added song named <songName> to it
    When User taps on the Playlist Shuffle button
    Then Mini player should be displayed
    And Mini player should reproduce song named <songName>

    Examples:
      | playlistName |  songName |
      | "Shuffle a playlist" | "The Morning Breaks" |

  @playlists
  Scenario: User navigates to an existing Playlist and taps on the Ellipse Menu
    Given User has created and navigated to a new playlist named "Ellipse Menu Option Test Playlist"
    When User taps on the Playlists screen Ellipse Menu
    Then User should see the following options in the Ellipse Menu:
      | Copy to Playlist |
      | Download Playlist |
      | Edit Description  |
      | Edit Song List    |
      | Delete Playlist   |
      | Settings         |
