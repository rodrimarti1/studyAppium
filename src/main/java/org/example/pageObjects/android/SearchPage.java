package org.example.pageObjects.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    private WebElement searchTitle;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement songSearchBar;

    @AndroidFindBy(accessibility = "Back")
    private WebElement backButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Clear']")
    private WebElement clearButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='No search results found.']")
    private WebElement searchEmptyState;

    public String getSearchPageTitle() {
        return searchTitle.getText();
    }

    public void setSearchBar(String searchCriteria) {
        songSearchBar.sendKeys(searchCriteria);
    }

    public WebElement getSearchBar() {
        return  songSearchBar;
    }

    public void searchSongByName(String songName) throws InterruptedException {
        songSearchBar.sendKeys(songName);
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
        Thread.sleep(2000);
    }

    public List<WebElement> getSongFromSearchResults(String songName) {
        return driver.findElements(By.xpath("//*[contains(@text, '"+songName+"')]"));
    }

    public WebElement getBackButton() {
        return getAnyElement(backButton);
    }

    public WebElement getClearButton() {
        return getAnyElement(clearButton);
    }

    public WebElement getSearchEmptyState() {
        return getAnyElement(searchEmptyState);
    }

}
