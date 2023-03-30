Feature: Search Screen
  In order for the Search Screen to be displayed
  As a user
  I have to tap on the Ellipse menu and select the Search option

  @allSearch
  Scenario Outline: User enters valid search criteria and the search finds at least a song
    Given User has navigated to the search page
    When User enters valid criteria <criteria> in the search box
    Then Global search returns at least <numberOfSongsFound> song that matches the search criteria <criteria>
      Examples:
        | criteria | numberOfSongsFound |
        | Miracle  | 2                  |

  @allSearch
  Scenario Outline: User enters invalid search criteria and the search finds no songs
    Given User has navigated to the search page
    When User enters invalid <criteria> in the search box
    Then Global search shouldn't be able to find any song matching the search criteria <criteria>
      Examples:
      | criteria |
      | Football |

  @allSearch
  Scenario Outline: User enters special characters as search criteria
    Given User has navigated to the search page
    When User enters <special characters> in the search box
    Then The app shouldn't crash
      Examples:
        | special characters |
        | !@#$%^&*()_+       |

  @allSearch
  Scenario: User taps on the back button while in the Search Screen
    Given User has navigated to the search page
    When User taps on the back button
    Then User should be taken to the library screen

  @allSearch
  Scenario Outline: X button is displayed when users enters text in the search box
    Given User has navigated to the search page
    When User enters search <criteria> in the search box but doesn't click on the search button
    Then X button is displayed at the left end of the search box
      Examples:
        | criteria |
        | Miracle  |

  @allSearch
  Scenario Outline: Clicking on the X button clear text entered in the search box
    Given User has navigated to the search page
    When User enters valid criteria <criteria> in the search box and clicks on the X button
    Then Text entered in the search box is cleared
      Examples:
        | criteria |
        | Miracle  |


