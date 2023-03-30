package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class CollectionDetailsPage extends AndroidActions {

    AndroidDriver driver;

    public CollectionDetailsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Sort Icon']")
    WebElement sortIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']")
    WebElement searchIcon;

    public SongDetailsPage goToSongDetailsPage(String songName) {
        getAnyElementByText(songName).click();
        return new SongDetailsPage(driver);
    }
}
