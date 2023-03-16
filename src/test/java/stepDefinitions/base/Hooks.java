package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static utils.DriverFactory.cleanupDriver;
import static utils.DriverFactory.getDriver;

public class Hooks {
    @Before
    public void setup() {
        getDriver();
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
