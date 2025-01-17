package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage {

    public SettingsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private WebElement settingsTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send Feedback']")
    private WebElement sendFeedbackButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
    private WebElement aboutOption;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Back']")
    private WebElement backButton;

    public String getSettingsPageTitle() {
        return settingsTitle.getText();
    }

    public WebElement getOptionByText(String text) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
    }

    public String getOptionText(WebElement element) {
        return element.getText();
    }

    public FeedbackPage goToFeedbackPage() {
        clickOnElement(sendFeedbackButton);
        return new FeedbackPage(driver);
    }

    public AboutPage goToAboutPage() {
        clickOnElement(aboutOption);
        return new AboutPage(driver);
    }

    public LibraryPage clickBackButton() {
        clickOnElement(backButton);
        return new LibraryPage(driver);
    }

}
