package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class DriverFactory {

    private static ThreadLocal<AndroidDriver> webDriver = new ThreadLocal<>();

    public static AndroidDriver getDriver() {
        if(webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static AndroidDriver createDriver() {
        AppiumDriverLocalService service;
        AndroidDriver driver;

        String appiumPath = null;

        Map<String, String> map = System.getenv();
        for (Map.Entry <String, String> entry: map.entrySet()) {
            if (entry.getKey().equals("APPIUM")) {
                appiumPath = entry.getValue();
            }
        }
        assert appiumPath != null;

        service = new AppiumServiceBuilder().withAppiumJS(new File(appiumPath))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        //Make sure there's only device connected
        options.setDeviceName("Android Device");
        options.setPlatformVersion("12.0");
        options.setNoReset(false);
        String currentDir = System.getProperty("user.dir");
        options.setApp(currentDir + "/src/main/resources/app-alpha.apk");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

        return driver;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
