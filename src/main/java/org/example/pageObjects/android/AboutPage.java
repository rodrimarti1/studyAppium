package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
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

    public String getAboutPageTitle() {
        return aboutTitle.getText();
    }

    public WebElement getOptionByText(String text) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
    }

    public WebElement getChurchLogo() {
        return churchLogo;
    }
}
