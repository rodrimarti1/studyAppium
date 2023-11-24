package org.example.pageObjects.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

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

    public void takeSnapShot(String screenshotName, String deviceType) throws Exception {

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            final String screenshotDirEnglish = "screenshots/en-US/graphics/";
            final String screenshotDirSpanish = "screenshots/es-ES/graphics/";
            final String screenshotDirFrench = "screenshots/fr-FR/graphics/";
            final String screenshotDirPortuguese = "screenshots/pt-PT/graphics/";
            final String screenshotDeviceType = deviceType + "-screenshots/";

            if (screenshotName.contains("english")) {
                String[] newFileName = screenshotName.split("_", 0);
                File destination = new File(screenshotDirEnglish + screenshotDeviceType + newFileName[0] + ".png");
                org.apache.commons.io.FileUtils.copyFile(screenshot, destination);
                System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
            } else if (screenshotName.contains("spanish")) {
                String[] newFileName = screenshotName.split("_", 0);
                File destination = new File(screenshotDirSpanish + screenshotDeviceType + newFileName[0] + ".png");
                org.apache.commons.io.FileUtils.copyFile(screenshot, destination);
                System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
            } else if (screenshotName.contains("french")) {
                String[] newFileName = screenshotName.split("_", 0);
                File destination = new File(screenshotDirFrench + screenshotDeviceType + newFileName[0] + ".png");
                org.apache.commons.io.FileUtils.copyFile(screenshot, destination);
                System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
            } else if (screenshotName.contains("portuguese")) {
                String[] newFileName = screenshotName.split("_", 0);
                File destination = new File(screenshotDirPortuguese + screenshotDeviceType + newFileName[0] + ".png");
                org.apache.commons.io.FileUtils.copyFile(screenshot, destination);
                System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hideAndroidKeyboard() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void swipeAction(WebElement element, String direction) {
        driver.executeScript("mobile: swipeGesture", new HashMap<String, Object>() {{
            put("elementId", ((RemoteWebElement) element).getId());
            put("percent", 0.5f); // 50% of the screen width
            put("direction", direction);
        }});

        // Java
        /*((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 550,
                "endY", 1200
        ));*/
    }
}
