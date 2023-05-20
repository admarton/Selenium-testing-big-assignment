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


class NavBar extends PageBase {
    private By logoBy = By.xpath("//a[@href='https://consteelsoftware.com']//img[@src='https://consteelsoftware.com/wp-content/uploads/2022/07/cropped-new_logo-1.png']");

    public NavBar(WebDriver driver) {
        super(driver);
    }    

    public String getLogoAltText() {
        return this.waitAndReturnElement(logoBy).getAttribute("alt");
    }
           
}
