package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.BasePage;
import org.example.pageObjects.android.LanguagesPage;
import org.example.pageObjects.android.LibraryPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import java.io.File;

import static utils.DriverFactory.getDriver;

public class Library_Steps {

    private AndroidDriver driver = getDriver();
    public BasePage basePage = new BasePage(driver);
    public LibraryPage libraryPage = new LibraryPage(driver);
    public LanguagesPage languagesPage = new LanguagesPage(driver);

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
        String title = libraryPage.getLibraryPageTitle("English");
        Assert.assertEquals(title, "Library");
        LanguagesPage languagePage = libraryPage.goToLanguagePage();
        languagePage.searchAndSelectLanguageByName("Portuguese");
        Boolean isMusicAlbumDisplayed = libraryPage.findAlbumByText("Músicas para Crianças").isDisplayed();
        Assert.assertTrue(isMusicAlbumDisplayed);
    }

    @Given("Users lands in Library Screen {string}")
    public void usersLandsInLibraryScreen(String languageName) {
        switch (languageName) {
            case "English" -> Assert.assertEquals(libraryPage.getLibraryPageTitle(languageName), "Library");
            case "Spanish", "Portuguese" ->
                    Assert.assertEquals(libraryPage.getLibraryPageTitle(languageName), "Biblioteca");
            case "French" -> Assert.assertEquals(libraryPage.getLibraryPageTitle(languageName), "Bibliothèque");
        }
    }

    @When("User taps on the Ellipse Menu")
    public void userTapsOnTheEllipseMenu() {
        boolean isMoreOptionsVisible = libraryPage.getMoreOptionsMenu("English").isDisplayed();
        Assert.assertTrue(isMoreOptionsVisible);

    }

    @Then("Users should see Language and Settings options")
    public void usersShouldSeeLanguageAndSettingsOptions() {
        libraryPage.getMoreOptionsMenu("English").click();

        WebElement ellipseLanguagesOption = libraryPage.getEllipseMenuOptionByName("Language");
        String ellipseOptionLanguagesOptionLabel = ellipseLanguagesOption.getText();
        System.out.println("Languages option text: " + ellipseOptionLanguagesOptionLabel);
        Assert.assertTrue(ellipseLanguagesOption.isDisplayed());
        Assert.assertEquals(ellipseOptionLanguagesOptionLabel, "Language");

        WebElement ellipseSettingsOption = libraryPage.getEllipseMenuOptionByName("Settings");
        String ellipseOptionSettingsOptionLabel = ellipseSettingsOption.getText();
        System.out.println("Settings option text: " + ellipseOptionSettingsOptionLabel);
        Assert.assertTrue(ellipseSettingsOption.isDisplayed());
        Assert.assertEquals(ellipseOptionSettingsOptionLabel, "Settings");
    }

    @Given("User switches app language to {string} {string}")
    public void userSwitchesAppLanguageToLanguageName(String languageName, String languageSearch) {
        libraryPage.getMoreOptionsMenu(languageName).click();
        switch (languageName) {
            case "English" -> libraryPage.getEllipseMenuOptionByName("Language").click();
            case "Spanish" -> libraryPage.getEllipseMenuOptionByName("Idioma").click();
            case "Portuguese" -> libraryPage.getEllipseMenuOptionByName("Português").click();
            case "French" -> libraryPage.getEllipseMenuOptionByName("Langue").click();
        }
        languagesPage.searchAndSelectLanguageByName(languageSearch);
    }

    @Parameters("deviceType")
    @Then("Take a screenshot of the {string} screen with file name {string}")
    public void takeAScreenshotOfTheLibraryScreenWithFileNameFileName(String featureName, String fileName) throws Exception {
        String deviceType = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("deviceType");
        String actualScreenshotName = featureName + "_" + fileName;
        basePage.takeSnapShot(actualScreenshotName, deviceType);
    }
}
