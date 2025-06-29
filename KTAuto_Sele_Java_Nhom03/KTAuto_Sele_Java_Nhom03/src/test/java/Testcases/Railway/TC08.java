package Testcases.Railway;

import PageObjects.Railway.*;
import Common.Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class TC08 {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
    @Test
    public void testLoginWithAccountNoActived() {
        System.out.println("TC08 - User can't login with an account hasn't been activated");


        HomePage homePage = new HomePage().open();
        RegisterPage registerPage = homePage.gotoRegisterPage();

        String newEmail = "testuser_" + UUID.randomUUID().toString().substring(0, 5) + "@mail.com";
        String password = "123456789";
        String pid = "123456789";

        registerPage.register(newEmail, password, password, pid);



        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.getTxtUsername().sendKeys(newEmail);
        loginPage.getTxtPassword().sendKeys(password);
        loginPage.getBtnLogin().click();

        String actualMsg = loginPage.getLbLoginErrorMsg().getText();
        String expectedMsg = "Invalid username or password. Please try again.";

        System.out.println("Actual error message: '" + actualMsg + "'");
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }
}

