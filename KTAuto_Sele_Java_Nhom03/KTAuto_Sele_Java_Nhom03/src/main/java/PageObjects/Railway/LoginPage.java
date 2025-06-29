package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //locater
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _btnLogin = By.xpath("//input[@value='login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _btnForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");
    private final By _btnSendInstruction = By.xpath("//input[@value='Send Instructions']");

    //elements
    public WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLbLoginErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public WebElement getBtnForgotPassword()
    {
        return Constant.WEBDRIVER.findElement(_btnForgotPassword);
    }

    public WebElement getTxtEmail()
    {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getBtnSendInstruction()
    {
        return Constant.WEBDRIVER.findElement(_btnSendInstruction);
    }
    //methods
    public String getErrorMessage() {
        return getLbLoginErrorMsg().getText();
    }

    public HomePage login(String username, String password){
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        //land on Homepage
        return new HomePage();
    }
    public LoginPage ForgotPasswordPage(String email)
    {
        this.getBtnForgotPassword().click();
        this.getTxtEmail().sendKeys(email);
        this.getBtnSendInstruction().click();

        return new LoginPage();
    }
    public boolean isAtLoginPage() {
        return getTxtUsername().isDisplayed() && getBtnLogin().isDisplayed();
    }
}
