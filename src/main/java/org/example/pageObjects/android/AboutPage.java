package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AboutPage extends BasePage {

    public AboutPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
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
