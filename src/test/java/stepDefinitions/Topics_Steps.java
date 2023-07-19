package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.*;
import org.testng.Assert;

import static utils.DriverFactory.getDriver;

public class Topics_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public TabsPage tabsPage = new TabsPage(driver);
    public TopicsPage topicsPage = new TopicsPage(driver);
    public TopicsDetailsPage topicsDetailsPage = new TopicsDetailsPage(driver);
    public PlaylistsPage playlistsPage = new PlaylistsPage(driver);
    public PlaylistsDetailsPage playlistsDetailsPage = new PlaylistsDetailsPage(driver);
    public PlaylistsContentPage playlistsContentPage = new PlaylistsContentPage(driver);
    @When("User navigates to the Topics tab")
    public void userNavigatesToTheTopicsTab() {
        topicsPage = tabsPage.goToTopicsPage();
    }

    @Then("User should see the word {string} in the Topics page title")
    public void userShouldSeeTheWordInTheTopicsPageTitle(String expectedPageTitle) {
        String actualPageTitle = topicsPage.getTopicsTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @And("User should see the Search icon in the top right corner of the Topics Page")
    public void userShouldSeeTheSearchIconInTheTopRightCornerOfTheTopicsPage() {
        Assert.assertTrue(topicsPage.getSearchIcon().isDisplayed());
    }

    @And("User should see the More Options menu in the top right corner of the Topics Page")
    public void userShouldSeeTheMoreOptionsMenuInTheTopRightCornerOfTheTopicsPage() {
        Assert.assertTrue(topicsPage.getMoreOptions().isDisplayed());
    }

    @Given("User is in the Topics screen")
    public void userIsInTheTopicsScreen() {
        topicsPage = tabsPage.goToTopicsPage();
    }

    @When("User enters valid criteria {string} in the search bar")
    public void userEntersValidCriteriaInTheSearchBar(String validSearchCriteria) {
        topicsPage.performTopicsSearch(validSearchCriteria);
    }

    @Then("User should see search result with name {string} returned")
    public void userShouldSeeSearchResultWithNameReturned(String searchResultText) {
        Assert.assertTrue(topicsPage.isSearchFound(searchResultText));
    }

    @Given("User is in the Topics screen and taps on Topic called {string}")
    public void userIsInTheTopicsScreenAndTapsOnTopicCalled(String topicName) {
        topicsPage = tabsPage.goToTopicsPage();
        topicsDetailsPage = topicsPage.clickTopicByName(topicName);
    }

    @When("User taps on the More Options menu for the song called {string} and chooses to {string} it audio type {string}")
    public void userTapsOnTheMoreOptionsMenuForTheSongCalledAndChoosesToItAudioType(String songName, String action, String audioType) {
        topicsDetailsPage.performActionOnSpecificSong(songName, action, audioType);
    }

    @Then("User should see the green checkmark indicating the song called {string} was downloaded")
    public void userShouldSeeTheGreenCheckmarkIndicatingTheSongCalledWasDownloaded(String songName) {
        topicsDetailsPage.isSongDownloaded(songName);
    }

    @When("User taps on the More Options menu and chooses to add song called {string} with audio type {string} to a new playlist")
    public void userTapsOnTheMoreOptionsMenuAndChoosesToAddSongCalledSongNameWithAudioTypeAudioTypeToAPlaylist(String songName, String audioType) {
        playlistsPage = topicsDetailsPage.addSongToPlaylist(songName, audioType);
        playlistsDetailsPage = playlistsPage.createNewPlaylist();
    }

    @And("User creates a new playlist named {string}")
    public void userCreatesANewPlaylistNamed(String playlistName) {
        playlistsContentPage = playlistsDetailsPage.topicsCreatePlaylistAndView(playlistName, "");
    }

    @Then("User should see the song called {string} added to the playlist")
    public void userShouldSeeTheSongCalledAddedToThePlaylist(String songName) {
        Assert.assertTrue(playlistsContentPage.getPlaylistContentByName(songName).isDisplayed());
    }


    @Given("User has previously created a playlist called {string} and is now in the Topics screen and taps on Topic called {string}")
    public void userHasPreviouslyCreatedAPlaylistCalledAndIsNowInTheTopicsScreenAndTapsOnTopicCalled(String playlistName, String topicName) {
        playlistsPage = tabsPage.goToPlaylistsPage();
        playlistsDetailsPage = playlistsPage.createNewPlaylist();
        playlistsPage = playlistsDetailsPage.createPlaylist(playlistName, "");
        playlistsDetailsPage.dismissConfirmationMessage();
        topicsPage = tabsPage.goToTopicsPage();
        topicsDetailsPage = topicsPage.clickTopicByName(topicName);
    }

    @When("User taps on the More Options menu and chooses to add song called {string} with audio type {string} to an existing playlist")
    public void userTapsOnTheMoreOptionsMenuAndChoosesToAddSongCalledSongNameWithAudioTypeAudioTypeToAnExistingPlaylist(String songName, String audioType) {
        playlistsPage = topicsDetailsPage.addSongToPlaylist(songName, audioType);
    }

    @And("User selects the existing playlist named {string}")
    public void userSelectsTheExistingPlaylistNamed(String playlistName) {
        playlistsPage.selectExistingPlaylist(playlistName);
        playlistsPage.viewPlaylistOrDismissPopup("View Playlist");
    }


}
