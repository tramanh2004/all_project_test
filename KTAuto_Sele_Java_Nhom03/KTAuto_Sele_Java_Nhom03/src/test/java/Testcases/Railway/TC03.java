package Testcases.Railway;

import Common.Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageObjects.Railway.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC03 {
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
    public void testLoginWithInvalidPassword(){
        System.out.println("TC03 - User cannot log into Railway with invalid password ");

        HomePage homePage = new HomePage().open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,"123");
        String actualMsg = loginPage.getLbLoginErrorMsg().getText();
        String expectedMsg = "Invalid username or password. Please try again.";

        System.out.println("Actual error message: '" + actualMsg + "'");
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");

    }
}
