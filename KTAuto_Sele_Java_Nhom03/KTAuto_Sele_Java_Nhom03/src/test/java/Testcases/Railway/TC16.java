package Testcases.Railway;

import Common.Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import PageObjects.Railway.*;
import org.testng.Assert;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC16 {
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
    public void testCancelTicketSafely() {
        System.out.println("TC16 - User can cancel a ticket safely");

        HomePage homePage = new HomePage().open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();

        if (!myTicketPage.hasTickets()) {
            System.out.println("No existing tickets found. Booking a new one...");
            BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
            bookTicketPage.bookTicket("5/18/2025","Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");

            myTicketPage = homePage.gotoMyTicketPage();
        }

        System.out.println("Canceling first ticket...");
        myTicketPage.cancelFirstTicketSafely();

        boolean hasRemainingTickets = myTicketPage.hasTickets();
        System.out.println("Remaining tickets after cancel: " + hasRemainingTickets);
        Assert.assertFalse(hasRemainingTickets, "Ticket was not canceled successfully.");
    }
}
