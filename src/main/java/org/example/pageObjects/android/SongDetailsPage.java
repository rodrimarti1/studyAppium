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

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaFab")
    WebElement headphonesButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaControlsLayout")
    WebElement miniPlayer;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaPreviousButton")
    WebElement miniPlayerPreviousButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaPlayPauseButton")
    WebElement miniPlayerPauseButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaNextButton")
    WebElement miniPlayerNextButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/currentTimeTextView")
    WebElement miniPlayerCurrentTime;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaProgressSeekBar")
    WebElement miniPlayerProgressBar;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaDurationTextView")
    WebElement miniPlayerDuration;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='More options'])[2]")
    WebElement miniPlayerMoreOptionsButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@id='org.lds.ldsmusic.alpha:id/mediaPlaybackToolbar']/android.widget.ImageButton")
    WebElement miniPlayerCloseButton;

    public WebElement getHeadphonesButton() {
        return headphonesButton;
    }

    public WebElement getMiniPlayer() {
        return miniPlayer;
    }

    public WebElement getMiniPlayerPreviousButton() {
        return miniPlayerPreviousButton;
    }

    public WebElement getMiniPlayerPauseButton() {
        return miniPlayerPauseButton;
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

}
