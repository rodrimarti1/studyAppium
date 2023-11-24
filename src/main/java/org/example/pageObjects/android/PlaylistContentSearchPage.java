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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Library']/following-sibling::android.widget.TextView")
    private WebElement libraryOptionEnglish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Biblioteca']/following-sibling::android.widget.TextView")
    private WebElement libraryOptionSpanish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Bibliothèque']/following-sibling::android.widget.TextView")
    private WebElement libraryOptionFrench;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add Selected']")
    private WebElement addSelectedButtonEnglish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Agregar selección']")
    private WebElement addSelectedButtonSpanish;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Ajouter la sélection']")
    private WebElement addSelectedButtonFrench;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Acrescentar selecionados']")
    private WebElement addSelectedButtonPortuguese;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancel']/following-sibling::android.widget.Button")
    private WebElement cancelModalButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Songs']/following-sibling::android.widget.Button")
    private WebElement addSongsModalButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Back']/parent::android.view.View/parent::android.view.View/android.widget.CheckBox")
    private WebElement selectAllCheckbox;

    public WebElement getSelectAllCheckbox() {
        return getAnyElement(selectAllCheckbox);
    }

    public WebElement getLibraryOption(String languageName) {
        return switch (languageName) {
            case "Spanish", "Portuguese" -> getAnyElement(libraryOptionSpanish);
            case "French" -> getAnyElement(libraryOptionFrench);
            default -> getAnyElement(libraryOptionEnglish);
        };
    }

    public void searchForContentByText(String songName) {
        clickOnElement(searchBar);
        sendKeysToElement(getAnyElement(By.xpath("//android.widget.EditText")), songName);
        hideAndroidKeyboard();
    }

    public void selectSongByName(String songName) {
        clickOnElement(driver.findElement(By.xpath("//android.view.View/android.widget.TextView[contains(@text, '"+ songName +"')]/parent::android.view.View//android.widget.CheckBox")));
    }

    public void clickAddSelectedButton(String languageName) {
        switch (languageName) {
            case "Spanish" -> clickOnElement(addSelectedButtonSpanish);
            case "French" -> clickOnElement(addSelectedButtonFrench);
            case "Portuguese" -> clickOnElement(addSelectedButtonPortuguese);
            default -> clickOnElement(addSelectedButtonEnglish);
        }
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
