package step;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.LoginPage;

import static hooks.Hooks.driver;


public class LoginStep {
    private LoginPage loginPage;

    @Given("user on login page")
    public void user_on_login_page() {
        //Hooks.driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
        System.out.println("Launch");
    }

    @Then("user enter username")
    public void user_enter_username() {
        loginPage.enterEmail("student");
    }

    @Then("user enter password")
    public void user_enter_password() {
        loginPage.enterPassword("Password123");
    }

    @Then("user click on login button")
    public void user_click_on_login_button() throws InterruptedException {
        loginPage.buttonClick();
        Thread.sleep(5000);
    }
}
