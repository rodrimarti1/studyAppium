package tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.example.pageObjects.android.LibraryPage;
import org.example.pageObjects.android.TabsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AppiumDriverLocalService service;
    public AndroidDriver driver;
    public LibraryPage libraryPage;
    public TabsPage tabsPage;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {
        //Start Appium programmatically
        service = new AppiumServiceBuilder().withAppiumJS(new File("//Users//ravn05//.nvm//versions//node//v19.4.0//bin//appium"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 3");
        options.setPlatformVersion("12.0");
        options.setNoReset(false);
        String currentDir = System.getProperty("user.dir");
        //options.setApp("//Users/ravn05/Downloads/SacredMusicAndroid/src/test/resources/SMAndroidAlpha.apk");
        options.setApp(currentDir + "/src/main/resources/SM21083.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

        libraryPage = new LibraryPage(driver);
        tabsPage = new TabsPage(driver);
    }

    @AfterClass
    public void tearDown() {
        //Stop Driver and Appium Server
        driver.quit();
        service.stop();
    }

    public void longPressAction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)element).getId(),
                        "duration", 2000));
    }

    public void scrollToEnd() {
        // Scroll to end
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100,
                "top", 100,
                "width", 200,
                "height", 200,
                "direction", "down",
                "percent", 3.0
        ));
    }

    public void swipeAction(WebElement element, String direction) {
        //Swipe logic
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }
}
