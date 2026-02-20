package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailuser = By.name("username");
    private By passworduser = By.name("password");
    private By button = By.id("submit");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterEmail(String email){
        driver.findElement(emailuser).sendKeys(email);

    }
    public void enterPassword(String password){
        driver.findElement(passworduser).sendKeys(password);

    }
    public void buttonClick(){
        driver.findElement(button).click();

    }

}
