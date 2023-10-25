package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;

import static utils.DriverFactory.getDriver;

public class SongDetails_Steps {

    private AndroidDriver driver = getDriver();
    public BasePage basePage = new BasePage(driver);
    public LibraryPage libraryPage = new LibraryPage(driver);
    public TabsPage tabsPage = new TabsPage(driver);
    public CollectionDetailsPage collectionDetailsPage = new CollectionDetailsPage(driver);
    public SongDetailsPage songDetailsPage = new SongDetailsPage(driver);
    @Given("User has selected collection {string} and song {string}")
    public void userHasSelectedCollectedAndSong(String collectionName, String songName) {
        collectionDetailsPage = libraryPage.goToCollectionPage(collectionName);
        songDetailsPage = collectionDetailsPage.goToSongDetailsPage(songName);
    }

    @When("User taps on the More Options")
    public void userTapsOnTheMoreOptions() {
        songDetailsPage.getMoreOptionsMenu().click();
    }

    @And("User taps on the Play button")
    public void userTapsOnThePlayButton() {
        libraryPage.getEllipseMenuOptionByName("Play").click();
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
        Assert.assertTrue(songDetailsPage.getMiniPlayerPlayPauseButton().isDisplayed());
    }

    @And("Next Song button is displayed")
    public void nextSongButtonIsDisplayed() {
        Assert.assertTrue(songDetailsPage.getMiniPlayerNextButton("English").isDisplayed());
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
        songDetailsPage.getMiniPlayerNextButton("English").click();
    }

