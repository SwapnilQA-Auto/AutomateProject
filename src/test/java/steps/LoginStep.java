package steps;

import io.cucumber.java.en.*;
import utility.WebAction;

import java.io.IOException;

public class LoginStep {

    @Given("user on login page")
    public void user_on_login_page() throws InterruptedException {
        System.out.println("Launch");
        WebAction.getTitle();
    }

    @Then("user enter username")
    public void user_enter_username() {
        WebAction.sendText("Login","username","student", true);
        System.out.println("Launch");
    }

    @Then("user enter password")
    public void user_enter_password() {
        WebAction.sendText("Login","password","Password123",true);
        System.out.println("Launch");
    }

    @Then("user click on login button")
    public void user_click_on_login_button() throws InterruptedException, IOException {
        WebAction.click("Login","loginButton");
        System.out.println("Launch");
    }
}
