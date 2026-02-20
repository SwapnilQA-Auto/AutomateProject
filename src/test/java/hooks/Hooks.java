package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utility.configReader;

public class Hooks {
    public static WebDriver driver;
    private configReader configReader;

    @Before
    public void setDriver(){
        configReader = new configReader();
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
        String url=configReader.getURL();
        driver.get(url);

    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
