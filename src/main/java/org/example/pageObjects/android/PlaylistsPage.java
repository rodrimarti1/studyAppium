package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PlaylistsPage extends BasePage {

    public PlaylistsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Playlists']")
    private WebElement playlistsBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Playlists']")
    private WebElement playlistsPageTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='No Playlists']")
    private WebElement noPlaylistsIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No Playlists']")
    private WebElement noPlaylistsMainText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tap the button below to create one.']")
    private WebElement noPlaylistsSubText;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add to Playlist']")
    private WebElement newPlaylistButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='More options']")
    private WebElement playlistsEllipseMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='View Playlist']")
    private WebElement viewPlaylistButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Done']")
    private WebElement doneButton;

    public WebElement getPlaylistsPageTitle() {
        return getAnyElement(playlistsPageTitle);
    }

    public WebElement getNoPlaylistsIcon() {
        return getAnyElement(noPlaylistsIcon);
    }

    public WebElement getNoPlaylistsMainText() {
        return getAnyElement(noPlaylistsMainText);
    }

    public WebElement getNoPlaylistsSubText() {
        return getAnyElement(noPlaylistsSubText);
    }

    public WebElement getNewPlaylistButton() {
        return getAnyElement(newPlaylistButton);
    }

    public WebElement getPlaylistsEllipseMenu() {
        return getAnyElement(playlistsEllipseMenu);
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return getAnyElementByText(optionName);
    }

    public WebElement getPlaylistByName(String playlistName) {
        return getAnyElementByText(playlistName);
    }

    public WebElement getViewPlaylistButton() {
        return getAnyElement(viewPlaylistButton);
    }

    public PlaylistsContentPage clickViewPlaylistButton() {
        clickOnElement(getViewPlaylistButton());
        return new PlaylistsContentPage(driver);
    }

    public WebElement getDoneButton() {
        return getAnyElement(doneButton);
    }

    public PlaylistsPage clickDoneButton() {
        clickOnElement(getDoneButton());
        return new PlaylistsPage(driver);
    }

     public PlaylistsDetailsPage goToPlaylistsDetailsPage() {
        clickOnElement(newPlaylistButton);
        return new PlaylistsDetailsPage(driver);
     }

     public PlaylistsDetailsPage createNewPlaylist() {
        clickOnElement(newPlaylistButton);
        return new PlaylistsDetailsPage(driver);
     }

     public PlaylistsContentPage goToPlaylistContentPage(String playlistName) {
        clickOnElement(getPlaylistByName(playlistName));
        return new PlaylistsContentPage(driver);
     }

     public PlaylistsPage selectExistingPlaylist(String playlistName) {
        clickOnElement(getPlaylistByName(playlistName));
        return new PlaylistsPage(driver);
     }

     public void confirmAddToPlaylist() {
        clickOnElement(getAnyElementByText("Add"));
     }

     public PlaylistsPage viewPlaylistOrDismissPopup(String action) {
        clickOnElement(getAnyElementByText(action));
        return new PlaylistsPage(driver);
     }
}
