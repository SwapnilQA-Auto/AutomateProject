package api;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static api.Login.loginflow;

public class EndToEnd {
    public static WebDriver driver;

    static void main() throws InterruptedException, IOException {
        driver = new SafariDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement check = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(check));
        check.isDisplayed();
// By id
        WebElement username = driver.findElement(By.id("user-name"));
// By name
        WebElement password = driver.findElement(By.name("password"));
// By className
        WebElement loginBtn = driver.findElement(By.className("submit-button"));
        username.sendKeys("standard_user");   // Type text
        password.sendKeys("secret_sauce");    // Type password
        loginBtn.click();
        // Click button
        List<WebElement> dropdown = driver.findElements(By.className("product_sort_container"));
        for (WebElement abc : dropdown) {
            String t = abc.getText();
            System.out.println(t);

        }
        wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) dropdown));

        Select select = new Select((WebElement) dropdown); // Only works if element is <select>
        select.selectByValue("hilo");
        WebElement bag = driver.findElement(By.xpath("//img[@alt=\"Sauce Labs Backpack\"]"));
        File img = bag.getScreenshotAs(OutputType.FILE);
        File file = new File("backpack.png");
        FileUtils.copyFile(img, file);
// Open a new tab in the same browser window
        // WebDriver newTab = driver.switchTo().newWindow(WindowType.WINDOW);
// Navigate to a new URL in the new tab
        // newTab.get("https://www.saucedemo.com");
        // Get all window handles
        // Set<String> handles = driver.getWindowHandles();
        // Iterator<String> it = handles.iterator();
        //  String originalWindow = it.next(); // first window
        //  String newWindowHandle = it.next(); // new window
        // System.out.println(newWindowHandle);
        //System.out.println(originalWindow);
// Switch to new window
        //driver.switchTo().window(newWindowHandzAle);
// Switch back to original window
        // driver.switchTo().window(originalWindow);
        Actions actions = new Actions(driver);
        WebElement name = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        actions.moveToElement(name).perform();
        System.out.println(name);
        driver.findElement(By.name("//button[text()='Add to cart']")).isDisplayed();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400)");
        javascriptExecutor.executeScript("argument[0].scrollIntoView();", name);
        name.click();
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys("abc").build().perform();
        actions.contextClick(name).perform();
    }}
























