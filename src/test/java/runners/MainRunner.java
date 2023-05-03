package runners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static utils.DriverFactory.cleanupDriver;
import static utils.DriverFactory.getDriver;


@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
                tags = "@library", monochrome = false, dryRun = false,
                plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
}
