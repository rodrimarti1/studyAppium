package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.LibraryPage;
import org.example.pageObjects.android.SearchPage;
import org.example.pageObjects.android.SettingsPage;
import org.example.pageObjects.android.TabsPage;
import org.testng.Assert;

import static utils.DriverFactory.getDriver;

public class Search_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public TabsPage tabsPage = new TabsPage(driver);
    public SearchPage searchPage = new SearchPage(driver);
    @Given("User has navigated to the search page")
    public void userHasNavigatedToTheSearchPage() {
        libraryPage.goToSearchPage();
        String actualTitle = searchPage.getSearchPageTitle();
        Assert.assertEquals(actualTitle, "Search");
    }

    @When("User enters valid criteria {word} in the search box")
    public void userEntersValidSearchCriteriaInTheSearchBox(String searchCriteria) {
        searchPage.searchSongByName(searchCriteria);
    }

    @Then("Global search returns at least {int} song that matches the search criteria {word}")
    public void globalSearchReturnsAtLeastASongThatMatchesTheSearchCriteria(int numberOfSongs, String searchCriteria) {
        int songsFound = searchPage.getSongFromSearchResults(searchCriteria).size();
        if (songsFound > numberOfSongs) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @When("User enters invalid {word} in the search box")
    public void userEntersInvalidSearchCriteriaInTheSearchBox(String searchCriteria) {
        searchPage.searchSongByName(searchCriteria);
    }

    @Then("Global search shouldn't be able to find any song matching the search criteria {word}")
    public void globalSearchShouldnTBeAbleToFindAnySongMatchingTheSearchCriteria(String searchCriteria) {
        int songsFound = searchPage.getSongFromSearchResults(searchCriteria).size();
        if (songsFound == 1) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @When("User enters {word} in the search box")
    public void userEntersSpecialCharactersInTheSearchBox(String searchCriteria) {
        searchPage.searchSongByName(searchCriteria);
    }

    @And("The app shouldn't crash")
    public void theAppShouldnTCrash() {
        Assert.assertTrue(tabsPage.getNavBar().isDisplayed());
    }

    @When("User taps on the back button")
    public void userTapsOnTheBackButton() {
        searchPage.getBackButton().click();
    }

    @When("User enters search {word} in the search box but doesn't click on the seach button")
    public void userEntersSearCriteriaInTheSearchBoxButDoesnTClickOnTheSeachButton(String searchCriteria) {
        searchPage.setSearchBar(searchCriteria);
    }

    @Then("X button is displayed at the left end of the search box")
    public void xButtonIsDisplayedAtTheLeftEndOfTheSearchBox() {
        Assert.assertTrue(searchPage.getClearButton().isDisplayed());
    }

    @When("User enters valid criteria {word} in the search box and clicks on the X button")
    public void userEntersValidCriteriaCriteriaInTheSearchBoxAndClicksOnTheXButton(String searchCriteria) {
        searchPage.setSearchBar(searchCriteria);
        searchPage.getClearButton().click();
    }

    @Then("Text entered in the search box is cleared")
    public void textEnteredInTheSearchBoxIsCleared() {
        Assert.assertEquals(searchPage.getSearchBar().getText(), "");
    }
}
