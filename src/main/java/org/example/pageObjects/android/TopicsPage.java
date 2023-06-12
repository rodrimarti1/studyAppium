package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TopicsPage extends BasePage {

    public TopicsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Topics']")
    private WebElement topicsTitle;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Search'])[2]")
    private WebElement searchIcon;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='More options']")
    private WebElement moreOptions;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Find by name']/parent::android.view.View/parent::android.widget.EditText")
    private WebElement searchBar;

    public String getTopicsTitle() {
        return topicsTitle.getText();
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public WebElement getMoreOptions() {
        return moreOptions;
    }

    public void performTopicsSearch(String searchKeyword) {
        sendKeysToElement(searchBar, searchKeyword);
    }

    public boolean isSearchFound(String searchText) {
        return getAnyElementByText(searchText).isDisplayed();
    }

    public TopicsDetailsPage clickTopicByName(String topicName) {
        clickOnElement(getAnyElementByText(topicName));
        return new TopicsDetailsPage(driver);
    }
}
