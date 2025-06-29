package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");

    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By lbWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By pageHeader = By.xpath("//div[@id='content']/h1");

    //Elements
    protected   WebElement  getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected   WebElement  getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected   WebElement  getLbWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lbWelcomeMessage);
    }

    protected   WebElement  getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected   WebElement  getTabTimetable(){
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }


    //Method
    public String getWelcomeMessage(){
        return this.getLbWelcomeMessage().getText();
    }

    public String getPageHeader() {
        return Constant.WEBDRIVER.findElement(pageHeader).getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }

    public MyTicketPage gotoMyTicketPage() {
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }

    public TimetablePage gotoTimetablePage(){
        this.getTabTimetable().click();
        return new TimetablePage();
    }

    public ChangePasswordPage gotoChangePasswordPage() {
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }

    public boolean isTabMyTicketDisplayed() {
        return getTabMyTicket().isDisplayed();
    }

    public boolean isTabLogoutDisplayed() {
        return getTabLogout().isDisplayed();
    }

    public boolean isTabChangePasswordDisplayed() {
        return getTabChangePassword().isDisplayed();
    }
}
