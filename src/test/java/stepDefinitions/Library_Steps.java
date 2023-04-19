package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.LanguagesPage;
import org.example.pageObjects.android.LibraryPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import static utils.DriverFactory.getDriver;

public class Library_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);

    @Given("User launches the SM Android App")
    public void user_launches_the_sm_android_app() {
        System.out.println("Nothing to do here - Refer to src/test/java/runners/MainRunner.java");
    }

    @When("The app loads")
    public void the_app_loads() {
        System.out.println("Nothing to do here - Refer to src/test/java/runners/MainRunner.java");
    }

    @Then("User should land in library page")
    public void user_should_land_in_library_page() {
        System.out.println("All library screen assertions");
        String title = libraryPage.getLibraryPageTitle();
        Assert.assertEquals(title, "Library");
        LanguagesPage languagePage = libraryPage.goToLanguagePage();
        languagePage.searchAndSelectLanguageByName("Portuguese");
        Boolean isMusicAlbumDisplayed = libraryPage.findAlbumByText("Músicas para Crianças").isDisplayed();
        Assert.assertTrue(isMusicAlbumDisplayed);
    }

    @Given("Users lands in Library Screen")
    public void usersLandsInLibraryScreen() {
        System.out.println("Nothing to do here - Refer to src/test/java/runners/MainRunner.java");
    }

    @When("User taps on the Ellipse Menu")
    public void userTapsOnTheEllipseMenu() {
        boolean isMoreOptionsVisible = libraryPage.getMoreOptionsMenu().isDisplayed();
        Assert.assertTrue(isMoreOptionsVisible);

    }

    @Then("Users should see Search, Languages and Settings options")
    public void users_should_see_search_languages_and_settings_options() {
        libraryPage.getMoreOptionsMenu().click();

        WebElement ellipseSearchOption = libraryPage.getEllipseMenuOptionByName("Search");
        String ellipseOptionSearchOptionLabel = ellipseSearchOption.getText();
        System.out.println("Search option text: " + ellipseOptionSearchOptionLabel);
        Assert.assertTrue(ellipseSearchOption.isDisplayed());
        Assert.assertEquals(ellipseOptionSearchOptionLabel, "Search");

        WebElement ellipseLanguagesOption = libraryPage.getEllipseMenuOptionByName("Languages");
        String ellipseOptionLanguagesOptionLabel = ellipseLanguagesOption.getText();
        System.out.println("Languages option text: " + ellipseOptionLanguagesOptionLabel);
        Assert.assertTrue(ellipseLanguagesOption.isDisplayed());
        Assert.assertEquals(ellipseOptionLanguagesOptionLabel, "Languages");

        WebElement ellipseSettingsOption = libraryPage.getEllipseMenuOptionByName("Settings");
        String ellipseOptionSettingsOptionLabel = ellipseSettingsOption.getText();
        System.out.println("Settings option text: " + ellipseOptionSettingsOptionLabel);
        Assert.assertTrue(ellipseSettingsOption.isDisplayed());
        Assert.assertEquals(ellipseOptionSettingsOptionLabel, "Settings");

    }
}
