Feature: Collection Details screen
  In order to see the Collection Details screen
  As a user
  I have to tap on a collection in the Library screen

  @releaseScreenshots_english @collectionContentEnglish @collectionContent
  Scenario Outline: Take screenshot of collection content view - English
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And Play button is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "English"  | "English"  |"2_collectionContent" | "english" |

  @releaseScreenshots_spanish @collectionContentSpanish @collectionContent
  Scenario Outline: Take screenshot of collection content view - Spanish
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And Play button is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "Spanish"  | "Español"  | "2_collectionContent" | "spanish" |

  @releaseScreenshots_french @collectionContentFrench @collectionContent
  Scenario Outline: Take screenshot of collection content view - French
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And Play button is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "French"  | "Français"  | "2_collectionContent" | "french" |

  @releaseScreenshots_portuguese @collectionContentPortuguese @collectionContent
  Scenario Outline: Take screenshot of collection content view - Portuguese
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And Play button is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "Portuguese"  | "Português" | "2_collectionContent" | "portuguese" |

  @releaseScreenshots_english @maximizedPlayerEnglish @maximizedPlayer
  Scenario Outline: Take screenshot of maximized music player - English
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And User plays the song-list <languageName>
    And User maximizes music player <languageName>
    And Wait for Next Song button to be displayed <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "English"  | "English" | "4_maximizedPlayer" | "english" |

  @releaseScreenshots_spanish @maximizedPlayerSpanish @maximizedPlayer
  Scenario Outline: Take screenshot of maximized music player - Spanish
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And User plays the song-list <languageName>
    And User maximizes music player <languageName>
    And Wait for Next Song button to be displayed <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "Spanish"  | "Español" | "4_maximizedPlayer" | "spanish" |

  @releaseScreenshots_french @maximizedPlayerFrench @maximizedPlayer
  Scenario Outline: Take screenshot of maximized music player - French
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And User plays the song-list <languageName>
    And User maximizes music player <languageName>
    And Wait for Next Song button to be displayed <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "French"  | "Français" | "4_maximizedPlayer" | "french" |

  @releaseScreenshots_portuguese @maximizedPlayerPortuguese @maximizedPlayer
  Scenario Outline: Take screenshot of maximized music player - Portuguese
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And User plays the song-list <languageName>
    And User maximizes music player <languageName>
    And Wait for Next Song button to be displayed <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "Portuguese"  | "Português" | "4_maximizedPlayer" | "portuguese" |