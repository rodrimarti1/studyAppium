package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
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
    private WebElement moreOptionsMenu;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Audio Track']")
    private WebElement miniPlayer;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Previous song']")
    private WebElement miniPlayerPreviousButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaPlayPauseButton")
    private WebElement miniPlayerPlayPauseButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Next song']")
    private WebElement miniPlayerNextButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/currentTimeTextView")
    private WebElement miniPlayerCurrentTime;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaProgressSeekBar")
    private WebElement miniPlayerProgressBar;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaDurationTextView")
    private WebElement miniPlayerDuration;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private WebElement miniPlayerMoreOptionsButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@id='org.lds.ldsmusic.alpha:id/mediaPlaybackToolbar']/android.widget.ImageButton")
    private WebElement miniPlayerCloseButton;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id='org.lds.ldsmusic.alpha:id/mediaPlaybackToolbar']/android.widget.TextView)[1]")
    private WebElement miniPlayerSongName;

    public WebElement getMoreOptionsMenu() {
        return getAnyElement(moreOptionsMenu);
    }

    public WebElement getMiniPlayer() {
        return getAnyElement(miniPlayer);
    }

    public WebElement getMiniPlayerPreviousButton() {
        return getAnyElement(miniPlayerPreviousButton);
    }

    public WebElement getMiniPlayerPlayPauseButton() {
        return getAnyElement(miniPlayerPlayPauseButton);
    }

    public WebElement getMiniPlayerNextButton() {
        return getAnyElement(miniPlayerNextButton);
    }

    public WebElement getMiniPlayerCurrentTime() {
        return getAnyElement(miniPlayerCurrentTime);
    }

    public WebElement getMiniPlayerProgressBar() {
        return getAnyElement(miniPlayerProgressBar);
    }

    public WebElement getMiniPlayerDuration() {
        return getAnyElement(miniPlayerDuration);
    }

    public WebElement getMiniPlayerMoreOptionsButton() {
        return getAnyElement(miniPlayerMoreOptionsButton);
    }

    public WebElement getMiniPlayerCloseButton() {
        return getAnyElement(miniPlayerCloseButton);
    }

    public WebElement getMiniPlayerSongName() {
        return getAnyElement(miniPlayerSongName);
    }

    public void selectPlaylistByName(String playlistName) {
        clickOnElement(getAnyElementByText(playlistName));
    }

    public WebElement getConfirmationToast(String confirmationText) {
        return driver.findElement(By.xpath("//android.widget.Toast[@text='"+ confirmationText +"']"));
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return getAnyElementByText(optionName);
    }
}
