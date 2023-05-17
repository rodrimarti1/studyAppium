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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add playlists to organize songs.']")
    private WebElement noPlaylistsSubText;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add to Playlist']")
    private WebElement newPlaylistButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='More options']")
    private WebElement playlistsEllipseMenu;

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
}
