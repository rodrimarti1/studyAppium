package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import org.example.pageObjects.android.*;
import org.testng.Assert;

import static utils.DriverFactory.getDriver;

public class CollectionDetails_Steps {

    private AndroidDriver driver = getDriver();
    public BasePage basePage = new BasePage(driver);
    public LibraryPage libraryPage = new LibraryPage(driver);
    public CollectionDetailsPage collectionDetailsPage = new CollectionDetailsPage(driver);
    public SongDetailsPage songDetailsPage = new SongDetailsPage(driver);
    public LanguagesPage languagesPage = new LanguagesPage(driver);

    @And("Play button is visible {string}")
    public void playButtonIsVisible(String languageName) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(collectionDetailsPage.getSongListPlayButton(languageName).isDisplayed());
    }

    @And("User plays the song-list {string}")
    public void userPlaysTheSonglist(String languageName) {
        collectionDetailsPage.getSongListPlayButton(languageName).click();
        Assert.assertTrue(songDetailsPage.getMiniPlayer(languageName).isDisplayed());
    }
}
