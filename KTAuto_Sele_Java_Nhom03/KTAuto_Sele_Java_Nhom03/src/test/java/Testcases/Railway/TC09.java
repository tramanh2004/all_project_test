package Testcases.Railway;

import PageObjects.Railway.*;
import Common.Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC09 {
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
    public void testUserCanChangePassword() {
        System.out.println("TC09 - User can change password");

        HomePage homePage = new HomePage().open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();

        String oldPassword = Constant.PASSWORD;
        String newPassword = "NewPassword" + System.currentTimeMillis();

        changePasswordPage.changePassword(oldPassword, newPassword, newPassword);

        String actualMsg = changePasswordPage.getSuccessMsg().getText();
        String expectedMsg = "Your password has been updated!";

        System.out.println("Actual message: '" + actualMsg + "'");
        Assert.assertEquals(actualMsg, expectedMsg, "Change password message not as expected");

        // (Optional) Step 6: Cập nhật lại mật khẩu cũ để tài khoản không bị khóa
        changePasswordPage.changePassword(newPassword, oldPassword, oldPassword);
    }
}
