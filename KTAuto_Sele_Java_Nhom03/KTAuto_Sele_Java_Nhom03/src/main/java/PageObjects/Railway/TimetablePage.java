package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimetablePage {
    public BookTicketPage clickBookTicket(String depart, String arrive) {
        String xpath = String.format("//tr[td[text()='%s'] and td[text()='%s']]//a[text()='book ticket']", depart, arrive);
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", link);
        System.out.println(link);


        link.click();
        return new BookTicketPage();


    }

}
