package tests;

import org.example.pageObjects.android.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test
    public void searchSongRegularCharacters() {
        SearchPage searchPage = libraryPage.goToSearchPage();
        searchPage.searchSongByName("We Are Your Daughters");
        boolean isSongDisplayed = searchPage.getSongFromResults("We Are Your Daughters").isDisplayed();
        Assert.assertTrue(isSongDisplayed);
        tabsPage.goToLibraryPage();
    }
    //TODO have devs add ids to song results, meanwhile this test validates app doesn't crash when search is done using special characters
    @Test
    public void searchSongSpecialCharacters() {
        SearchPage searchPage = libraryPage.goToSearchPage();
        searchPage.searchSongByName("!@#$%^&*()_+");
        boolean isSongDisplayed = searchPage.getSongFromResults("!@#$%^&*()_+").isDisplayed();
        System.out.println("Debug song displayed:" + isSongDisplayed);
        Assert.assertTrue(isSongDisplayed);
    }
}
