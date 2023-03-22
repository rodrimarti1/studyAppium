package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.LibraryPage;
import org.example.pageObjects.android.SettingsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static utils.DriverFactory.getDriver;

public class Settings_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public SettingsPage settingsPage = new SettingsPage(driver);
    @Given("User taps on the Ellipse Menu and selects Settings option")
    public void userTapsOnTheEllipseMenuAndSelectsSettingsOption() {
        libraryPage.goToSettingsPage();
    }

    @When("Settings page is visible")
    public void settingsPageIsVisible() {
        String actualTile = settingsPage.getSettingsPageTitle();
        Assert.assertEquals(actualTile, "Settings");
    }

    @Then("User should be able to see the following options:")
    public void userShouldBeAbleToSeeTheFollowingOptions(List<String> optionsList) {
        List<WebElement> elementsFound = new ArrayList<>();
        for(int i = 0; i < optionsList.size(); i++) {
            elementsFound.add(settingsPage.getOptionByText(optionsList.get(i)));
        }
        Assert.assertEquals(elementsFound.size(), 9);
    }

    @When("User taps on the Settings screen back button")
    public void userTapsOnTheSettingsScreenBackButton() {
        settingsPage.clickBackButton();
    }

    @Then("User is taken back to the Library screen")
    public void userIsTakenBackToTheLibraryScreen() {
        String actualTitle = libraryPage.getLibraryPageTitle();
        Assert.assertEquals(actualTitle, "Library");
    }
}
