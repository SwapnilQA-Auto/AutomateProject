package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.configReader;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    public static WebDriver driver;
    private configReader configReader;

    @Before
    public void setDriver(){
        // Read environment from system property (default to "QA")
        String env = System.getProperty("env");
        configReader = new configReader(env);
        String browser = configReader.getBrowser();// read from config
        if (browser == null || browser.isEmpty()) {
            throw new RuntimeException("Browser is not specified in config.properties");
        }
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        //Go to URL
        String url = configReader.getURL();
        driver.get(url);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;

                // Create screenshots folder if not exists
                String folderPath = System.getProperty("user.dir") + "/screenshots";
                File folder = new File(folderPath);
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                // Add timestamp to avoid overwrite
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = scenario.getName().replaceAll(" ", "_")
                        + "_" + timeStamp + ".png";

                File src = ts.getScreenshotAs(OutputType.FILE);
                File dest = new File(folderPath + "/" + fileName);
                FileUtils.copyFile(src, dest);

                // Attach to Cucumber report
                byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
