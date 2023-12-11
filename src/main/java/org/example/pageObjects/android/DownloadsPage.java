package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DownloadsPage extends BasePage {

    public DownloadsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Downloads']")
    private WebElement downloadsPageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Find by name']")
    private WebElement searchBar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More options']")
    private WebElement moreOptionsMenu;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='No songs are currently downloaded to this device.']")
    private WebElement noDownloadsIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No songs are currently downloaded to this device.']")
    private WebElement noDownloadsMainText;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(text(), 'MB Downloaded')]")
    private WebElement downloadedSize;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Downloaded']")
    private WebElement downloadedCheck;

    public String getDownloadsPageTitle() {
        return getAnyElement(downloadsPageTitle).getText();
    }

    public WebElement getSearchBar() {
        return getAnyElement(searchBar);
    }

    public WebElement getMoreOptionsMenu() {
        return getAnyElement(moreOptionsMenu);
    }

    public WebElement getNoDownloadsIcon() {
        return getAnyElement(noDownloadsIcon);
    }

    public WebElement getNoDownloadsMainText() {
        return getAnyElement(noDownloadsMainText);
    }

    public boolean isDownloadsEmpty() {
        return getNoDownloadsIcon().isDisplayed();
    }

    public WebElement findDownloadedSongByName(String songName) {
        return getAnyElementByText(songName);
    }

    public boolean isSongDownloaded(String songName) {
        return findDownloadedSongByName(songName).isDisplayed();
    }

    public void clickMoreOptionBySongName(String songName) {
        clickOnElement(By.xpath("//android.widget.Button[contains(@content-desc, '"+ songName +"')]"));
    }

    public void deleteDownloadedSong(String songName) {
        clickMoreOptionBySongName(songName);
        clickOnElement(getAnyElementByText("Remove Download"));
        clickOnElement(getAnyElementByText("Ok"));
    }

    public void leaveDownloadedSong(String songName) {
        clickMoreOptionBySongName(songName);
        clickOnElement(getAnyElementByText("Remove Download"));
        clickOnElement(getAnyElementByText("Cancel"));
    }

    public SongDetailsPage viewSongDetails(String songName) {
        clickOnElement(By.xpath("//android.widget.TextView[@text='"+ songName +"']/following-sibling::android.widget.Button[@content-desc='More options']"));
        clickOnElement(getAnyElementByText("View Song Details"));
        return new SongDetailsPage(driver);
    }

    public boolean isOptionDisplayedInMoreOptions(String optionText) {
        return getAnyElementByText(optionText).isDisplayed();
    }
}
