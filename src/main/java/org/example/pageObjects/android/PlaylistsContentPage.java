package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlaylistsContentPage extends BasePage {

    public PlaylistsContentPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='No Songs']")
    private WebElement noSongsIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No Songs']")
    private WebElement noSongsMainText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No songs have been added to this playlist. Tap the button below to add songs.']")
    private WebElement noSongsSubText;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add a Song']")
    private WebElement addSongToPlaylistButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More options']")
    private WebElement playlistsEllipseMenu;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='More options']")
    private WebElement songMoreOptionsMenu;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Play']")
    private WebElement playlistPlayButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Shuffle']")
    private WebElement playlistShuffleButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Audio Track']/following-sibling::android.widget.TextView)[2]")
    private WebElement miniPlayer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']/following-sibling::android.widget.Button")
    private WebElement confirmDeletionButton;

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
        clickOnElement(confirmDeletionButton);
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

    public void clickPlayButton() {
        clickOnElement(playlistPlayButton);
    }

    public void clickShuffleButton() {
        clickOnElement(playlistShuffleButton);
    }

    public PlaylistContentSearchPage clickAddASong() {
        clickOnElement(getAnyElement(addSongToPlaylistButton));
        return new PlaylistContentSearchPage(driver);
    }

    public void clickSongMoreOptionsMenu() {
        clickOnElement(getAnyElement(By.xpath("(//android.widget.Button[contains(@content-desc, 'More option')])[1]")));
    }

    public PlaylistsContentPage clickOnOptionByName(String optionName) {
        clickOnElement(getAnyElementByText(optionName));
        return new PlaylistsContentPage(driver);
    }

    public boolean isPlaylistEmpty() {
        boolean isEmpty = false;
        if(getNoSongsSubText().isDisplayed()) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public boolean isMiniPlayerDisplayed() {
        boolean isDisplayed = false;
        if (miniPlayer.isDisplayed()) {
            isDisplayed = true;
        }
        return isDisplayed;
    }

    public String getMiniPlayerSongName(String songName) {
        WebElement currentSong = getAnyElement(By.xpath("//android.view.View[@content-desc='Audio Track']/following-sibling::android.widget.TextView[@text='"+songName+"']"));
        return currentSong.getText();
    }
}
