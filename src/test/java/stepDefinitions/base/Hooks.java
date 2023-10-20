package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static utils.DriverFactory.*;

public class Hooks {
    @Before("not @releaseScreenshots_english and not @releaseScreenshots_spanish and not @releaseScreenshots_french and not @releaseScreenshots_portuguese")
    public void setup() {
        getDriver();
    }

    @Before("@releaseScreenshots_english")
    public void setupEnglish() {
        getDriverLocalization("US", "en");
    }

    @Before("@releaseScreenshots_spanish")
    public void setupSpanish() {
        getDriverLocalization("MX", "es");
    }

    @Before("@releaseScreenshots_french")
    public void setupFrench() {
        getDriverLocalization("FR", "fr");
    }

    @Before("@releaseScreenshots_portuguese")
    public void setupPortuguese() {
        getDriverLocalization("PT", "pt");
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
