package PageObjects.Railway;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class RegisterPage extends GeneralPage{

    private final By _txtEmail = By.id("email");
    private final By _txtPassword = By.id("password");
    private final By _txtConfirmPassword = By.id("confirmPassword");
    private final By _txtPID = By.id("pid");
    private final By _btnRegister = By.xpath("//input[@value='Register']");
    private final By _lblRegisterMsg = By.xpath("//div[@id='content']/p");
    private final By _lblFormErrorMsg = By.xpath("//p[@class='message error']");
    private final By _lbPasswordErrorMsg = By.xpath("//label[@for='password' and contains(text(),'Invalid password length')]");
    private final By _lbPidErrorMsg = By.xpath("//label[@for='pid' and contains(text(),'Invalid ID length')]");

    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_txtConfirmPassword);
    }

    public WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(_txtPID);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    public WebElement getLblRegisterMsg() {
        return Constant.WEBDRIVER.findElement(_lblRegisterMsg);
    }

    public WebElement getLbPasswordErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lbPasswordErrorMsg);
    }

    public WebElement getLbPidErrorMsg(){
        return Constant.WEBDRIVER.findElement(_lbPidErrorMsg);
    }

    public void register(String email, String password, String confirmPassword, String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPID().sendKeys(pid);
        getBtnRegister().click();
    }
    public WebElement getFormErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblFormErrorMsg);
    }

}
