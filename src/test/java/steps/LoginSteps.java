package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {


    @Given("user has navigated to EMR application")
    public void user_has_navigated_to_emr_application() {
       launchBrowser();
    }
    @When("user enter valid username , password and email")
    public void user_enter_valid_username_password_and_email() {
       loginPage.usernameField.sendKeys("Phil1");
       loginPage.passwordField.sendKeys("phil");
       loginPage.emailField.sendKeys("heya@invalid.email.com");
    }
    @When("user selects his language choice")
    public void user_selects_his_language_choice() {
       selectFromDropDown(LoginPage.loginPage.languageChoice, "English (Standard)");
    }
    @When("user cliks on login button")
    public void user_cliks_on_login_button() {
       loginPage.loginBTN.click();
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {

        Assert.assertEquals(loginPage.dashboardMessage.getText(),"Dashboard");
        System.out.println("user entered successfully ");;
    }
}
