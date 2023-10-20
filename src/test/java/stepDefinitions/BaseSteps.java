package stepDefinitions;

import io.cucumber.java.en.Given;
import static utils.DriverFactory.getDriverLocalization;

public class BaseSteps {

    @Given("User switches device language to {string}")
    public void userSwitchesDeviceLanguageToDeviceLanguage(String locale, String deviceLanguage) {
        getDriverLocalization(deviceLanguage, locale);
    }
}
