package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    AppiumDriver driver;

    public BasePage(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement getAnyElementByText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+ text +"']")));
    }

    public WebElement getAnyElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement getAnyElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void clickOnElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeysToElement(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeysToElement(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void hideAndroidKeyboard() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
