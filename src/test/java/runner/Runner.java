package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/resources/feature",
        glue = {"step","hooks"},
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports.html"}
)
public class Runner {

    @BeforeClass
    public static void setupEnvironment() {
        // Set environment dynamically
        // we can modify this value before running
        System.setProperty("env", "QA");
    }


}
