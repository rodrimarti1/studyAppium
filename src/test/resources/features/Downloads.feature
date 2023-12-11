Feature: Downloads screen
  In order for songs to be downloaded
  As a user
  I have to tap on a collection, tap on the More Options next to a song and select the Download option

  @downloads
  Scenario: User lands in the Downloads page
    Given User is in the Library Page
    When User navigates to the Downloads tab
    Then User should see the word "Downloads" in the title
    And User should see the Downloads Search bar with text Find by name
    And User should see the More Options menu in the top right corner

  @downloads
  Scenario Outline: User downloads a song from the collection song list screen
    Given User has navigated to the collection <collectionName>
    When User taps on the More Options menu for the song named <songName> and taps on the Download option and selects audio type <audioType>
    Then User should see checkmark next to the song named <songName> indicating it was successfully downloaded
    Examples:
      | collectionName | songName | audioType |
      | "Hymns"        | "The Morning Breaks" | "Choir/Congregation" |

  @downloads
  Scenario Outline: User downloads a song from the collection song list screen
    Given User has downloaded song named <songName> with audio type <audioType> from collection <collectionName>
    And User navigates to the Downloads tab
    When User taps on the More Options menu for the song named <songName>
    Then User should see following options listed
      | Play Song |
      | View Song Details |
      | Remove Download   |
    Examples:
      | songName | audioType | collectionName |
      | "The Morning Breaks"  | "Choir/Congregation" | "Hymns" |

  @downloads
  Scenario Outline: User has downloaded a song and is able to see it listed in the Downloads tab
    Given User has downloaded song named <songName> with audio type <audioType> from collection <collectionName>
    When User navigates to the Downloads tab
    Then User sees song named <songName> listed
    Examples:
      | songName | audioType | collectionName |
      | "The Morning Breaks"  | "Choir/Congregation" | "Hymns" |

  @downloads
  Scenario Outline: User has downloaded a song and is able to remove it from the Downloads list
    Given User has downloaded song named <songName> with audio type <audioType> from collection <collectionName>
    And User navigates to the Downloads tab
    When User taps on the More Options menu for the song named <songName> and taps on the Remove Download option
    Then User should no longer see the song in the list
    Examples:
      | songName | audioType | collectionName |
      | "The Morning Breaks"  | "Choir/Congregation" | "Hymns" |

  @downloads
  Scenario Outline: Leave song option in the Confirm Deletion prompt won't delete a song
    Given User has downloaded song named <songName> with audio type <audioType> from collection <collectionName>
    And User navigates to the Downloads tab
    When User taps on the More Options menu for the song named <songName> and taps on the Remove Download option, but decides not to delete it
    Then User sees song named <songName> listed
    Examples:
      | songName | audioType | collectionName |
      | "The Morning Breaks"  | "Choir/Congregation" | "Hymns" |



