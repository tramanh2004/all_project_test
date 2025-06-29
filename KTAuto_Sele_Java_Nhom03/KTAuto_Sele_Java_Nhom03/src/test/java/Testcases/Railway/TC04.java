package Testcases.Railway;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import PageObjects.Railway.*;
import Common.Constant.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class TC04 {
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
    public void testRedirectToLoginWhenNotLoggedIn(){
        System.out.println("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab");

        HomePage homePage = new HomePage().open();
        GeneralPage generalPage = homePage.gotoBookTicketPage();

        LoginPage loginPage = new LoginPage();

        Assert.assertTrue(loginPage.isAtLoginPage(), "Login page should be displayed when clicking 'Book ticket' while un-logged.");
    }
}
