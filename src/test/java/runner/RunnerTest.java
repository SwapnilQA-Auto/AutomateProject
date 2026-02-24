package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions (
        features = "classpath:features",
        glue = {"steps","hooks"},
        tags = "", // any tag you want to execute
        monochrome = true,
        plugin = {
                "pretty",                       // Console-friendly output
                "html:target/cucumber-reports", // Basic HTML
                "json:target/cucumber.json",    // For Allure or other tools
                "junit:target/cucumber.xml",    // CI/CD integration
                "rerun:target/rerun.txt"        // Failed scenarios rerun
        }
)
public class RunnerTest {
    @BeforeClass
    public static void setupEnvironment() {
        // Set environment dynamically
        // we can modify this value before running
        System.setProperty("env", "QA");

    }


}
