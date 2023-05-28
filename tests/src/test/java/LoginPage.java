import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class LoginPage extends PageBase {

    private By emailBy = By.xpath("//form[@name='login']//input[@name='email_address']");
    private By passwordBy = By.xpath("//form[@name='login']//input[@name='password']");
    private By loginButtonBy = By.xpath("//form[@name='login']//input[@type='image']");
    
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("http://fantasmania.hu/login.php");
    }    

    public void Login(String email, String password) {
        waitAndReturnElement(emailBy).sendKeys(email);
        waitAndReturnElement(passwordBy).sendKeys(password);
        waitAndReturnElement(loginButtonBy).click();
    }
}
