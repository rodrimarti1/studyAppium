Feature: Collection Details screen
  In order to see the Collection Details screen
  As a user
  I have to tap on a collection in the Library screen

  @releaseScreenshots_english @collectionContentEnglish
  Scenario Outline: Take screenshot of collection content view - English
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And Play button is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "English"  | "English"  |"collectionContent" | "english" |

  @releaseScreenshots_spanish @collectionContentSpanish
  Scenario Outline: Take screenshot of collection content view - Spanish
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And Play button is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "Spanish"  | "Español"  | "collectionContent" | "spanish" |

  @releaseScreenshots_french @collectionContentFrench
  Scenario Outline: Take screenshot of collection content view - French
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And Play button is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "French"  | "Français"  | "collectionContent" | "french" |

  @releaseScreenshots_portuguese @collectionContentPortuguese
  Scenario Outline: Take screenshot of collection content view - Portuguese
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And Play button is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "Portuguese"  | "Português" | "collectionContent" | "portuguese" |

  @releaseScreenshots_english @maximizedPlayerEnglish
  Scenario Outline: Take screenshot of maximized music player - English
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And User plays the song-list <languageName>
    And User maximizes music player <languageName>
    And Wait for Next Song button to be displayed <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "English"  | "English" | "maximizedPlayer" | "english" |

  @releaseScreenshots_spanish @maximizedPlayerSpanish
  Scenario Outline: Take screenshot of maximized music player - Spanish
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And User plays the song-list <languageName>
    And User maximizes music player <languageName>
    And Wait for Next Song button to be displayed <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "Spanish"  | "Español" | "maximizedPlayer" | "spanish" |

  @releaseScreenshots_french @maximizedPlayerFrench
  Scenario Outline: Take screenshot of maximized music player - French
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And User plays the song-list <languageName>
    And User maximizes music player <languageName>
    And Wait for Next Song button to be displayed <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "French"  | "Français" | "maximizedPlayer" | "french" |

  @releaseScreenshots_portuguese @maximizedPlayerPortuguese
  Scenario Outline: Take screenshot of maximized music player - Portuguese
    Given User has navigated to the collection <collectionName>
    When User switches app language to <languageName> <languageSearch>
    And User plays the song-list <languageName>
    And User maximizes music player <languageName>
    And Wait for Next Song button to be displayed <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | collectionName | languageName | languageSearch | featureName | fileName |
      | "Hymns"   | "Portuguese"  | "Português" | "maximizedPlayer" | "portuguese" |