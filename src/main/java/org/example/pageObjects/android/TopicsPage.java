package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TopicsPage extends BasePage {

    AndroidDriver driver;

    public TopicsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
}
