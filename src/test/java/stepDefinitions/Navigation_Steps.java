package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.LibraryPage;
import org.example.pageObjects.android.TabsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

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

    @Then("Navigation bar displays the following options:")
    public void navigationBarDisplaysOptionNameOption(List<String> optionsList) {
        List<WebElement> elementsFound = new ArrayList<>();
        for(int i = 0; i < optionsList.size(); i++) {
            elementsFound.add(tabsPage.getOptionByText(optionsList.get(i)));
        }
        Assert.assertEquals(elementsFound.size(), 4);
    }
}
