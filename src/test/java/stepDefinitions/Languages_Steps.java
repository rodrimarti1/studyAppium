package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.LanguagesPage;
import org.example.pageObjects.android.LibraryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @Given("User has navigated to the Languages screen")
    public void userHasNavigatedToTheLanguagesScreen() {
        languagePage = libraryPage.goToLanguagePage();
    }

    @When("User searches for {word} language and selects it from the languages list")
    public void userSearchesForLanguageLanguageAndSelectsItFromTheLanguagesList(String language) {
        languagePage.searchAndSelectLanguageByName(language);
    }

    @Then("User should be taken to the library screen")
    public void userShouldBeTakenToTheLibraryScreen() {
        String pageTitle = libraryPage.getLibraryPageTitle();
        Assert.assertEquals(pageTitle, "Library");
    }

    @And("Album called {} should be displayed")
    public void albumCalledAlbumShouldBeDisplayed(String albumName) {
        WebElement albumCover = libraryPage.findAlbumByIndex(1);
        String actualAlbumName = albumCover.findElement(By.xpath("//android.widget.TextView")).getText().trim();
        Assert.assertEquals(actualAlbumName, albumName);
    }
}
