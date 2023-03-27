package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class SettingsPage extends AndroidActions {

    AndroidDriver driver;

    public SettingsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
        sendFeedbackButton.click();
        return new FeedbackPage(driver);
    }

    public AboutPage goToAboutPage() {
        aboutOption.click();
        return new AboutPage(driver);
    }

    public LibraryPage clickBackButton() {
        backButton.click();
        return new LibraryPage(driver);
    }

}
