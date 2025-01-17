Feature: Topics screen
  In order to see the Topics list
  As a user
  I have to tap on Topics tab in the navigation menu

  @topics1
  Scenario: User lands in the Topics page
    Given User is in the Library Page
    When User navigates to the Topics tab
    Then User should see the word "Topics" in the Topics page title
    And User should see the Topics Search bar with text Find by name
    And User should see the More Options menu in the top right corner of the Topics Page

  @topics
  Scenario: User enters valid search criteria in the searchbar
    Given User is in the Topics screen
    When User enters valid criteria "god" in the search bar
    Then User should see search result with name "Child of God" returned

  @topics1
  Scenario Outline: User navigates to a topic and downloads a song
    Given User is in the Topics screen and taps on Topic called "Accountability"
    When User taps on the More Options menu for the song called <songName> and chooses to <action> it audio type <audioType>
    Then User should see the green checkmark indicating the song called "We Are Sowing" was downloaded
    Examples:
      | songName | action | audioType |
      | "We Are Sowing" | "Download / Remove" | "Accompaniment" |

  #This test will keep failing unless LMFA-674 is fixed
  @topics
  Scenario Outline: User navigates to a topic and adds a song to a new playlist
    Given User is in the Topics screen and taps on Topic called "Accountability"
    When User taps on the More Options menu and chooses to add song called <songName> with audio type <audioType> to a new playlist
    And User creates a new playlist named "Adding to playlist from Topics" <languageName>
    Then User should see the song called "We Are Sowing" added to the playlist
    Examples:
      | songName | audioType | languageName |
      | "We Are Sowing" | "Accompaniment" | "English" |

  @topics
  Scenario Outline: User navigates to a topic and adds a song to an existing playlist
    Given User has previously created a playlist called "Existing playlist for testing" and is now in the Topics screen and taps on Topic called "Accountability" <languageName>
    When User taps on the More Options menu and chooses to add song called <songName> with audio type <audioType> to an existing playlist
    And User selects the existing playlist named "Existing playlist for testing"
    Then User should see the song called "We Are Sowing" added to the playlist
    Examples:
      | songName | audioType | languageName |
      | "We Are Sowing" | "Accompaniment" | "English" |

