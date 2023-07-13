package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopicsDetailsPage extends BasePage {

    public TopicsDetailsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More options']")
    private WebElement moreOptionsTopBar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']")
    private WebElement searchIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Audio Types']")
    private WebElement audioTypeFilter;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Features']")
    private WebElement featuresFilter;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Topics']")
    private WebElement topicsFilter;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Play']")
    private WebElement mainPlayButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Shuffle']")
    private WebElement shuffleButton;

    public WebElement getMoreOptionsTopBar() {
        return moreOptionsTopBar;
    }

    public String getTopicNameTitle(String topicName) {
        return getAnyElementByText(topicName).getText();
    }

    public WebElement getSearchIcon() {
        return getAnyElement(searchIcon);
    }

    public WebElement getAudioTypeFilter() {
        return getAnyElement(audioTypeFilter);
    }

    public void selectAudioType(String audioType) {
        clickOnElement(audioTypeFilter);
        clickOnElement(By.xpath("//android.widget.TextView[@text='"+ audioType +"']"));
    }

    public WebElement getFeaturesFilter() {
        return getAnyElement(featuresFilter);
    }

    public void selectFeature(String featureName) {
        clickOnElement(featuresFilter);
        clickOnElement(By.xpath("//android.widget.TextView[@text='"+ featureName +"']"));
    }

    public WebElement getTopicsFilter() {
        return getAnyElement(topicsFilter);
    }

    public void selectTopic(String topicName) {
        clickOnElement(topicsFilter);
        clickOnElement(By.xpath("//android.widget.TextView[@text='"+ topicName +"']"));
    }

    public void clickMainPlayButton() {
        clickOnElement(mainPlayButton);
    }

    public void clickShuffleButton() {
        clickOnElement(shuffleButton);
    }

    public void clickMoreOptionBySongName(String songName) {
        clickOnElement(By.xpath("//android.widget.TextView[@text='"+ songName +"']/following-sibling::android.widget.Button[@content-desc='More options']"));
    }

    public void performActionOnSpecificSong(String songName, String actionName, String audioType) {
        clickMoreOptionBySongName(songName);
        clickOnElement(getAnyElementByText(actionName));
        clickOnElement(getAnyElementByText(audioType));
    }

    public PlaylistsPage addSongToPlaylist(String songName, String audioType) {
        performActionOnSpecificSong(songName, "Add to Playlist", audioType);
        return new PlaylistsPage(driver);
    }

    public WebElement findDownloadedSongByName(String songName) {
        return getAnyElement(By.xpath("//android.widget.TextView[@text='"+ songName +"']/following-sibling::android.view.View[@content-desc='Downloaded']"));
    }

    public boolean isSongDownloaded(String songName) {
        return findDownloadedSongByName(songName).isDisplayed();
    }

}
