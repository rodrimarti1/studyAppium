package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class PlaylistsDetailsPage extends AndroidActions {

    AndroidDriver driver;

    public PlaylistsDetailsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
        return newPlaylistPageTitle;
    }

    public WebElement getPlaylistName() {
        return playlistName;
    }

    public WebElement getPlaylistDescription() {
        return playlistDescription;
    }

    public WebElement getPlaylistBackButton() {
        return playlistBackButton;
    }

    public WebElement getPlaylistSaveButton() {
        return playlistSaveButton;
    }

    public WebElement getConfirmationMessageByText(String confirmationText) {
        return getAnyElementByText(confirmationText);
    }

    public WebElement getDismissButton() {
        return getAnyElementByText("Dismiss");
    }

    public PlaylistsPage dismissConfirmationMessage() {
        getAnyElementByText("Dismiss").click();
        return new PlaylistsPage(driver);
    }

    public WebElement getAddSongsButton() {
        return getAnyElementByText("Add Songs");
    }

    public WebElement getPlaylistsEllipseMenu() {
        return playlistsEllipseMenu;
    }

    public WebElement getEllipseMenuOptionByName(String optionName) {
        return getAnyElementByText(optionName);
    }
}
