Feature: Playlists screen
  In order to see the Playlists screen
  As a user
  I have to tap on Playlists option in the navigation bar

  @playlists1
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

