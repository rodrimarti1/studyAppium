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

public class Downloads_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public TabsPage tabsPage = new TabsPage(driver);
    public CollectionDetailsPage collectionDetailsPage = new CollectionDetailsPage(driver);
    public DownloadsPage downloadsPage = new DownloadsPage(driver);
    @Given("User has navigated to the collection {string}")
    public void userHasNavigatedToTheCollectionCollectionName(String collectionName) {
        collectionDetailsPage = libraryPage.goToCollectionPage(collectionName);
    }

    @When("User taps on the More Options menu for the song named {string} and taps on the Download option and selects audio type {string}")
    public void userTapsOnTheMoreOptionsMenuForTheSongNamedSongNameAndTapsOnTheDownloadOptionsAndSelectsAudioTypeAudioType(String songName, String audioType) {
        collectionDetailsPage.downloadSong(songName, audioType);
    }

    @Then("User should see checkmark next to the song named {string} indicating it was successfully downloaded")
    public void userShouldSeeCheckmarkNextToTheSongNamedSongNameIndicatingItWasSuccessfullyDownloaded(String songName) {
        Assert.assertTrue(collectionDetailsPage.isSongDownloaded(songName));
    }

    @Given("User has downloaded song named {string} with audio type {string} from collection {string}")
    public void userHasDownloadedSongNamedSongNameWithAudioTypeAudioTypeFromCollectionCollectionName(String songName, String audioType, String collectionName) {
        collectionDetailsPage = libraryPage.goToCollectionPage(collectionName);
        collectionDetailsPage.downloadSong(songName, audioType);
        collectionDetailsPage.isSongDownloaded(songName);
    }

    @When("User navigates to the Downloads tab")
    public void userNavigatesToTheDownloadsTab() {
        downloadsPage = tabsPage.goToDownloadsPage();
    }

    @Then("User sees song named {string} listed")
    public void userSeesSongNamedSongNameListed(String songName) {
        downloadsPage.isSongDownloaded(songName);
    }

    @When("User taps on the More Options menu for the song named {string} and taps on the Remove Download option")
    public void userTapsOnTheMoreOptionsMenuForTheSongNamedSongNameAndTapsOnTheRemoveDownloadOption(String songName) {
        downloadsPage.deleteDownloadedSong(songName);
    }

    @Then("User should no longer see the song in the list")
    public void userShouldNoLongerSeeTheSongInTheList() {
        Assert.assertTrue(downloadsPage.isDownloadsEmpty());
    }

    @When("User taps on the More Options menu for the song named {string} and taps on the Remove Download option, but decides not to delete it")
    public void userTapsOnTheMoreOptionsMenuForTheSongNamedSongNameAndTapsOnTheRemoveDownloadOptionButDecidesNotToDeleteIt(String songName) {
        downloadsPage.leaveDownloadedSong(songName);
    }

    @Then("User should see the word {string} in the title")
    public void userShouldSeeTheWordInTheTitle(String expectedTitleText) {
        String actualTitleText = downloadsPage.getDownloadsPageTitle();
        Assert.assertEquals(actualTitleText, expectedTitleText);
    }

    @And("User should see the Search icon in top right corner")
    public void userShouldSeeTheSearchIconInTopRightCorner() {
        Assert.assertTrue(downloadsPage.getSearchIcon().isDisplayed());
    }

    @And("User should see the More Options menu in the top right corner")
    public void userShouldSeeTheMoreOptionsMenuInTheTopRightCorner() {
        Assert.assertTrue(downloadsPage.getMoreOptionsMenu().isDisplayed());
    }

    @When("User taps on the More Options menu for the song named {string}")
    public void userTapsOnTheMoreOptionsMenuForTheSongNamedSongName(String songName) {
        downloadsPage.clickMoreOptionBySongName(songName);
    }

    @Then("User should see following options listed")
    public void userShouldSeeFollowingOptionsListed(List<String> displayedOptions) {
        for (String element: displayedOptions) {
            Assert.assertTrue(downloadsPage.isOptionDisplayedInMoreOptions(element));
        }
    }
}
