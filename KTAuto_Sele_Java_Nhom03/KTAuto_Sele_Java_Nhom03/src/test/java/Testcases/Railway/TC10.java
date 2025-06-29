package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.*;

import PageObjects.Railway.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

public class TC10 {
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
    public void testRegisterWithMismatchedPasswords(){
        System.out.println("TC10 - User can't create account with 'Confirm password' not matching 'Password'");

        HomePage homePage = new HomePage().open();

        RegisterPage registerPage = homePage.gotoRegisterPage();


        String email = "test" + UUID.randomUUID().toString().substring(0, 5) + "@mail.com";
        String password = "ValidPass123";
        String confirmPassword = "InvalidPass123";
        String pid = "123456789";

        registerPage.register(email, password, confirmPassword, pid);

        // Step 4: Kiểm tra thông báo lỗi
        String actualMsg = registerPage.getFormErrorMsg().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        System.out.println("Actual error message: '" + actualMsg + "'");
        Assert.assertEquals(actualMsg, expectedMsg, "Error message not as expected");
    }
}
