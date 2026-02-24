package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.configReader;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {
    public static WebDriver driver;
    private configReader configReader;
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public void setDriver(){
        logger.info("========== Test Execution Started ==========");

        // Read environment from system property (default to "QA")
        String env = System.getProperty("env");
        logger.info("Environment selected: " + env);
        configReader = new configReader(env);
        String browser = configReader.getBrowser();// read from config
        logger.info("Browser from config: " + browser);
        if (browser == null || browser.isEmpty()) {
            throw new RuntimeException("Browser is not specified in config.properties");
        }
        switch (browser) {
            case "chrome":
                logger.info("Launching Chrome browser");
                ChromeOptions chromeOptions = new ChromeOptions();
                // Check if headless is enabled in config
                String headless = configReader.getHeadless(); // e.g., "true" or "false"
                if ("true".equalsIgnoreCase(headless)) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=1920,1080");
                    chromeOptions.addArguments("--disable-gpu");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                logger.info("Launching Firefox browser");
                driver = new FirefoxDriver();
                break;
            case "safari":
                logger.info("Launching Safari browser");
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        driver.manage().window().maximize();
        //Go to URL
        String url = configReader.getURL();
        logger.info("Navigating to URL: " + url);
        driver.get(url);
    }

    @After
    public void tearDown(Scenario scenario) {
        logger.info("========== Test Execution Finished ==========");

        if (scenario != null && scenario.isFailed()) {
            logger.error("Scenario Failed: " + scenario.getName());
            try {
                if (driver != null && driver instanceof TakesScreenshot) {
                    TakesScreenshot ts = (TakesScreenshot) driver;

                    // Create screenshots folder if not exists
                    String folderPath = System.getProperty("user.dir") + "/screenshots";
                    File folder = new File(folderPath);
                    if (!folder.exists()) {
                        folder.mkdirs();
                    }

                    // Sanitize scenario name for filename
                    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    String fileName = scenario.getName().replaceAll("[^a-zA-Z0-9_]", "_")
                            + "_" + timeStamp + ".png";

                    File src = ts.getScreenshotAs(OutputType.FILE);
                    File dest = new File(folderPath + "/" + fileName);
                    FileUtils.copyFile(src, dest);

                    // Attach to Cucumber report
                    byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
                }
            } catch (Exception e) {
                logger.error("Error while capturing screenshot", e);
            }
        }

        logger.info("Closing browser");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
