package org.example.pageObjects.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class CollectionDetailsPage extends BasePage {

    public CollectionDetailsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Sort Icon']")
    private WebElement sortIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']")
    private WebElement searchIcon;

    @AndroidFindBy(accessibility = "Play")
    private WebElement songListPlayButtonEnglish;

    @AndroidFindBy(accessibility = "Reproducir")
    private WebElement songListPlayButtonSpanish;

    @AndroidFindBy(accessibility = "Lecture")
    private WebElement songListPlayButtonFrench;

    @AndroidFindBy(accessibility = "Reproduzir")
    private WebElement songListPlayButtonPortuguese;

    @AndroidFindBy(accessibility = "Shuffle")
    private WebElement shuffleButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Audio Types']")
    private WebElement audioTypeFilter;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Features']")
    private WebElement featuresFilter;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Topics']")
    private WebElement topicsFilter;

    public SongDetailsPage goToSongDetailsPage(String songName) {
        clickOnElement(getAnyElement(By.xpath("//android.widget.TextView[contains(@text, '"+ songName +"')]")));
        return new SongDetailsPage(driver);
    }

    public WebElement getSongListPlayButton(String languageName) {
        return switch (languageName) {
            case "Spanish" -> getAnyElement(songListPlayButtonSpanish);
            case "French" -> getAnyElement(songListPlayButtonFrench);
            case "Portuguese" -> getAnyElement(songListPlayButtonPortuguese);
            default -> getAnyElement(songListPlayButtonEnglish);
        };
    }

    public WebElement getSongListShuffleButton() {
        return getAnyElement(shuffleButton);
    }

    public void selectAudioType(String audioType) {
        clickOnElement(audioTypeFilter);
        clickOnElement(By.xpath("//android.widget.TextView[@text='"+audioType+"']"));
    }

    public void maximizeMusicPlayer(String languageName) {
        WebElement miniMusicPlayer = null;

        miniMusicPlayer = switch (languageName) {
            case "English", "French" -> getAnyElement(By.xpath("//android.view.View[@content-desc='Stop']/parent::android.view.View/parent::android.view.View/parent::android.view.View"));
            case "Spanish", "Portuguese" -> getAnyElement(By.xpath("//android.view.View[@content-desc='Parar']/parent::android.view.View/parent::android.view.View/parent::android.view.View"));
            default -> null;
        };
        swipeAction(miniMusicPlayer, "up");
    }

    public void downloadSong(String songName, String audioType) {
        //selectAudioType("Words and Music");
        clickOnElement(By.xpath("//android.widget.TextView[contains(@text, '"+ songName +"')]/following-sibling::android.widget.Button[@content-desc='More options']"));
        clickOnElement(getAnyElementByText("Download"));
        clickOnElement(getAnyElementByText(audioType));
    }

    public boolean isSongDownloaded(String songName) {
        return getAnyElement(By.xpath("//android.widget.TextView[contains(@text, '"+ songName +"')]/following-sibling::android.view.View[@content-desc='Downloaded']")).isDisplayed();
    }
}
