package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PlaylistsDetailsPage extends BasePage {

    public PlaylistsDetailsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='New Playlist']")
    private WebElement newPlaylistPageTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Title']/ancestor::android.widget.EditText")
    private WebElement playlistNameEnglish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Title']/ancestor::android.widget.EditText")
    private WebElement playlistNameSpanish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Titre']/ancestor::android.widget.EditText")
    private WebElement playlistNameFrench;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Título']/ancestor::android.widget.EditText")
    private WebElement playlistNamePortuguese;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Description']/ancestor::android.widget.EditText")
    private WebElement playlistDescriptionEnglish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Description']/ancestor::android.widget.EditText")
    private WebElement playlistDescriptionSpanish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Description']/ancestor::android.widget.EditText")
    private WebElement playlistDescriptionFrench;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Description']/ancestor::android.widget.EditText")
    private WebElement playlistDescriptionPortuguese;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Back']")
    private WebElement playlistBackButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
    private WebElement playlistSaveButtonEnglish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Guardar']")
    private WebElement playlistSaveButtonSpanish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enregistrer']")
    private WebElement playlistSaveButtonFrench;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Salvar']")
    private WebElement playlistSaveButtonPortuguese;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='More options']")
    private WebElement playlistsEllipseMenu;

    public WebElement getNewPlaylistPageTitle() {
        return getAnyElement(newPlaylistPageTitle);
    }

    public WebElement getPlaylistName() {
        return getAnyElement(playlistNameEnglish);
    }

    public WebElement getPlaylistDescription() {
        return getAnyElement(playlistDescriptionEnglish);
    }

    public WebElement getPlaylistBackButton() {
        return getAnyElement(playlistBackButton);
    }

    public WebElement getPlaylistSaveButton() {
        return getAnyElement(playlistSaveButtonEnglish);
    }

    public WebElement getConfirmationMessageByText(String confirmationText) {
        return getAnyElementByText(confirmationText);
    }

    public WebElement getDismissButton() {
        return getAnyElementByText("Dismiss");
    }

    public PlaylistsPage dismissConfirmationMessage() {
        clickOnElement(getAnyElementByText("Dismiss"));
        return new PlaylistsPage(driver);
    }

    public WebElement getAddSongsButton(String languageName) {
        return switch (languageName) {
            case "Spanish" -> getAnyElementByText("Agregar canciones");
            case "French" -> getAnyElementByText("Ajouter des titres");
            case "Portuguese" -> getAnyElementByText("Acrescentar músicas");
            default -> getAnyElementByText("Add Songs");
        };
    }

    public WebElement getPlaylistsEllipseMenu() {
        return getAnyElement(playlistsEllipseMenu);
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return getAnyElementByText(optionName);
    }

    public void setPlaylistName(String name, String languageName) {
        switch (languageName) {
            case "Spanish" -> sendKeysToElement(playlistNameSpanish, name);
            case "French" -> sendKeysToElement(playlistNameFrench, name);
            case "Portuguese" -> sendKeysToElement(playlistNamePortuguese, name);
            default -> sendKeysToElement(playlistNameEnglish, name);
        }
    }

    public void setPlaylistDescription(String description, String languageName) {
        switch (languageName) {
            case "Spanish" -> sendKeysToElement(playlistDescriptionSpanish, description);
            case "French" -> sendKeysToElement(playlistDescriptionFrench, description);
            case "Portuguese" -> sendKeysToElement(playlistDescriptionPortuguese, description);
            default -> sendKeysToElement(playlistDescriptionEnglish, description);
        }
    }

    public void clickSaveButton(String languageName) {
        switch (languageName) {
            case "Spanish" -> clickOnElement(playlistSaveButtonSpanish);
            case "French" -> clickOnElement(playlistSaveButtonFrench);
            case "Portuguese" -> clickOnElement(playlistSaveButtonPortuguese);
            default -> clickOnElement(playlistSaveButtonEnglish);
        }
    }

    public PlaylistsPage createPlaylist(String name, String description, String languageName) {
        setPlaylistName(name, languageName);
        setPlaylistDescription(description, languageName);
        clickSaveButton(languageName);
        return new PlaylistsPage(driver);
    }

    public PlaylistsContentPage topicsCreatePlaylistAndView(String name, String description, String languageName) {
        setPlaylistName(name, languageName);
        setPlaylistDescription(description, languageName);
        clickSaveButton(languageName);
        clickOnElement(getAnyElementByText("View Playlist"));
        return new PlaylistsContentPage(driver);
    }

    public TopicsDetailsPage topicsCreatePlaylistAndDone(String name, String description, String languageName) {
        setPlaylistName(name, languageName);
        setPlaylistDescription(description, languageName);
        clickSaveButton(languageName);
        clickOnElement(getAnyElementByText("View Playlist"));
        return new TopicsDetailsPage(driver);
    }
}
