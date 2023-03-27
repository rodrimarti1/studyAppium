package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.android.FeedbackPage;
import org.example.pageObjects.android.LibraryPage;
import org.example.pageObjects.android.SettingsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static utils.DriverFactory.getDriver;

public class SendFeedback_Steps {

    private AndroidDriver driver = getDriver();
    public LibraryPage libraryPage = new LibraryPage(driver);
    public SettingsPage settingsPage = new SettingsPage(driver);
    public FeedbackPage feedbackPage = new FeedbackPage(driver);
    @Given("User is in Settings screen and taps on Send Feedback option")
    public void userIsInSettingsScreenAndTapsOnSendFeedbackOption() {
        libraryPage.goToSettingsPage();
        Assert.assertEquals(settingsPage.getSettingsPageTitle(), "Settings");
        settingsPage.goToFeedbackPage();
    }

    @When("App renders Send Feedback Screen")
    public void appRendersSendFeedbackScreen() {
        String actualTitle = feedbackPage.getFeedbackPageTitle();
        Assert.assertEquals(actualTitle, "Send Feedback");
    }

    @Then("User should see the following options in the Send Feedback Screen:")
    public void userShouldSeeTheFollowingOptionsInTheSendFeedbackScreen(List<String> optionsList) {
        List<WebElement> elementsFound = new ArrayList<>();
        for(int i = 0; i < optionsList.size(); i++) {
            elementsFound.add(feedbackPage.getOptionByText(optionsList.get(i)));
        }
        Assert.assertEquals(elementsFound.size(), 4);
    }

    @And("User should see the Attachments button")
    public void userShouldSeeTheAttachmentsButton() {
        Assert.assertTrue(feedbackPage.attachButton.isDisplayed());
    }

    @And("User should see the Send button")
    public void userShouldSeeTheSendButton() {
        Assert.assertTrue(feedbackPage.submitButton.isDisplayed());
    }

    @Given("User is in Send Feedback screen")
    public void userIsInSendFeedbackScreen() {
        libraryPage.goToSettingsPage();
        settingsPage.goToFeedbackPage();
        String actualTitle = feedbackPage.getFeedbackPageTitle();
        Assert.assertEquals(actualTitle, "Send Feedback");
    }

    @When("User enters text to all required fields: {string} {string} {string} {string}")
    public void userEntersTextToAllRequiredFieldsNameEmailCategoryDescription(String name, String email, String category, String description) {
        feedbackPage.setNameField(name);
        feedbackPage.setEmailField(email);
        feedbackPage.setCategory(category);
        feedbackPage.setDescriptionField(description);
        feedbackPage.clickSubmitButton();
    }

    @Then("Send Feedback form can be successfully submitted")
    public void sendFeedbackFormCanBeSuccessfullySubmitted() {
        String actualTitle = settingsPage.getSettingsPageTitle();
        Assert.assertEquals(actualTitle, "Settings");
    }

    @When("User taps on Submit button")
    public void userTapsOnSubmitButton() {
        feedbackPage.clickSubmitButton();
    }

    @Then("User should the following error messages:")
    public void userShouldTheFollowingErrorMessages(List<String> errorMessages) {
        List<WebElement> elementsFound = new ArrayList<>();
        for(int i = 0; i < errorMessages.size(); i++) {
            elementsFound.add(feedbackPage.getOptionByText(errorMessages.get(i)));
        }
        Assert.assertEquals(elementsFound.size(), 3);
    }
}
