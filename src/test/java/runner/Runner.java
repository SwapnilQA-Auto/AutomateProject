package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/test/resources/feature",
        glue = {"step","hooks"},
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports.html"}
)
public class Runner {
}
