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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
    private WebElement aboutOption;

    public String getSettingsPageTitle() {
        return settingsTitle.getText();
    }

    public WebElement getOptionByText(String text) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
    }

    public String getOptionText(WebElement element) {
        return element.getText();
    }

    public AboutPage goToAboutPage() {
        aboutOption.click();
        return new AboutPage(driver);
    }

}
