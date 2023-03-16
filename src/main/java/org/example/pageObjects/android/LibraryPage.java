package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;


public class LibraryPage extends AndroidActions {

    AndroidDriver driver;

    public LibraryPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Library']")
    private WebElement libraryBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='org.lds.ldsmusic.alpha:id/mainToolbar']/android.widget.TextView")
    private WebElement libraryTitle;

    @AndroidFindBy(accessibility = "More options")
    private WebElement moreOptionsMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Languages']")
    private WebElement languagesMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    private WebElement searchMenu;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/bottomNavBar")
    private WebElement navBar;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='org.lds.ldsmusic.alpha:id/mainNavHostFragment']")
    private WebElement mainFrame;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Library']")
    private WebElement libraryButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Topics']")
    private WebElement topicsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People']")
    private WebElement peopleButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Playlists']")
    private WebElement playlistsButton;

    public String getLibraryPageTitle() {
        return libraryTitle.getText();
    }

    public WebElement getMoreOptionsMenu() {
        return moreOptionsMenu;
    }

    public WebElement getNavbar() {
        return navBar;
    }

    public WebElement getMainFrame() {
        return mainFrame;
    }

    public void clickLibraryButton() {
        libraryBtn.click();
    }

    public SearchPage goToSearchPage() {
        moreOptionsMenu.click();
        searchMenu.click();
        return new SearchPage(driver);
    }

    public LanguagesPage goToLanguagePage() {
        moreOptionsMenu.click();
        languagesMenu.click();
        return new LanguagesPage(driver);
    }

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

    public WebElement findAlbumByText(String albumName) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+albumName+"']"));
    }

    public WebElement findAlbumByIndex(int index) {
        return driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View")).get(index);
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+optionName+"']"));
    }


}
