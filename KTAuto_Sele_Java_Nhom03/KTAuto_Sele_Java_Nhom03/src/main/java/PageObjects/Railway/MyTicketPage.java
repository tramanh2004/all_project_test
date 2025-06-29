package PageObjects.Railway;

import org.openqa.selenium.*;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class MyTicketPage extends GeneralPage{
    private final By pageHeader = By.xpath("//div[@id='content']/h1");

    private final By tableRows = By.xpath("//table[@class='MyTable']/tbody/tr");
    private final By cancelButtons = By.xpath("//table[@class='MyTable']//input[@value='Cancel']");
    private final By lblPageTitle = By.xpath("//h1");

    public List<WebElement> getAllTickets() {
        return Constant.WEBDRIVER.findElements(tableRows);
    }

    public boolean hasTickets() {
        return !getAllTickets().isEmpty();
    }

    public void cancelFirstTicketSafely() {
        List<WebElement> cancelButtons = Constant.WEBDRIVER.findElements(By.xpath("//table[@class='MyTable']//input[@value='Cancel']"));

        if (cancelButtons.isEmpty()) {
            System.out.println("No tickets to cancel");
            return;
        }

        WebElement firstCancelBtn = cancelButtons.get(0);

        try {
            new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(firstCancelBtn));
            firstCancelBtn.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Fallback to JS click due to intercept.");
            ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].click();", firstCancelBtn);
        }

        // Xử lý alert xác nhận
        try {
            WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = Constant.WEBDRIVER.switchTo().alert();
            alert.accept();
        } catch (TimeoutException e) {
            System.out.println("No confirmation alert appeared.");
        }
    }

    public boolean isTicketListEmpty() {
        return getAllTickets().isEmpty();
    }

    public String getPageTitle() {
        return Constant.WEBDRIVER.findElement(lblPageTitle).getText();
    }
}
