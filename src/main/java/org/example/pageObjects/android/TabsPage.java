package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TabsPage extends BasePage {

    public TabsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Library']")
    private WebElement libraryButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Topics']")
    private WebElement topicsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Downloads']")
    private WebElement downloadsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Playlists']")
    private WebElement playlistsButton;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/bottomNavBar")
    private WebElement navBar;

    public WebElement getNavBar() {
        return navBar;
    }

    public LibraryPage goToLibraryPage() {
        clickOnElement(libraryButton);
        return new LibraryPage(driver);
    }

    public TopicsPage goToTopicsPage() {
        clickOnElement(topicsButton);
        return new TopicsPage(driver);
    }

    public PeoplePage goToDownloadsPage() {
        clickOnElement(downloadsButton);
        return new PeoplePage(driver);
    }

    public PlaylistsPage goToPlaylistsPage() {
        clickOnElement(playlistsButton);
        return new PlaylistsPage(driver);
    }

    public WebElement getOptionByText(String text) {
        return getAnyElementByText(text);
    }
    public WebElement getLibraryButton() {
        return getAnyElement(libraryButton);
    }

    public WebElement getTopicsButton() {
        return getAnyElement(topicsButton);
    }

    public WebElement getDownloadsButton() {
        return getAnyElement(downloadsButton);
    }

    public WebElement getPlaylistButton() {
        return getAnyElement(playlistsButton);
    }
}
