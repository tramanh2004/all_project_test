package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageObjects.Railway.*;
import org.testng.Assert;

import java.time.Duration;

public class TC15 {

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
    public void testOpenBookTicketFromTimetable(){
        HomePage homePage = new HomePage().open();

        LoginPage loginPage = homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        TimetablePage timetablePage = homePage.gotoTimetablePage();

        BookTicketPage bookTicketPage = timetablePage.clickBookTicket("Huế", "Sài Gòn");

        String actualDepart = bookTicketPage.getSelectedDepartStation();
        String actualArrive = bookTicketPage.getSelectedArriveStation();

        Assert.assertEquals(actualDepart, "Huế", "Depart station is incorrect. Found: " + actualDepart);
        Assert.assertEquals(actualArrive, "Sài Gòn", "Arrive station is incorrect. Found: " + actualArrive);

    }
}
