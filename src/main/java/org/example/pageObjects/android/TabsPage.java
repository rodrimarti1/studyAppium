package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class TabsPage extends AndroidActions {

    AndroidDriver driver;

    public TabsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Library']")
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
        libraryButton.click();
        return new LibraryPage(driver);
    }

    public TopicsPage goToTopicsPage() {
        topicsButton.click();
        return new TopicsPage(driver);
    }

    public PeoplePage goToDownloadsPage() {
        downloadsButton.click();
        return new PeoplePage(driver);
    }

    public PlaylistsPage goToPlaylistsPage() {
        playlistsButton.click();
        return new PlaylistsPage(driver);
    }

    public WebElement getOptionByText(String text) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
    }
    public WebElement getLibraryButton() {
        return libraryButton;
    }

    public WebElement getTopicsButton() {
        return topicsButton;
    }

    public WebElement getDownloadsButton() {
        return downloadsButton;
    }

    public WebElement getPlaylistButton() {
        return playlistsButton;
    }
}