    @Then("Song next song named {string} should start playing")
    public void songNextSongNamedShouldStartPlaying(String nextSongName) throws InterruptedException {
        boolean currentSongName = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ nextSongName +"']")).isDisplayed();
        Assert.assertTrue(currentSongName);
    }

    @When("User taps on the next song button twice")
    public void userTapsOnTheNextSongButtonTwice() {
        songDetailsPage.getMiniPlayerNextButton("English").click();
        songDetailsPage.getMiniPlayerNextButton("English").click();
    }

    @And("User taps on the previous song button once")
    public void userTapsOnThePreviousSongButtonOnce() {
        songDetailsPage.getMiniPlayerPreviousButton().click();
    }

    @Then("Song previous song named {string} should start playing")
    public void songPreviousSongNamedShouldStartPlaying(String previousSongName) throws InterruptedException {
        boolean currentSongName = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ previousSongName +"']")).isDisplayed();
        Assert.assertTrue(currentSongName);
    }

    @Given("User has selected and played collection {string} and song {string}")
    public void userHasSelectedAndPlayedCollectionCollectionNameAndSongSongName(String collectionName, String songName) {
        collectionDetailsPage = libraryPage.goToCollectionPage(collectionName);
        songDetailsPage = collectionDetailsPage.goToSongDetailsPage(songName);
        songDetailsPage.getMoreOptionsMenu().click();
        libraryPage.getEllipseMenuOptionByName("Play").click();
    }

    @When("User rotates phone screen")
    public void userRotatesPhoneScreen() throws InterruptedException {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    @Then("Song should keep playing")
    public void songShouldKeepPlaying() {
        boolean isMusicPlayerDisplayed = songDetailsPage.getMiniPlayer().isDisplayed();
        Assert.assertTrue(isMusicPlayerDisplayed);
    }

    @When("User switches to the {string} tab")
    public void userSwitchesToTheTabNameTab(String tabName) {
        switch (tabName) {
            case "Topics" -> tabsPage.goToTopicsPage();
            case "Playlists" -> tabsPage.goToPlaylistsPage();
            case "Downloads" -> tabsPage.goToDownloadsPage();
            default -> {
            }
        }
    }

    @And("User goes back to collection {string} and song {string}")
    public void userGoesBackToCollectionCollectionNameAndSongSongName(String collectionName, String songName) throws InterruptedException {
        tabsPage.goToLibraryPage();
        collectionDetailsPage = libraryPage.goToCollectionPage(collectionName);
        songDetailsPage = collectionDetailsPage.goToSongDetailsPage(songName);
        Assert.assertTrue(songDetailsPage.getMiniPlayer().isDisplayed());
        Thread.sleep(2000);
        String actualMiniPlayerCurrentTime = songDetailsPage.getMiniPlayerCurrentTime().getText();
        Assert.assertNotEquals(actualMiniPlayerCurrentTime, "00:00");
    }


    @Given("User has selected and played collection {string}")
    public void userHasSelectedAndPlayedCollectionCollectionNameWithAudioTypeAudioType(String collectionName) {
        collectionDetailsPage = libraryPage.goToCollectionPage(collectionName);
        collectionDetailsPage.getSongListPlayButton("English").click();
    }
    @And("User maximizes music player {string}")
    public void userMaximizesMusicPlayer(String languageName) {
        collectionDetailsPage.maximizeMusicPlayer(languageName);
    }

    @Then("Take a screenshot of the {string} with file name {string}")
    public void takeAScreenshotOfTheSheetMusicSongViewWithFileNameFileName(String featureName, String fileName) throws Exception {
        String actualScreenshotName = featureName + "_" + fileName;
        basePage.takeSnapShot(actualScreenshotName);
    }

    @And("Wait for Next Song button to be displayed {string}")
    public void waitForNextSongButtonToBeDisplayed(String languageName) {
        basePage.waitForElement(songDetailsPage.getMiniPlayerNextButton(languageName));
    }

    @Given("User has selected and played collection {string} and song {string} and waited for song views to load {string}")
    public void userHasSelectedAndPlayedCollectionCollectionNameAndSongSongNameAndWaitedForSongViewsToLoad(String collectionName, String songName, String languageName) {
        collectionDetailsPage = libraryPage.goToCollectionPage(collectionName);
        songDetailsPage = collectionDetailsPage.goToSongDetailsPage(songName);

        switch (languageName) {
            case "Spanish" -> Assert.assertTrue(songDetailsPage.getSelectedSongViewByText("Partitura (de tamaño variable)").isDisplayed());
            case "French" -> Assert.assertTrue(songDetailsPage.getSelectedSongViewByText("Partition (PDF)").isDisplayed());
            case "Portuguese" -> Assert.assertTrue(songDetailsPage.getSelectedSongViewByText("Partitura (PDF)").isDisplayed());
            default -> Assert.assertTrue(songDetailsPage.getSelectedSongViewByText("Sheet Music (Resizable)").isDisplayed());
        }
    }

    @And("User has selected the Sheet Music PDF song view {string}")
    public void userHasSelectedTheSheetMusicPDFSongView(String languageName) throws InterruptedException {
        Assert.assertTrue(songDetailsPage.getMainPlayButton(languageName).isDisplayed());

        switch (languageName) {
            case "Spanish" -> songDetailsPage.getSelectedSongViewByText("Partitura (de tamaño variable)").click();
            case "French" -> songDetailsPage.getSelectedSongViewByText("Partition (ajustable)").click();
            case "Portuguese" -> songDetailsPage.getSelectedSongViewByText("Partitura (redimensionável)").click();
            default -> songDetailsPage.getSelectedSongViewByText("Sheet Music (Resizable)").click();
        }
        switch (languageName) {
            case "Spanish", "Portuguese" -> songDetailsPage.getSelectedSongViewByText("Partitura (PDF)").click();
            case "French" -> songDetailsPage.getSelectedSongViewByText("Partition (PDF)").click();
            default -> songDetailsPage.getSelectedSongViewByText("Sheet Music (PDF)").click();
        }
    }


    @When("User Sheet Music {string} song view is visible {string}")
    public void userSheetMusicTypeSongViewIsVisible(String type, String languageName) {
        Assert.assertTrue(songDetailsPage.getSelectedSongViewByText(type).isDisplayed());
        Assert.assertTrue(songDetailsPage.getMainPlayButton(languageName).isDisplayed());
    }
}
