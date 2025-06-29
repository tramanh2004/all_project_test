package PageObjects.Railway;
import Common.Constant.Constant;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {
    public HomePage open()
    {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    public RegisterPage gotoRegisterPage() {
        Constant.WEBDRIVER.findElement(By.xpath("//a[@href='/Account/Register.cshtml']")).click();
        return new RegisterPage();
    }
}
