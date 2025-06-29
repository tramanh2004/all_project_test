package Testcases.Railway;

import Common.Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageObjects.Railway.*;
import java.time.Duration;
import java.util.UUID;

import org.testng.annotations.Test;
import org.testng.Assert;

public class TC07 {
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
    public void testUserCanRegisterAccount() {
        System.out.println("TC07 - User can create new account");

        HomePage homePage = new HomePage().open();


        RegisterPage registerPage = homePage.gotoRegisterPage();

        String email = "testuser_" + UUID.randomUUID().toString().substring(0, 5) + "@mail.com";
        String password = "123456789";
        String pid = "123456789";

        registerPage.register(email, password, password, pid);

        String actualMsg = registerPage.getLblRegisterMsg().getText();
        String expectedMsg = "Thank you for registering your account";

        System.out.println("Actual register message: '" + actualMsg + "'");
        Assert.assertEquals(actualMsg, expectedMsg, "Register success message is not displayed as expected");
    }

}
