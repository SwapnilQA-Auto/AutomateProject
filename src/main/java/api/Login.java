package api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static api.EndToEnd.driver;

public class Login {

    public static void loginflow (){
        WebElement username =driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");
        WebElement password =driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.className("app_logo"));
        String page= driver.getTitle();
        System.out.println(page);
    }
}
