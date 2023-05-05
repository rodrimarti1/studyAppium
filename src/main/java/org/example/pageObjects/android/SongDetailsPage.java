package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class SongDetailsPage extends AndroidActions {

    AndroidDriver driver;

    public SongDetailsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More options']")
    WebElement moreOptionsMenu;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Audio Track']")
    WebElement miniPlayer;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Previous song']")
    WebElement miniPlayerPreviousButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaPlayPauseButton")
    WebElement miniPlayerPlayPauseButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Next song']")
    WebElement miniPlayerNextButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/currentTimeTextView")
    WebElement miniPlayerCurrentTime;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaProgressSeekBar")
    WebElement miniPlayerProgressBar;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaDurationTextView")
    WebElement miniPlayerDuration;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    WebElement miniPlayerMoreOptionsButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@id='org.lds.ldsmusic.alpha:id/mediaPlaybackToolbar']/android.widget.ImageButton")
    WebElement miniPlayerCloseButton;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='org.lds.ldsmusic.alpha:id/mediaPlaybackToolbar']/android.widget.TextView)[1]")
    WebElement miniPlayerSongName;

    public WebElement getMoreOptionsMenu() {
        return moreOptionsMenu;
    }

    public WebElement getMiniPlayer() {
        return miniPlayer;
    }

    public WebElement getMiniPlayerPreviousButton() {
        return miniPlayerPreviousButton;
    }

    public WebElement getMiniPlayerPlayPauseButton() {
        return miniPlayerPlayPauseButton;
    }

    public WebElement getMiniPlayerNextButton() {
        return miniPlayerNextButton;
    }

    public WebElement getMiniPlayerCurrentTime() {
        return miniPlayerCurrentTime;
    }

    public WebElement getMiniPlayerProgressBar() {
        return miniPlayerProgressBar;
    }

    public WebElement getMiniPlayerDuration() {
        return miniPlayerDuration;
    }

    public WebElement getMiniPlayerMoreOptionsButton() {
        return miniPlayerMoreOptionsButton;
    }

    public WebElement getMiniPlayerCloseButton() {
        return miniPlayerCloseButton;
    }

    public WebElement getMiniPlayerSongName() {
        return miniPlayerSongName;
    }

}
