package PageObjects.Railway;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    private final By _txtCurrentPassword = By.id("currentPassword");
    private final By _txtNewPassword = By.id("newPassword");
    private final By _txtConfirmPassword = By.id("confirmPassword");
    private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By _lblSuccessMsg = By.xpath("//p[@class='message success']");

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        Constant.WEBDRIVER.findElement(_txtCurrentPassword).sendKeys(currentPassword);
        Constant.WEBDRIVER.findElement(_txtNewPassword).sendKeys(newPassword);
        Constant.WEBDRIVER.findElement(_txtConfirmPassword).sendKeys(confirmPassword);
        Constant.WEBDRIVER.findElement(_btnChangePassword).click();
    }

    public WebElement getSuccessMsg() {
        return Constant.WEBDRIVER.findElement(_lblSuccessMsg);
    }
}
