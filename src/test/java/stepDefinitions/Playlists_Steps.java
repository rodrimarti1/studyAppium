package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.*;
import org.testng.Assert;

import static utils.DriverFactory.getDriver;

public class Playlists_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public PlaylistsPage playlistsPage = new PlaylistsPage(driver);
    public PlaylistsDetailsPage playlistsDetailsPage = new PlaylistsDetailsPage(driver);
    public PlaylistsContentPage playlistsContentPage = new PlaylistsContentPage(driver);
    public SongDetailsPage songDetailsPage = new SongDetailsPage(driver);
    @Given("User taps on the Playlists option in the navigation bar")
    public void userTapsOnThePlaylistsOptionInTheNavigationBar() {
        playlistsPage = libraryPage.goToPlaylistsPage();
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
        playlistsDetailsPage = playlistsPage.createNewPlaylist();
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
        playlistsPage = libraryPage.goToPlaylistsPage();
        String actualTitle = playlistsPage.getPlaylistsPageTitle().getText();
        Assert.assertEquals(actualTitle, "Playlists");
    }

    @And("User has created a new playlist named {string}")
    public void userHasCreatedANewPlaylistNamedPlaylistName(String playlistName) {
        playlistsDetailsPage = playlistsPage.createNewPlaylist();
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
        playlistsPage = libraryPage.goToPlaylistsPage();
        playlistsDetailsPage = playlistsPage.createNewPlaylist();
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
        playlistsPage = libraryPage.goToPlaylistsPage();
        playlistsContentPage = playlistsPage.goToPlaylistContentPage(playlistName);
        Assert.assertTrue(playlistsContentPage.getPlaylistContentByName(songName).isDisplayed());
    }
}
