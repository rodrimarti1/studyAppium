package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class AboutPage extends AndroidActions {

    AndroidDriver driver;

    public AboutPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
    private WebElement aboutTitle;

    @AndroidFindBy(accessibility = "The Church of Jesus Christ of Latter-day Saints")
    private WebElement churchLogo;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Back']")
    private WebElement backButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Information']")
    private WebElement appInstanceButton;

    public String getAboutPageTitle() {
        return getAnyElement(aboutTitle).getText();
    }

    public WebElement getOptionByText(String text) {
        return getAnyElementByText(text);
    }

    public WebElement getChurchLogo() {
        return churchLogo;
    }

    public SettingsPage clickBackButton() {
        clickOnElement(backButton);
        return new SettingsPage(driver);
    }

    public WebElement getAppInstanceButton() {
        return appInstanceButton;
    }
}
