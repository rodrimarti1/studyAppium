package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
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
    private WebElement sortIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Search']")
    private WebElement searchIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Play']")
    private WebElement songListPlayButton;

    public SongDetailsPage goToSongDetailsPage(String songName) {
        getAnyElementByText(songName).click();
        return new SongDetailsPage(driver);
    }

    public WebElement getSongListPlayButton() {
        return songListPlayButton;
    }

    public void maximizeMusicPlayer() {
        driver.findElement(By.xpath("(//android.view.View[@content-desc='Audio Track']/following-sibling::android.widget.TextView)[2]")).click();
    }
}
