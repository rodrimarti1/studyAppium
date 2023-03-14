package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class PlaylistsPage extends AndroidActions {

    AndroidDriver driver;

    public PlaylistsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Playlists']")
    private WebElement playlistsBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='org.lds.ldsmusic.alpha:id/mainToolbar']/android.widget.TextView")
    private WebElement playlistsTitle;
}
