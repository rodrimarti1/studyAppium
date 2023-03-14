package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People']")
    private WebElement peopleButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Playlists']")
    private WebElement playlistsButton;

    public LibraryPage goToLibraryPage() {
        libraryButton.click();
        return new LibraryPage(driver);
    }

    public TopicsPage goToTopicsPage() {
        topicsButton.click();
        return new TopicsPage(driver);
    }

    public PeoplePage goToPeoplePage() {
        peopleButton.click();
        return new PeoplePage(driver);
    }

    public PlaylistsPage goToPlaylistsPage() {
        playlistsButton.click();
        return new PlaylistsPage(driver);
    }
}
