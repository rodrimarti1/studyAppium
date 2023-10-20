package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.*;
import org.testng.Assert;

import java.util.List;

import static utils.DriverFactory.getDriver;

public class Playlists_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public PlaylistsPage playlistsPage = new PlaylistsPage(driver);
    public PlaylistsDetailsPage playlistsDetailsPage = new PlaylistsDetailsPage(driver);
    public PlaylistsContentPage playlistsContentPage = new PlaylistsContentPage(driver);
    public SongDetailsPage songDetailsPage = new SongDetailsPage(driver);
    public PlaylistContentSearchPage playlistContentSearchPage = new PlaylistContentSearchPage(driver);

    @Given("User taps on the Playlists option in the navigation bar")
    public void userTapsOnThePlaylistsOptionInTheNavigationBar() {
        playlistsPage = libraryPage.goToPlaylistsPage(null);
    }

    @When("User lands in Playlists screen")
    public void userLandsInPlaylistsScreen() {
        String actualTitle = playlistsPage.getPlaylistsPageTitle().getText();
        Assert.assertEquals(actualTitle, "Playlists");
    }

    @Then("User sees Playlists screen empty state")
    public void userSeesPlaylistsScreenEmptyState() {
        Assert.assertTrue(playlistsPage.getNoPlaylistsIcon().isDisplayed());
        Assert.assertTrue(playlistsPage.getNoPlaylistsMainText().isDisplayed());
        Assert.assertTrue(playlistsPage.getNoPlaylistsSubText().isDisplayed());
    }

    @When("User taps on the New Playlist button")
    public void userTapsOnTheNewPlaylistButton() {
        playlistsDetailsPage = playlistsPage.createNewPlaylist("English");
    }

    @And("User fills out Title field with text {string}")
    public void userFillsOutTitleFieldWithTextPlaylistName(String playlistName) {
        playlistsDetailsPage.getPlaylistName().sendKeys(playlistName);
    }

    @And("User fill out Description field with text {string}")
    public void userFillOutDescriptionFieldWithTextDescriptionText(String descriptionText) {
        playlistsDetailsPage.getPlaylistDescription().sendKeys(descriptionText);
    }

    @And("User taps on the Save button")
    public void userTapsOnTheSaveButton() {
        playlistsDetailsPage.getPlaylistSaveButton().click();
    }

    @Then("User should see a confirmation message with text {string}")
    public void userShouldSeeAConfirmationMessage(String confirmationText) {
        boolean isPlaylistCreated = playlistsDetailsPage.getConfirmationMessageByText(confirmationText).isDisplayed();
        Assert.assertTrue(isPlaylistCreated);
        playlistsDetailsPage.dismissConfirmationMessage();
    }

    @And("User should see new {string} playlist listed")
    public void userShouldSeeNewPlaylistListed(String playlistName) {
        boolean isNewPlaylistDisplayed = playlistsPage.getPlaylistByName(playlistName).isDisplayed();
        Assert.assertTrue(isNewPlaylistDisplayed);
    }


    @Given("User has navigated to the Playlist screen")
    public void userHasNavigatedToThePlaylistScreen() {
        playlistsPage = libraryPage.goToPlaylistsPage("English");
        String actualTitle = playlistsPage.getPlaylistsPageTitle().getText();
        Assert.assertEquals(actualTitle, "Playlists");
    }

    @And("User has created a new playlist named {string}")
    public void userHasCreatedANewPlaylistNamedPlaylistName(String playlistName) {
        playlistsDetailsPage = playlistsPage.createNewPlaylist("English");
        playlistsDetailsPage.getPlaylistName().sendKeys(playlistName);
        playlistsDetailsPage.getPlaylistSaveButton().click();
        playlistsPage = playlistsDetailsPage.dismissConfirmationMessage();
    }

    @When("User taps on the Delete Playlist option in the Ellipse Menu of the playlist named {string}")
    public void userTapsOnTheDeletePlaylistOptionInTheEllipseMenuOfThePlaylistNamedPlaylistName(String playlistName) {
        playlistsContentPage = playlistsPage.goToPlaylistContentPage(playlistName);
        playlistsContentPage.deletePlaylistByName("Delete Playlist");
    }

    @Then("User should no longer be able to see the playlist")
    public void userShouldNoLongerBeAbleToSeeThePlaylistNamedPlaylistName() {
        Assert.assertTrue(playlistsPage.getNoPlaylistsIcon().isDisplayed());
        Assert.assertTrue(playlistsPage.getNoPlaylistsMainText().isDisplayed());
        Assert.assertTrue(playlistsPage.getNoPlaylistsSubText().isDisplayed());
    }

    @Given("User has created a new playlist named {string} and navigated to the Library screen")
    public void userHasCreatedANewPlaylistNamedPlaylistNameAndNavigatedToTheLibraryScreen(String playlistName) {
        playlistsPage = libraryPage.goToPlaylistsPage("English");
        playlistsDetailsPage = playlistsPage.createNewPlaylist("English");
        playlistsDetailsPage.getPlaylistName().sendKeys(playlistName);
        playlistsDetailsPage.getPlaylistSaveButton().click();
        playlistsDetailsPage.dismissConfirmationMessage();
        libraryPage = libraryPage.goToLibraryPage();
    }

    @When("User taps on the Add to Playlist button in the Ellipse Menu")
    public void userTapsOnTheAddToPlaylistButtonInTheEllipseMenu() {
        songDetailsPage.getMoreOptionsMenu().click();
        libraryPage.getEllipseMenuOptionByName("Add to Playlist").click();
    }

    @And("User selects Playlist named {string}")
    public void userSelectsPlaylistNamedPlaylistName(String playlistName) {
        songDetailsPage.selectPlaylistByName(playlistName);
    }

    @Then("User should see song named {string} added to the playlist named {string}")
    public void userShouldSeeSongsAddedToThePlaylistNamedPlaylistName(String songName,String playlistName) {
        //playlistsPage = libraryPage.goToPlaylistsPage();
        //playlistsContentPage = playlistsPage.goToPlaylistContentPage(playlistName);
        Assert.assertTrue(playlistsContentPage.getPlaylistContentByName(songName).isDisplayed());
    }

    @Given("User has created and navigated to a new playlist named {string}")
    public void userHasCreatedAndNavigatedToANewPlaylistNamed(String arg0) {
        playlistsPage = libraryPage.goToPlaylistsPage("English");
        playlistsDetailsPage = playlistsPage.createNewPlaylist("English");
        playlistsDetailsPage.getPlaylistName().sendKeys(arg0);
        playlistsDetailsPage.getPlaylistSaveButton().click();
        playlistsPage = playlistsDetailsPage.dismissConfirmationMessage();
        playlistsContentPage = playlistsPage.goToPlaylistContentPage(arg0);
    }

    @When("User taps on the Playlists screen Ellipse Menu")
    public void userTapsOnThePlaylistsScreenEllipseMenu() {
        playlistsContentPage.getPlaylistsEllipseMenu().click();
    }

    @Then("User should see the following options in the Ellipse Menu:")
    public void userShouldSeeTheFollowingOptionsInTheEllipseMenu(List<String> ellipseOptions) {
        for (String option: ellipseOptions) {
            Assert.assertTrue(playlistsContentPage.getEllipseOptionByText(option).isDisplayed());
        }
    }

    @Given("User has created a new playlist named {string} and clicked on it")
    public void userHasCreatedANewPlaylistNamedPlaylistNameAndClickedOnIt(String playlistName) {
        playlistsPage = libraryPage.goToPlaylistsPage("English");
        playlistsDetailsPage = playlistsPage.createNewPlaylist("English");
        playlistsDetailsPage.getPlaylistName().sendKeys(playlistName);
        playlistsDetailsPage.getPlaylistSaveButton().click();
        playlistsPage = playlistsDetailsPage.dismissConfirmationMessage();
        playlistsContentPage = playlistsPage.goToPlaylistContentPage(playlistName);
    }

    @And("User taps on the Add a Song button")
    public void userTapsOnTheAddASongButton() {
        playlistContentSearchPage = playlistsContentPage.clickAddASong();
    }

    @When("User searches and selects {string} song")
    public void userSearchesAndSelectsSongNameSong(String songName) {
        playlistContentSearchPage.searchForContentByText(songName);
        playlistContentSearchPage.selectSongByName(songName);
        playlistContentSearchPage.clickAddSelectedButton("English");
    }

    @And("User taps on the Add Songs option in the pop up")
    public void userTapsOnTheAddSongsOptionInThePopUp() {
        playlistsContentPage = playlistContentSearchPage.clickAddSongsConfirmationButton();
    }

    @Then("User should see song named {string} added to the newly created playlist")
    public void userShouldSeeSongNamedSongNameAddedToTheNewlyCreatedPlaylist(String songName) {
        Assert.assertTrue(playlistsContentPage.getPlaylistContentByName(songName).isDisplayed());
    }

    @And("User should see the following options in the Ellipse Menu of each song")
    public void userShouldSeeTheFollowingOptionsInTheEllipseMenuOfEachSong(List<String> ellipseOptions) {
        playlistsContentPage.clickSongMoreOptionsMenu();
        for (String option: ellipseOptions) {
            Assert.assertTrue(playlistsContentPage.getEllipseOptionByText(option).isDisplayed());
        }
    }

    @Given("User has created a new playlist named {string} and added song named {string} to it")
    public void userHasCreatedANewPlaylistNamedPlaylistNameAndAddedSongNamedSongNameToIt(String playlistName, String songName) {
        playlistsPage = libraryPage.goToPlaylistsPage("English");
        playlistsDetailsPage = playlistsPage.createNewPlaylist("English");
        playlistsDetailsPage.getPlaylistName().sendKeys(playlistName);
        playlistsDetailsPage.getPlaylistSaveButton().click();
        playlistsPage = playlistsDetailsPage.dismissConfirmationMessage();
        playlistsContentPage = playlistsPage.goToPlaylistContentPage(playlistName);
        playlistContentSearchPage = playlistsContentPage.clickAddASong();
        playlistContentSearchPage.searchForContentByText(songName);
        playlistContentSearchPage.selectSongByName(songName);
        playlistContentSearchPage.clickAddSelectedButton("English");
        playlistsContentPage = playlistContentSearchPage.clickAddSongsConfirmationButton();
    }

    @When("User taps on the More Options menu for that song")
    public void userTapsOnTheMoreOptionsMenuForThatSong() {
        playlistsContentPage.clickSongMoreOptionsMenu();
    }

    @And("User taps on the Remove from Playlist button")
    public void userTapsOnTheRemoveFromPlaylistButton() {
        playlistsContentPage.clickOnOptionByName("Remove from Playlist");
    }

    @Then("User should no longer see the song in the playlist")
    public void userShouldNoLongerSeeTheSongNamedSongNameInThePlaylist() {
        Assert.assertTrue(playlistsContentPage.isPlaylistEmpty());
    }

    @When("User taps on the Playlist Play button")
    public void userTapsOnThePlaylistPlayButton() {
        playlistsContentPage.clickPlayButton();
    }

    @Then("Mini player should be displayed")
    public void miniPlayerShouldBeDisplayed() {
        Assert.assertTrue(playlistsContentPage.isMiniPlayerDisplayed());
    }

    @And("Mini player should reproduce song named {string}")
    public void miniPlayerShouldReproduceSongNamedSongName(String songName) {
        Assert.assertEquals(playlistsContentPage.getMiniPlayerSongName(songName), songName);
    }

    @When("User taps on the Playlist Shuffle button")
    public void userTapsOnThePlaylistShuffleButton() {
        playlistsContentPage.clickShuffleButton();
    }

    @And("User chooses View Playlist option in the confirmation modal")
    public void userChoosesViewPlaylistOptionInTheConfirmationModal() {
        playlistsContentPage = songDetailsPage.viewPlaylist();
    }

    @And("User selects Audio Type {string}")
    public void userSelectsAudioTypeAudioType(String audioType) {
        songDetailsPage.selectAudioType(audioType);
    }

    @Given("User has created a new playlist named {string} and selected the Add Songs option {string}")
    public void userHasCreatedANewPlaylistNamedPlaylistNameAndSelectedTheAddSongsOption(String playlistName, String languageName) {
        playlistsPage = libraryPage.goToPlaylistsPage(languageName);
        playlistsDetailsPage = playlistsPage.createNewPlaylist(languageName);
        playlistsDetailsPage.createPlaylist(playlistName, "", languageName);
        playlistsDetailsPage.getAddSongsButton(languageName).click();
    }

    @When("User taps on Library and selects collection {string} and selects several songs {string}")
    public void userTapsOnLibraryAndSelectsCollectionCollectionNameAndSelectsSeveralSongs(String collectionName, String languageName) {
        playlistContentSearchPage.getLibraryOption(languageName).click();
        libraryPage.goToCollectionPage(collectionName);
        playlistContentSearchPage.getSelectAllCheckbox().click();
    }

    @And("User taps on the Add Selected button {string}")
    public void userTapsOnTheAddSelectedButton(String languageName) {
        playlistContentSearchPage.clickAddSelectedButton(languageName);
    }
}
