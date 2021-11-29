package com.automatedtest.hudl.Pages;

import com.automatedtest.hudl.basepage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    @FindBy(linkText = "Log in")
    private WebElement loginButtonOnHomePage;

    @FindBy(id = "logIn")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement loginEmail;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(xpath = "//a[@data-qa-id='webnav-globalnav-home']/span[text()='Home']")
    private WebElement profileName;

    @FindBy(className = "login-error-container")
    private WebElement loginError;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage() {
        navigateToUrl(properties.getProperty("url"));
        implicitWait(10);
    }

    public String getPageTitle() {
        return getWindowTitle();
    }

    public boolean checkLoginPageDisplayed() {
        waitTillElementIsVisible(30, loginButtonOnHomePage);
        return isElementDisplayed(loginButtonOnHomePage);
    }

    public void clickLoginBtn() {
        click(loginButtonOnHomePage);
    }

    public boolean checkLoginButtonDisplayed() {
        waitTillElementIsVisible(30, loginButton);
        return isElementDisplayed(loginButton);
    }

    public void clickLoginButtonOnLoginPage() {
        isElementDisplayed(loginButton);
        click(loginButton);
        implicitWait(10);
    }

    public void enterCredentials(String username, String password) {
        click(loginEmail);
        clearText(loginEmail);
        sendKeys(loginEmail, username);

        clearText(loginPassword);
        sendKeys(loginPassword, password);
    }

    public boolean checkHomePageDisplayed() {
        waitTillElementIsVisible(10, profileName);
        return isElementDisplayed(profileName);
    }

    public boolean checkLoginErrorDisplayed() {
        if (checkLoginButtonEnable() == false) {
            waitTillElementIsVisible(10, loginError);
        }
        return isElementDisplayed(loginError);
    }

    public boolean checkLoginButtonEnable() {
        return isElementEnabled(loginButton);
    }

}
