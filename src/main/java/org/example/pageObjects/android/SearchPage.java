package org.example.pageObjects.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.util.List;

public class SearchPage extends AndroidActions {

    AndroidDriver driver;

    public SearchPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement songSearchBar;

    @AndroidFindBy(id = "//android.widget.EditText")
    private List<WebElement> songSearchResults;

    @AndroidFindBy(accessibility = "Back")
    private WebElement backButton;

    public void searchSongByName(String songName) {
        songSearchBar.sendKeys(songName);
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

    }

    public WebElement getSongFromResults(String songName) {
        return driver.findElements(By.xpath("//android.widget.TextView[@text='"+songName+"']")).get(0);
    }

    public void clickBackButton() {
        backButton.click();
    }

}
