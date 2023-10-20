Feature: Library Screen
  In order to see the Library screen
  As a user
  I want the SM Android app to successfully launch

  @library
  Scenario: User lands in Library screen after SM Android App successfully launches
    Given User launches the SM Android App
    When The app loads
    Then User should land in library page

  @library
  Scenario: User lands in Library screen and taps on the Ellipse Menu
    Given Users lands in Library Screen "English"
    When User taps on the Ellipse Menu
    Then Users should see Language and Settings options

  @releaseScreenshots_english @libraryScreenshotEnglish @libraryScreenshot
  Scenario Outline: Take screenshot of the Library screen - English
    Given User switches app language to <languageName> <languageSearch>
    When Users lands in Library Screen <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | languageName | languageSearch | featureName  | fileName |
      | "English"    | "English"      | "library"    |"english" |

  @releaseScreenshots_spanish @libraryScreenshotSpanish @libraryScreenshot
  Scenario Outline: Take screenshot of the Library screen - Spanish
    Given User switches app language to <languageName> <languageSearch>
    When Users lands in Library Screen <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | languageName | languageSearch | featureName  | fileName |
      | "Spanish"    | "Español"      |"library"    |"spanish"  |

  @releaseScreenshots_french @libraryScreenshotFrench @libraryScreenshot
  Scenario Outline: Take screenshot of the Library screen - French
    Given User switches app language to <languageName> <languageSearch>
    When Users lands in Library Screen <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | languageName | languageSearch | featureName  | fileName |
      | "French"    | "Français" |"library"  |"french" |

  @releaseScreenshots_portuguese @libraryScreenshotPortuguese @libraryScreenshot
  Scenario Outline: Take screenshot of the Library screen - Portuguese
    Given User switches app language to <languageName> <languageSearch>
    When Users lands in Library Screen <languageName>
    Then Take a screenshot of the <featureName> screen with file name <fileName>
    Examples:
      | languageName | languageSearch | featureName  | fileName |
      | "Portuguese"    | "Português"  | "library"    |"portuguese"  |