package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.LanguagesPage;
import org.example.pageObjects.android.LibraryPage;
import org.testng.Assert;

import static utils.DriverFactory.getDriver;

public class Languages_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public LanguagesPage languagePage;
    @Given("The app has fully loaded and user lands in Library screen")
    public void theAppHasFullyLoadedAndUserLandsInLibraryScreen() {
        System.out.println("Nothing to do here - Refer to src/test/java/runners/MainRunner.java");
    }

    @When("User taps on the Ellipse Menu and selects Languages option")
    public void userTapsOnTheEllipseMenuAndSelectsLanguagesOption() {
        languagePage = libraryPage.goToLanguagePage();
    }

    @Then("User is taken to the Languages page")
    public void userIsTakenToTheLanguagesPage() {
        String languagesPageTitle = languagePage.getLanguagesPageTitle();
        Assert.assertEquals(languagesPageTitle, "Languages");
        libraryPage.goToLibraryPage();
    }
}
