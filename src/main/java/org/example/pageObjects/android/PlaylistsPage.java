package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class PlaylistsPage extends AndroidActions {

    AndroidDriver driver;

    public PlaylistsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
        return playlistsPageTitle;
    }

    public WebElement getNoPlaylistsIcon() {
        return noPlaylistsIcon;
    }

    public WebElement getNoPlaylistsMainText() {
        return noPlaylistsMainText;
    }

    public WebElement getNoPlaylistsSubText() {
        return noPlaylistsSubText;
    }

    public WebElement getNewPlaylistButton() {
        return newPlaylistButton;
    }

    public WebElement getPlaylistsEllipseMenu() {
        return playlistsEllipseMenu;
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return getAnyElementByText(optionName);
    }

    public WebElement getPlaylistByName(String playlistName) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+playlistName+"']"));
    }

     public PlaylistsDetailsPage goToPlaylistsDetailsPage() {
        newPlaylistButton.click();
        return new PlaylistsDetailsPage(driver);
     }

     public PlaylistsDetailsPage createNewPlaylist() {
        newPlaylistButton.click();
        return new PlaylistsDetailsPage(driver);
     }
}
