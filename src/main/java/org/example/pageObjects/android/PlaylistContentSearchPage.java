package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlaylistContentSearchPage extends BasePage {
    public PlaylistContentSearchPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search for songs']/following-sibling::android.widget.TextView")
    private WebElement searchBar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add Selected']")
    private WebElement addSelectedButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancel']/following-sibling::android.widget.Button")
    private WebElement cancelModalButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Songs']/following-sibling::android.widget.Button")
    private WebElement addSongsModalButton;

    public void searchForContentByText(String songName) {
        clickOnElement(searchBar);
        sendKeysToElement(getAnyElement(By.xpath("//android.widget.EditText")), songName);
        hideAndroidKeyboard();
    }

    public void selectSongByName(String songName) {
        clickOnElement(driver.findElement(By.xpath("//android.view.View/android.widget.TextView[@text='"+ songName +"']/following-sibling::android.widget.CheckBox")));
    }

    public void clickAddSelectedButton() {
        clickOnElement(addSelectedButton);
    }

    public PlaylistsContentPage clickAddSongsConfirmationButton() {
        clickOnElement(addSongsModalButton);
        return new PlaylistsContentPage(driver);
    }

    public PlaylistContentSearchPage clickCancelConfirmationButton() {
        clickOnElement(cancelModalButton);
        return new PlaylistContentSearchPage(driver);
    }
}
