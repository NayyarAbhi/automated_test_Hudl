package com.automatedtest.hudl.stepDef;

import com.automatedtest.hudl.Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    private LoginPage loginPage;

    public LoginPageSteps() {
        loginPage = new LoginPage();
    }

    @Given("I navigate to hudl Home page")
    public void i_navigate_to_hudl_Home_page() {
        loginPage.goToHomePage();
        Assert.assertEquals("Page title is incorrect.",
                "Performance analysis tools for sports teams and athletes at every level.",
                loginPage.getPageTitle());
    }

    @When("^I click on Login Button$")
    public void click_on_login_button() {
        Assert.assertTrue(loginPage.checkLoginPageDisplayed());
        loginPage.clickLoginBtn();
    }

    @Then("I should see login Page")
    public void i_should_see_login_Page() {
        Assert.assertTrue(loginPage.checkLoginButtonDisplayed());
    }

    @Given("I enter {string} with {string} on login page")
    public void i_enter_details_on_login_page(String email, String password) {
        loginPage.enterCredentials(email, password);
    }

    @Then("I click on Login Button on login page")
    public void i_click_on_login_button() {
        loginPage.clickLoginButtonOnLoginPage();
    }

    @Then("I should be on the users home page")
    public void i_should_see_user_homepage() {
        Assert.assertTrue(loginPage.checkHomePageDisplayed());
    }

    @Then("I should see login error")
    public void i_should_see_login_error() {
        Assert.assertTrue(loginPage.checkLoginErrorDisplayed());
    }
}
