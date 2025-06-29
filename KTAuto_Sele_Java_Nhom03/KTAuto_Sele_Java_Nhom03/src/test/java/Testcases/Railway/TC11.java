package Testcases.Railway;

import Common.Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageObjects.Railway.*;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;
import java.util.UUID;

public class TC11 {
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
    public void testCannotRegisterWithEmptyPasswordAndPID() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");

        HomePage homePage = new HomePage().open();

        RegisterPage registerPage = homePage.gotoRegisterPage();

        String email = "auto_user_" + UUID.randomUUID().toString().substring(0, 5) + "@example.com";

        registerPage.register(email, "", "", "");

        // Kiểm tra thông báo lỗi tổng
        Assert.assertEquals(registerPage.getFormErrorMsg().getText(), "There're errors in the form. Please correct the errors and try again.");

        // Kiểm tra lỗi riêng từng trường
        Assert.assertEquals(registerPage.getLbPasswordErrorMsg().getText(), "Invalid password length");
        Assert.assertEquals(registerPage.getLbPidErrorMsg().getText(), "Invalid ID length");
    }
}
