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


class NewsletterPage extends PageBase {
    
    private By checkboxBy = By.xpath("//td/form[@name='account_newsletter']//input[@type='checkbox']");
    private By nextBy = By.xpath("//td/form[@name='account_newsletter']//input[@alt='Folytatás']");

    public NewsletterPage(WebDriver driver) {
        super(driver);
        this.driver.get("http://fantasmania.hu/account_newsletters.php");
    }  

    public void setNewsletterSubscription(boolean subscribe) {
        WebElement checkbox = waitAndReturnElement(checkboxBy);
        boolean checked = getNewsletterSubscription();
        if((subscribe && checked) ||
            (!subscribe && !checked))
            return;
        checkbox.click();
        waitAndReturnElement(nextBy).click();
    }

    public boolean getNewsletterSubscription() {
        WebElement checkbox = waitAndReturnElement(checkboxBy);
        String val = checkbox.getAttribute("checked");
        return null != val;
    }
}
