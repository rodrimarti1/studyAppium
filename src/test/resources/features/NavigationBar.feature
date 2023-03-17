@navigationBar

Feature: Navigation Bar
  In order to see the Navigation bar
  As a user
  I want the SM Android app to successfully launch

  Scenario Outline: User lands in Library page and is able to see Navigation bar
    Given User is in the Library Page
    When Navigation bar is visible
    Then Navigation bar displays <optionName> option

    Examples:
      | optionName |
      | Library |
      | Topics |
      | People |
      | Playlists |