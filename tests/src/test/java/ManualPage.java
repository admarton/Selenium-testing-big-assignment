import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class ManualPage extends PageBase {
    
    public ManualPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://consteelsoftware.com/manual/");
    }  

    public boolean isPageLocked() {
        try {
            this.waitAndReturnElement(By.xpath("//div[@class='servicecenter-manual-authgate']/img[@src='https://consteelsoftware.com/wp-content/themes/consteel/assets/login_required_illustration.svg']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
