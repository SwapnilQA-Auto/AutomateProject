package api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static api.Login.loginflow;

public class EndToEnd {
    public static WebDriver driver;

    static void main()   {
        driver = new SafariDriver();
        driver.navigate().to("https://www.saucedemo.com");
        driver.manage().timeouts().getImplicitWaitTimeout();
        loginflow();
        driver.quit();


    }
}
