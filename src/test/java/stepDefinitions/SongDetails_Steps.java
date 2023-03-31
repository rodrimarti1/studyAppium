package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.CollectionDetailsPage;
import org.example.pageObjects.android.LibraryPage;
import org.example.pageObjects.android.SongDetailsPage;
import org.testng.Assert;

import static utils.DriverFactory.getDriver;

public class SongDetails_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public CollectionDetailsPage collectionDetailsPage = new CollectionDetailsPage(driver);
    public SongDetailsPage songDetailsPage = new SongDetailsPage(driver);
    @Given("User has selected collection {string} and song {string}")
    public void userHasSelectedCollectedAndSong(String collectionName, String songName) {
        collectionDetailsPage = libraryPage.goToCollectionPage(collectionName);
        songDetailsPage = collectionDetailsPage.goToSongDetailsPage(songName);
    }

    @When("User taps on the headphones button")
    public void userTapsOnTheHeadphonesButton() {
        songDetailsPage.getHeadphonesButton().click();
    }


    @Then("Mini player is displayed")
    public void miniPlayerIsDisplayed() {
        Assert.assertTrue(songDetailsPage.getMiniPlayer().isDisplayed());
    }

    @And("More Options button is displayed")
    public void moreOptionsButtonIsDisplayed() {
        Assert.assertTrue(songDetailsPage.getMiniPlayerMoreOptionsButton().isDisplayed());
    }

    @And("Previous Song button is displayed")
    public void previousSongButtonIsDisplayed() {
        Assert.assertTrue(songDetailsPage.getMiniPlayerPreviousButton().isDisplayed());
    }

    @And("Pause button is displayed")
    public void pauseButtonIsDisplayed() {
        Assert.assertTrue(songDetailsPage.getMiniPlayerPauseButton().isDisplayed());
    }

    @And("Next Song button is displayed")
    public void nextSongButtonIsDisplayed() {
        Assert.assertTrue(songDetailsPage.getMiniPlayerNextButton().isDisplayed());
    }

    @And("Current Time counter is displayed")
    public void currentTimeCounterIsDisplayed() {
        Assert.assertTrue(songDetailsPage.getMiniPlayerCurrentTime().isDisplayed());
    }

    @And("Progress Bar is displayed")
    public void progressBarIsDisplayed() {
        Assert.assertTrue(songDetailsPage.getMiniPlayerProgressBar().isDisplayed());
    }

    @And("Duration Time counter is displayed")
    public void durationTimeCounterIsDisplayed() {
        Assert.assertTrue(songDetailsPage.getMiniPlayerDuration().isDisplayed());
    }

    @And("Selected song should start playing")
    public void selectedSongShouldStartPlaying() {
        String actualMiniPlayerCurrentTime = songDetailsPage.getMiniPlayerCurrentTime().getText();
        Assert.assertNotEquals(actualMiniPlayerCurrentTime, "00:00");
    }

    @And("User taps on the next song button")
    public void userTapsOnTheNextSongButton() {
        songDetailsPage.getMiniPlayerNextButton().click();
    }

    @Then("Song next song named {string} should start playing")
    public void songNextSongNamedShouldStartPlaying(String nextSongName) throws InterruptedException {
        String actualSongName = songDetailsPage.getMiniPlayerSongName().getText();
        Assert.assertEquals(actualSongName, nextSongName);
        Thread.sleep(2000);
        String actualMiniPlayerCurrentTime = songDetailsPage.getMiniPlayerCurrentTime().getText();
        Assert.assertNotEquals(actualMiniPlayerCurrentTime, "00:00");
    }

    @And("User taps on the next song button twice")
    public void userTapsOnTheNextSongButtonTwice() {
        songDetailsPage.getMiniPlayerNextButton().click();
        songDetailsPage.getMiniPlayerNextButton().click();
    }

    @And("User taps on the previous song button once")
    public void userTapsOnThePreviousSongButtonOnce() {
        songDetailsPage.getMiniPlayerPreviousButton().click();
    }

    @Then("Song previous song named {string} should start playing")
    public void songPreviousSongNamedShouldStartPlaying(String previousSongName) {
        String actualSongName = songDetailsPage.getMiniPlayerSongName().getText();
        Assert.assertEquals(actualSongName, previousSongName);
        String actualMiniPlayerCurrentTime = songDetailsPage.getMiniPlayerCurrentTime().getText();
        Assert.assertNotEquals(actualMiniPlayerCurrentTime, "00:00");
    }
}
