package org.example;

import org.example.pages.LoginPage;
import org.example.pages.MailPage;
import org.example.pages.WriteMessagePage;
import org.example.utils.ConfProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MainTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MailPage mailPage;
    public static WriteMessagePage writeMessagePage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        writeMessagePage = new WriteMessagePage(driver);

        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginButton();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickPasswordButton();
        mailPage.clickWriteMessageButton();
        writeMessagePage.inputToAddressField("test@mail.ru");
        writeMessagePage.inputHeaderField("Test header");
        writeMessagePage.inputBodyMessageField("test body");
        writeMessagePage.clickSendButton();

        Thread.sleep(5000);
    }

    @AfterClass
    public static void exit() {
        driver.quit();
    }
}
