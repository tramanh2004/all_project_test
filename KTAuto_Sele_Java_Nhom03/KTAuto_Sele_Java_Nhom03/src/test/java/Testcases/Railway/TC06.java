package Testcases.Railway;

import Common.Constant.Constant;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.*;
import Common.Constant.Constant;
import java.time.Duration;
import org.testng.Assert;
public class TC06 {
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
    public void testVerifyAdditionalPagesAfterLogin(){
        System.out.println("TC06 - Additional pages display once user logged in");

        HomePage homePage = new HomePage().open();
        LoginPage loginPage = homePage.gotoLoginPage();
        HomePage loggedInHomePage = loginPage.login(Constant.USERNAME, Constant.PASSWORD);

// Kiểm tra các tab xuất hiện
        Assert.assertTrue(loggedInHomePage.isTabMyTicketDisplayed(), "'My ticket' tab is not displayed");
        Assert.assertTrue(loggedInHomePage.isTabChangePasswordDisplayed(), "'Change password' tab is not displayed");
        Assert.assertTrue(loggedInHomePage.isTabLogoutDisplayed(), "'Logout' tab is not displayed");

        // Kiểm tra điều hướng đến trang 'My ticket' thông qua tiêu đề trang
        loggedInHomePage.gotoMyTicketPage();
        Assert.assertEquals(loggedInHomePage.getPageHeader(), "Manage ticket", "Incorrect header on 'My ticket' page");

        // Quay lại trang chủ rồi test tiếp
//        Constant.WEBDRIVER.navigate().back();

        // Kiểm tra điều hướng đến trang 'Change password' thông qua tiêu đề trang
        loggedInHomePage.gotoChangePasswordPage();
        Assert.assertEquals(loggedInHomePage.getPageHeader(), "Change password", "Incorrect header on 'Change password' page");

    }
}
