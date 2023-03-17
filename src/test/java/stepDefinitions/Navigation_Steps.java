package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.LibraryPage;
import org.example.pageObjects.android.TabsPage;
import org.testng.Assert;

import static utils.DriverFactory.getDriver;

public class Navigation_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public TabsPage tabsPage = new TabsPage(driver);
    @Given("User is in the Library Page")
    public void userIsInTheLibraryPage() {
        Assert.assertEquals(libraryPage.getLibraryPageTitle(), "Library");
    }

    @When("Navigation bar is visible")
    public void navigationBarIsVisible() {
        Assert.assertTrue(tabsPage.getNavBar().isDisplayed());
    }

    @Then("Navigation bar displays {word} option")
    public void navigationBarDisplaysOptionNameOption(String optionName) {
        tabsPage.getOptionByText(optionName);
    }
}
