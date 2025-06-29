package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class BookTicketPage extends GeneralPage{

    private final By ddlDepartStation = By.name("DepartStation");
    private final By ddlArriveStation = By.name("ArriveStation");
    private final By ddlSeatType = By.name("SeatType");
    private final By ddlTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By departDate = By.name("Date");

    public void bookTicket(String date, String depart, String arrive, String seatType, String amount) {
        new Select(Constant.WEBDRIVER.findElement(departDate)).selectByVisibleText(date);
        new Select(Constant.WEBDRIVER.findElement(ddlDepartStation)).selectByVisibleText(depart);
        new Select(Constant.WEBDRIVER.findElement(ddlArriveStation)).selectByVisibleText(arrive);
        new Select(Constant.WEBDRIVER.findElement(ddlSeatType)).selectByVisibleText(seatType);
        new Select(Constant.WEBDRIVER.findElement(ddlTicketAmount)).selectByVisibleText(amount);
        Constant.WEBDRIVER.findElement(btnBookTicket).click();
    }

    public String getDepartDate() {
        return Constant.WEBDRIVER.findElement(departDate).getText();
    }

    public String getSelectedDepartStation() {
        return new Select(Constant.WEBDRIVER.findElement(ddlDepartStation)).getFirstSelectedOption().getText();
    }

    public String getSelectedArriveStation() {
        return new Select(Constant.WEBDRIVER.findElement(ddlArriveStation)).getFirstSelectedOption().getText();
    }

    public String getSeatType() {
        return new Select(Constant.WEBDRIVER.findElement(ddlSeatType)).getFirstSelectedOption().getText();
    }

    public String getTicketAmount() {
        return new Select(Constant.WEBDRIVER.findElement(ddlTicketAmount)).getFirstSelectedOption().getText();
    }
}
