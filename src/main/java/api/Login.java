package api;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static api.EndToEnd.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Login {

    @Test
    public void loginTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        // Disable password breach warnings
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080"); // optional but recommended
        Map<String, Object> prefs = new HashMap<String, Object>();
// Disables the password manager and leak detection (compromised password warning)
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false); // Essential for "Change Password" popup
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10,100));
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement logo=driver.findElement(By.xpath("//div[text()='Swag Labs']"));
       System.out.println( logo.getCssValue("font"));
        wait.until(ExpectedConditions.visibilityOfAllElements(logo));
        driver.manage().logs();
        FluentWait<WebDriver> fluentWait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
        System.out.println(logo.getText());
        System.out.println(logo.getAttribute("Labs"));
        System.out.println(logo.getLocation());
        System.out.println(logo.getSize());
        driver.findElement(By.id("user-name")).sendKeys("visual_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        // Assert that login was successful by checking the URL
        assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login did not redirect to inventory page.");
       WebElement drop= driver.findElement(By.className("product_sort_container"));
        Select select=new Select(drop);
       System.out.println( select.getAllSelectedOptions());
       System.out.println( select.getOptions());
       select.selectByVisibleText("Price (high to low)");
       // Assert that the first product is the expected highest-priced item
       WebElement firstProduct = driver.findElement(By.cssSelector(".inventory_item:first-of-type .inventory_item_name"));
       assertEquals("Sauce Labs Fleece Jacket", firstProduct.getText(), "First product after sorting is not the highest-priced item.");
       // Click all "Add to cart" buttons, handling StaleElementReferenceException with a while loop
       int cartIndex = 0;
       List<WebElement> cart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
       while (cartIndex < cart.size()) {
           try {
               // Re-find the buttons each iteration to avoid stale references
               cart = driver.findElements(By.xpath("//button[text()='Add to cart']"));
               if (cartIndex >= cart.size()) {
                   break;
               }
               WebElement button = cart.get(cartIndex);
               wait.until(ExpectedConditions.elementToBeClickable(button));
               String text = button.getText();
               System.out.println(text);
               // Assert that the button text is "Add to cart" before clicking
               assertEquals("Add to cart", text, "\"Add to cart\" button text mismatch before clicking.");
               button.click();
               Thread.sleep(100);
               cartIndex++;
           } catch (org.openqa.selenium.StaleElementReferenceException e) {
               // If the element is stale, refetch and retry
               // No increment; just retry in next loop iteration
               continue;
           }
       }

       String parent=driver.getWindowHandle();
       driver.switchTo().newWindow(WindowType.TAB);
       driver.close();
       driver.switchTo().window(parent);
       System.out.println(parent);
        driver.quit();

        }




    }
