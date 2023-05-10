package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.LibraryPage;
import org.example.pageObjects.android.PlaylistsContentPage;
import org.example.pageObjects.android.PlaylistsDetailsPage;
import org.example.pageObjects.android.PlaylistsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.DriverFactory.getDriver;

public class Playlists_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public PlaylistsPage playlistsPage = new PlaylistsPage(driver);
    public PlaylistsDetailsPage playlistsDetailsPage = new PlaylistsDetailsPage(driver);
    public PlaylistsContentPage playlistsContentPage = new PlaylistsContentPage(driver);
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




}
