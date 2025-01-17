package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
                tags = "@releaseScreenshots_english or @releaseScreenshots_spanish or @releaseScreenshots_french or @releaseScreenshots_portuguese", monochrome = true, dryRun = false,
                plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class ScreenshotsRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
