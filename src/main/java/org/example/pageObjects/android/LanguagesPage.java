package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class LanguagesPage extends AndroidActions {

    AndroidDriver driver;

    public LanguagesPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement languageSearchBar;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Languages']")
    private WebElement languagesTitle;

    public String getLanguagesPageTitle() {
        return languagesTitle.getText();
    }

    public void searchAndSelectLanguageByName(String languageName) {
        languageSearchBar.sendKeys(languageName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+languageName+"']")).click();
    }

    public void selectLanguageByName(String languageName) {
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+languageName+"']")).click();
    }

    public void scrollAndSelectLanguageByText(String languageName) {
        scrollToText(languageName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+languageName+"']"));
    }
}
