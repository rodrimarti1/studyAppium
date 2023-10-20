package org.example.pageObjects.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LibraryPage extends BasePage {

    public LibraryPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Library']")
    private WebElement libraryBtn;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Library']")
    private WebElement libraryTitleEnglish;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Biblioteca']")
    private WebElement libraryTitleSpanish;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Biblioteca']")
    private WebElement libraryTitlePortuguese;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Bibliothèque']")
    private WebElement libraryTitleFrench;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='More options']")
    private WebElement moreOptionsMenuEnglish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Más opciones']")
    private WebElement moreOptionsMenuSpanish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Autres options']")
    private WebElement moreOptionsMenuFrench;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Mais opções']")
    private WebElement moreOptionsMenuPortuguese;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']")
    private WebElement searchButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Language']")
    private WebElement languagesMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private WebElement settingsMenu;

    @AndroidFindBy(id = "org.lds.ldsmusic.alpha:id/bottomNavBar")
    private WebElement navBar;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='org.lds.ldsmusic.alpha:id/mainNavHostFragment']")
    private WebElement mainFrame;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='Library']")
    private WebElement libraryButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Topics']")
    private WebElement topicsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='People']")
    private WebElement peopleButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Playlists']")
    private WebElement playlistsButtonEnglish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Listas de reproducción']")
    private WebElement playlistsButtonSpanish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Listes de lecture']")
    private WebElement playlistsButtonFrench;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Listas de reprodução']")
    private WebElement playlistsButtonPortuguese;

    public String getLibraryPageTitle(String languageName) {
        return switch (languageName) {
            case "English" -> libraryTitleEnglish.getText();
            case "Spanish" -> libraryTitleSpanish.getText();
            case "Portuguese" -> libraryTitlePortuguese.getText();
            case "French" -> libraryTitleFrench.getText();
            default -> null;
        };
    }

    public WebElement getMoreOptionsMenu(String languageName) {
        return switch (languageName) {
            case "English" -> moreOptionsMenuEnglish;
            case "Spanish" -> moreOptionsMenuSpanish;
            case "Portuguese" -> moreOptionsMenuPortuguese;
            case "French" -> moreOptionsMenuFrench;
            default -> null;
        };
    }

    public WebElement getNavbar() {
        return navBar;
    }

    public WebElement getMainFrame() {
        return mainFrame;
    }

    public void clickLibraryButton() {
        clickOnElement(libraryBtn);
    }

    public SearchPage goToSearchPage() {
        clickOnElement(searchButton);
        return new SearchPage(driver);
    }

    public LanguagesPage goToLanguagePage() {
        clickOnElement(moreOptionsMenuEnglish);
        clickOnElement(languagesMenu);
        return new LanguagesPage(driver);
    }

    public SettingsPage goToSettingsPage() {
        clickOnElement(moreOptionsMenuEnglish);
        clickOnElement(settingsMenu);
        return new SettingsPage(driver);
    }

    public LibraryPage goToLibraryPage() {
        clickOnElement(libraryButton);
        return new LibraryPage(driver);
    }

    public TopicsPage goToTopicsPage() {
        clickOnElement(topicsButton);
        return new TopicsPage(driver);
    }

    public PeoplePage goToPeoplePage() {
        clickOnElement(peopleButton);
        return new PeoplePage(driver);
    }

    public PlaylistsPage goToPlaylistsPage(String languageName) {
        switch (languageName) {
            case "Spanish" -> clickOnElement(playlistsButtonSpanish);
            case "French" -> clickOnElement(playlistsButtonFrench);
            case "Portuguese" -> clickOnElement(playlistsButtonPortuguese);
            default -> clickOnElement(playlistsButtonEnglish);
        }
        return new PlaylistsPage(driver);
    }

    public CollectionDetailsPage goToCollectionPage(String collectionName) {
        clickOnElement(getAnyElementByText(collectionName));
        return new CollectionDetailsPage(driver);
    }

    public WebElement findAlbumByText(String albumName) {
        return getAnyElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.TextView[@text='"+ albumName +"']"));
    }

    public WebElement findAlbumByIndex(int index) {
        return driver.findElements(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View")).get(index);
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return getAnyElementByText(optionName);
    }



}
