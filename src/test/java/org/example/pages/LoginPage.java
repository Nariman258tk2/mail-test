package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@data-testid, 'login-input')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@data-testid, 'enter-password')]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(@data-testid, 'password-input')]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(@data-testid, 'login-to-mail')]")
    private WebElement passwordButton;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwordField.sendKeys(passwd);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickPasswordButton() { passwordButton.click(); }
}
