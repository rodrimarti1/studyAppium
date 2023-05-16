package org.example.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.util.List;

public class FeedbackPage extends AndroidActions {

    AndroidDriver driver;

    public FeedbackPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send Feedback']")
    private WebElement feedbackTitle;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Attach Image']")
    private WebElement attachButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Submit']")
    private WebElement submitButton;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
    private WebElement nameField;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
    private WebElement emailField;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Dropdown menu']")
    private WebElement categoryDropdown;

    @AndroidFindBy(id = "android:id/content")
    private WebElement categoryOptions;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
    private WebElement descriptionField;

    public String getFeedbackPageTitle() {
        return getAnyElement(feedbackTitle).getText();
    }

    public void setNameField(String name) {
        sendKeysToElement(nameField, name);
    }

    public void setEmailField(String email) {
        sendKeysToElement(emailField, email);
    }

    public void setCategory(String category) {
        clickOnElement(categoryDropdown);
        List<WebElement> allCategories = categoryOptions.findElements(By.xpath("//android.widget.ScrollView/android.view.View/android.widget.TextView"));
        for (int i = 0; i < allCategories.size(); i++) {
            if(allCategories.get(i).getText().equals(category)) {
                allCategories.get(i).click();
                break;
            }
        }

    }

    public void setDescriptionField(String description) {
        sendKeysToElement(descriptionField, description);
    }

    public void clickSubmitButton() {
        clickOnElement(submitButton);
    }

    public WebElement getOptionByText(String text) {
        return getAnyElementByText(text);
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getAttachmentButton() {
        return attachButton;
    }
}
