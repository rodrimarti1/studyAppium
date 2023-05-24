package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Audio Type']")
    private WebElement audioTypeFilter;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Features']")
    private WebElement featuresFilter;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Topics']")
    private WebElement topicsFilter;

    public SongDetailsPage goToSongDetailsPage(String songName) {
        //TODO Remove the following line when LMFA-518 is fixed
        selectAudioType("Words and Music");
        clickOnElement(getAnyElementByText(songName));
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
        WebElement miniMusicPlayer = getAnyElement(By.xpath("(//android.view.View[@content-desc='Audio Track']/following-sibling::android.widget.TextView)[2]"));
        clickOnElement(miniMusicPlayer);
    }
}
