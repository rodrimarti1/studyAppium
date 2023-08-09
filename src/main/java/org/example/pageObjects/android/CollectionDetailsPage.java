package org.example.pageObjects.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class CollectionDetailsPage extends BasePage {

    public CollectionDetailsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Sort Icon']")
    private WebElement sortIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']")
    private WebElement searchIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Play']")
    private WebElement songListPlayButton;

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

    public WebElement getSongListPlayButton() {
        return getAnyElement(songListPlayButton);
    }

    public void selectAudioType(String audioType) {
        clickOnElement(audioTypeFilter);
        clickOnElement(By.xpath("//android.widget.TextView[@text='"+audioType+"']"));
    }

    public void maximizeMusicPlayer() {
        WebElement miniMusicPlayer = getAnyElement(By.xpath("//android.view.View[@content-desc='Stop']/parent::android.view.View/parent::android.view.View/parent::android.view.View"));

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) miniMusicPlayer).getId(),
                "direction", "up",
                "percent", 1.0
        ));
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
