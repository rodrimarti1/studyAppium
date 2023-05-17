package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LanguagesPage extends BasePage {

    public LanguagesPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement languageSearchBar;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Languages']")
    private WebElement languagesTitle;

    public String getLanguagesPageTitle() {
        return getAnyElement(languagesTitle).getText();
    }

    public void searchAndSelectLanguageByName(String languageName) {
        sendKeysToElement(languageSearchBar, languageName);
        clickOnElement(By.xpath("//android.widget.TextView[@text='"+languageName+"']"));
    }

    public void selectLanguageByName(String languageName) {
        WebElement languageBox = getAnyElement(By.xpath("//android.widget.TextView[@text='"+languageName+"']"));
        clickOnElement(languageBox);
    }

    public void scrollAndSelectLanguageByText(String languageName) {
        //scrollToText(languageName);
        WebElement languageBox = getAnyElement(By.xpath("//android.widget.TextView[@text='"+languageName+"']"));
        clickOnElement(languageBox);
    }
}
