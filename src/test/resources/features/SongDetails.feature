Feature: Song Details screen
  In order to see the Mini Player
  As a user
  I have to tap on a collection in the Library screen and then select a song

  @songDetails
  Scenario Outline: User taps on a song and the mini player is displayed
    Given User has selected collection <collectionName> and song <songName>
    When User taps on the More Options
    And User taps on the Play button
    Then Mini player is displayed

    Examples:
      | collectionName | songName |
      | "Hymns" | "The Morning Breaks" |

  @songDetails
  Scenario Outline: User taps on the next song button
    Given User has selected and played collection <collectionName>
    And User maximizes music player "English"
    When User taps on the next song button
    Then Song next song named <nextSongName> should start playing

    Examples:
      | collectionName | nextSongName |
      | "Hymns" | "The Spirit of God" |

  @songDetails
  Scenario Outline: User taps on the previous song button
    Given User has selected and played collection <collectionName>
    And User maximizes music player "English"
    When User taps on the next song button twice
    And User taps on the previous song button once
    Then Song previous song named <previousSongName> should start playing

    Examples:
      | collectionName | previousSongName |
      | "Hymns" | "The Spirit of God" |

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
    Then Song should keep playing

    Examples:
      | tabName | collectionName | songName |
      | "Topics"| "Hymns" | "Now Let Us Rejoice" |
      | "Playlists"| "Hymns" | "Now Let Us Rejoice" |
      | "Downloads"| "Hymns" | "Now Let Us Rejoice" |

  @releaseScreenshots_english @songDetailsScreenshotEnglish @songDetailsScreenshot
  Scenario Outline: Take screenshot of the Sheet Music song view - English
    Given User has selected and played collection <collectionName> and song <songName> and waited for song views to load <languageName>
    When User Sheet Music <viewType> song view is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | languageName | collectionName | songName | viewType | featureName  | fileName |
      | "English" | "Hymns" | "The Morning Breaks"  | "Sheet Music (Resizable)" | "3_sheetMusicSongView"  | "english" |

  @releaseScreenshots_french @songDetailsScreenshotFrench @songDetailsScreenshot
  Scenario Outline: Take screenshot of the Sheet Music song view - French
    Given User switches app language to <languageName> <languageSearch>
    When User has selected and played collection <collectionName> and song <songName> and waited for song views to load <languageName>
    And User Sheet Music <viewType> song view is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | languageName | languageSearch | collectionName | songName | viewType | featureName  | fileName |
      | "French" | "Français"         | "Cantiques" | "Le jour paraît, chassant la nuit"  | "Partition (PDF)"  | "3_sheetMusicSongView"  | "french" |

  @releaseScreenshots_portuguese @songDetailsScreenshotPortuguese @songDetailsScreenshot
  Scenario Outline: Take screenshot of the Sheet Music song view - Portuguese
    Given User switches app language to <languageName> <languageSearch>
    When User has selected and played collection <collectionName> and song <songName> and waited for song views to load <languageName>
    And User Sheet Music <viewType> song view is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | languageName | languageSearch | collectionName | songName | viewType | featureName  | fileName |
      | "Portuguese" | "Português"    | "Hinos" | "A Alva Rompe"  | "Partitura (PDF)" | "3_sheetMusicSongView"  | "portuguese" |

  @releaseScreenshots_spanish @songDetailsScreenshotSpanish @songDetailsScreenshot
  Scenario Outline: Take screenshot of the Sheet Music song view - Spanish
    Given User switches app language to <languageName> <languageSearch>
    When User has selected and played collection <collectionName> and song <songName> and waited for song views to load <languageName>
    And User Sheet Music <viewType> song view is visible <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | languageName | languageSearch | collectionName | songName | viewType |featureName  | fileName |
      | "Spanish" | "Español"         | "Himnos" | "Ya rompe el alba"  | "Partitura (de tamaño variable)"    | "3_sheetMusicSongView"  | "spanish" |