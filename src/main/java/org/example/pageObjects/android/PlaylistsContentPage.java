package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
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
    WebElement noSongsIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No Songs']")
    private WebElement noSongsMainText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add songs to this playlist from the menu on any song.']")
    private WebElement noSongsSubText;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add a Song']")
    WebElement addSongToPlaylistButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='More options']")
    WebElement playlistsEllipseMenu;

    public WebElement getPlaylistsEllipseMenu() {
        return playlistsEllipseMenu;
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return getAnyElementByText(optionName);
    }

    public WebElement validatePlaylistName(String playlistName) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+playlistName+"']"));
    }

    public WebElement validateNumberOfSongsInPlaylist(int numberOfSongs) {
        String actualText = Integer.toString(numberOfSongs) + " songs";
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+actualText+"']"));
    }
}
