package tests;

import org.example.pageObjects.android.LanguagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryTests extends BaseTest {

    @Test()
    public void checkLibraryPageUIComponents() {
        String title = libraryPage.getLibraryPageTitle();
        Assert.assertEquals(title, "Library");
        boolean isMoreOptionsVisible = libraryPage.getMoreOptionsMenu().isDisplayed();
        Assert.assertTrue(isMoreOptionsVisible);
        boolean isNavBarVisible = libraryPage.getNavbar().isDisplayed();
        Assert.assertTrue(isNavBarVisible);
        boolean isMainFrameVisible = libraryPage.getMainFrame().isDisplayed();
        Assert.assertTrue(isMainFrameVisible);
    }

    @Test()
    public void switchLanguagePortuguese() {
        LanguagesPage languagePage = libraryPage.goToLanguagePage();
        languagePage.searchAndSelectLanguageByName("Portuguese");
        Boolean isMusicAlbumDisplayed = libraryPage.findAlbumByText("Músicas para Crianças\n" +
                "\n").isDisplayed();
        Assert.assertTrue(isMusicAlbumDisplayed);
    }

    @Test()
    public void switchLanguageSpanish() {
        LanguagesPage languagePage = libraryPage.goToLanguagePage();
        languagePage.searchAndSelectLanguageByName("Spanish");
        Boolean isMusicAlbumDisplayed = libraryPage.findAlbumByText("Canciones para los niños\n" +
                "\n").isDisplayed();
        Assert.assertTrue(isMusicAlbumDisplayed);
    }
}
