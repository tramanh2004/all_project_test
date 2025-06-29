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

public class TC05 {
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
    public void testWrongPasswordWarning() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        HomePage homePage = new HomePage().open();
        LoginPage loginPage = homePage.gotoLoginPage();

        String incorrectPassword = "wrongpassword";

        for (int i = 1; i <= 4; i++) {
            loginPage = new LoginPage(); // Reload lại trang Login để chắc chắn trạng thái
            loginPage.login(Constant.USERNAME, incorrectPassword);
            System.out.println("Attempt " + i + ": " + loginPage.getErrorMessage());
        }

        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMsg, expectedMsg, "The warning message after 4 failed attempts is not correct.");
    }

}
