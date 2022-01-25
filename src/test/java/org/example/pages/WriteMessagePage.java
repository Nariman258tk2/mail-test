package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WriteMessagePage {
    public WebDriver driver;

    public WriteMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input")
    private WebElement toAdressField;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]")
    private WebElement bodyMessageField;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input")
    private WebElement headerField;

    @FindBy(xpath = "//*[text()='Отправить']")
    private WebElement sendButton;

    public void inputToAddressField(String address) {
        toAdressField.sendKeys(address);
    }

    public void inputHeaderField(String header) {
        headerField.sendKeys(header);
    }

    public void inputBodyMessageField(String message) {
        bodyMessageField.sendKeys(message);
    }

    public void clickSendButton() {
        sendButton.click();
    }
}
