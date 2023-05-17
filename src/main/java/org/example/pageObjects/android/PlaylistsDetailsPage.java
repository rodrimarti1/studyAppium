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
    private WebElement playlistName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Description']/ancestor::android.widget.EditText")
    private WebElement playlistDescription;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Back']")
    private WebElement playlistBackButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
    private WebElement playlistSaveButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='More options']")
    private WebElement playlistsEllipseMenu;

    public WebElement getNewPlaylistPageTitle() {
        return getAnyElement(newPlaylistPageTitle);
    }

    public WebElement getPlaylistName() {
        return getAnyElement(playlistName);
    }

    public WebElement getPlaylistDescription() {
        return getAnyElement(playlistDescription);
    }

    public WebElement getPlaylistBackButton() {
        return getAnyElement(playlistBackButton);
    }

    public WebElement getPlaylistSaveButton() {
        return getAnyElement(playlistSaveButton);
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

    public WebElement getAddSongsButton() {
        return getAnyElementByText("Add Songs");
    }

    public WebElement getPlaylistsEllipseMenu() {
        return getAnyElement(playlistsEllipseMenu);
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return getAnyElementByText(optionName);
    }
}
