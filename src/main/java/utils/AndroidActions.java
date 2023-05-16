package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidActions extends AppiumUtils{

    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;

    }

    public void longPressAction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),
                        "duration", 2000));
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }

    public void scrollToEnd() {
        // Scroll to end
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100,
                "top", 100,
                "width", 200,
                "height", 200,
                "direction", "down",
                "percent", 3.0
        ));
    }

    public void swipeAction(WebElement element, String direction) {
        //Swipe logic
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public void dragAction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 530,
                "endY", 660
        ));
    }

    public void setActivity(String activityName) {
        Activity activity = new Activity("io.appium.android.apis", activityName);
        driver.startActivity(activity);
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
}
