package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SongDetailsPage extends BasePage {

    public SongDetailsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More options']")
    private WebElement moreOptionsMenu;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Audio Track']")
    private WebElement miniPlayerEnglish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Pista de audio']")
    private WebElement miniPlayerSpanish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Faixa de áudio']")
    private WebElement miniPlayerPortuguese;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Piste audio']")
    private WebElement miniPlayerFrench;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Previous song']")
    private WebElement miniPlayerPreviousButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/mediaPlayPauseButton")
    private WebElement miniPlayerPlayPauseButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Next song']/following-sibling::android.widget.Button")
    private WebElement miniPlayerNextButtonEnglish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Siguiente canción']/following-sibling::android.widget.Button")
    private WebElement miniPlayerNextButtonSpanish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Titre suivant']/following-sibling::android.widget.Button")
    private WebElement miniPlayerNextButtonFrench;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Próxima música']/following-sibling::android.widget.Button")
    private WebElement miniPlayerNextButtonPortuguese;

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

    @AndroidFindBy(accessibility = "Play")
    private WebElement mainPlayButtonEnglish;

    @AndroidFindBy(accessibility = "Reproducir")
    private WebElement mainPlayButtonSpanish;

    @AndroidFindBy(accessibility = "Lecture")
    private WebElement mainPlayButtonFrench;

    @AndroidFindBy(accessibility = "Reproduzir")
    private WebElement mainPlayButtonPortuguese;

    @AndroidFindBy(accessibility = "Back")
    private WebElement backButton;

    public WebElement getBackButton() {
        return getAnyElement(backButton);
    }

    public CollectionDetailsPage clickBackButton() {
        clickOnElement(getBackButton());
        return new CollectionDetailsPage(driver);
    }

    public WebElement getMainPlayButton(String languageName) {
        return switch (languageName) {
            case "Spanish" -> getAnyElement(mainPlayButtonSpanish);
            case "French" -> getAnyElement(mainPlayButtonFrench);
            case "Portuguese" -> getAnyElement(mainPlayButtonPortuguese);
            default -> getAnyElement(mainPlayButtonEnglish);
        };
    }

    public WebElement getMoreOptionsMenu() {
        return getAnyElement(moreOptionsMenu);
    }

    public WebElement getMiniPlayer(String languageName) {
        return switch (languageName) {
            case "Spanish" -> getAnyElement(miniPlayerSpanish);
            case "Portuguese" -> getAnyElement(miniPlayerPortuguese);
            case "French" -> getAnyElement(miniPlayerFrench);
            default -> getAnyElement(miniPlayerEnglish);
        };
    }

    public WebElement getMiniPlayerPreviousButton() {
        return getAnyElement(miniPlayerPreviousButton);
    }

    public WebElement getMiniPlayerPlayPauseButton() {
        return getAnyElement(miniPlayerPlayPauseButton);
    }

    public WebElement getMiniPlayerNextButton(String languageName) {
        return switch (languageName) {
            case "English" -> getAnyElement(miniPlayerNextButtonEnglish);
            case "Spanish" -> getAnyElement(miniPlayerNextButtonSpanish);
            case "French" -> getAnyElement(miniPlayerNextButtonFrench);
            case "Portuguese" -> getAnyElement(miniPlayerNextButtonPortuguese);
            default -> null;
        };
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

    public void confirmAddToPlaylist() {
        clickOnElement(getAnyElementByText("Add"));
    }

    public PlaylistsContentPage viewPlaylist() {
        clickOnElement(getAnyElementByText("View Playlist"));
        return new PlaylistsContentPage(driver);
    }

    public WebElement getConfirmationToast(String confirmationText) {
        return driver.findElement(By.xpath("//android.widget.Toast[@text='"+ confirmationText +"']"));
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return getAnyElementByText(optionName);
    }

    public PlaylistsPage selectAudioType(String audioType) {
        clickOnElement(getAnyElementByText(audioType));
        return new PlaylistsPage(driver);
    }

    public WebElement getSelectedSongViewByText(String songViewName) {
        return getAnyElementByText(songViewName);
    }
}
