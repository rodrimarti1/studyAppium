package org.example.pageObjects.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class PeoplePage extends BasePage {

    AndroidDriver driver;

    public PeoplePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
}
