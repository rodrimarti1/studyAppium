package runners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static utils.DriverFactory.cleanupDriver;
import static utils.DriverFactory.getDriver;


@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
                monochrome = false, dryRun = false)
public class MainRunner extends AbstractTestNGCucumberTests {
    @Before
    public void setup() {
        getDriver();
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
