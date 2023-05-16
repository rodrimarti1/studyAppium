package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class PlaylistsContentPage extends AndroidActions {

    AndroidDriver driver;

    public PlaylistsContentPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='No Songs']")
    private WebElement noSongsIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No Songs']")
    private WebElement noSongsMainText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add songs to this playlist from the menu on any song.']")
    private WebElement noSongsSubText;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add a Song']")
    private WebElement addSongToPlaylistButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More options']")
    private WebElement playlistsEllipseMenu;

    public WebElement getPlaylistsEllipseMenu() {
        return getAnyElement(playlistsEllipseMenu);
    }

    public WebElement getNoSongsIcon() {
        return getAnyElement(noSongsIcon);
    }

    public WebElement getNoSongsMainText() {
        return getAnyElement(noSongsMainText);
    }

    public WebElement getNoSongsSubText() {
        return getAnyElement(noSongsSubText);
    }

    public PlaylistsPage deletePlaylistByName(String playlistName) {
        clickOnElement(playlistsEllipseMenu);
        clickOnElement(getAnyElementByText(playlistName));
        return new PlaylistsPage(driver);
    }

    public WebElement validatePlaylistName(String playlistName) {
        return getAnyElementByText(playlistName);
    }

    public WebElement getPlaylistContentByName(String songName) {
        return getAnyElementByText(songName);
    }

    public WebElement getEllipseOptionByText(String optionName) {
        return getAnyElementByText(optionName);
    }
}
