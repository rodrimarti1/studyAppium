package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.AboutPage;
import org.example.pageObjects.android.LibraryPage;
import org.example.pageObjects.android.SettingsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static utils.DriverFactory.getDriver;

public class About_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public SettingsPage settingsPage = new SettingsPage(driver);
    public AboutPage aboutPage = new AboutPage(driver);
    @Given("User is in Settings screen")
    public void userIsInSettingsScreen() {
        libraryPage.goToSettingsPage();
    }

    @When("User taps on the About option")
    public void userTapsOnTheAboutOption() {
        settingsPage.goToAboutPage();
        String actualTile = aboutPage.getAboutPageTitle();
        Assert.assertEquals(actualTile, "About");
    }

    @Then("User should see the following options:")
    public void userShouldSeeTheFollowingOptions(List<String> optionsList) {
        List<WebElement> elementsFound = new ArrayList<>();
        for(int i = 0; i < optionsList.size(); i++) {
            elementsFound.add(aboutPage.getOptionByText(optionsList.get(i)));
        }
        Assert.assertEquals(elementsFound.size(), 6);
        Assert.assertTrue(aboutPage.getChurchLogo().isDisplayed());
    }

    @Given("User is in About screen")
    public void userIsInAboutScreen() {
        libraryPage.goToSettingsPage();
        settingsPage.goToAboutPage();
        String actualTitle = aboutPage.getAboutPageTitle();
        Assert.assertEquals(actualTitle, "About");
    }

    @When("User taps on the About screen back button")
    public void userTapsOnAboutScreenTheBackButton() {
        aboutPage.clickBackButton();
    }

    @Then("User is taken back to the Settings screen")
    public void userIsTakenBackToTheSettingsScreen() {
        String actualTitle = settingsPage.getSettingsPageTitle();
        Assert.assertEquals(actualTitle, "Settings");
    }

    @And("User should see the App Instance button")
    public void userShouldSeeTheAppInstanceButton() {
        Assert.assertTrue(aboutPage.getAppInstanceButton().isDisplayed());
    }
}
