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
    public WebElement feedbackTitle;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Attach Image']")
    public WebElement attachButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Submit']")
    public WebElement submitButton;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
    public WebElement nameField;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[2]")
    public WebElement emailField;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Dropdown menu']")
    public WebElement categoryDropdown;

    @AndroidFindBy(id = "android:id/content")
    public WebElement categoryOptions;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[4]")
    public WebElement descriptionField;

    public String getFeedbackPageTitle() {
        return feedbackTitle.getText();
    }

    public void setNameField(String name) {
        nameField.sendKeys(name);
    }

    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void setCategory(String category) {
        categoryDropdown.click();
        List<WebElement> allCategories = categoryOptions.findElements(By.xpath("//android.widget.ScrollView/android.view.View/android.widget.TextView"));
        for (int i = 0; i < allCategories.size(); i++) {
            if(allCategories.get(i).getText().equals(category)) {
                allCategories.get(i).click();
                break;
            }
        }

    }

    public void setDescriptionField(String description) {
        descriptionField.sendKeys(description);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public WebElement getOptionByText(String text) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='"+ text +"']"));
    }


}
