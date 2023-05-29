import org.junit.*;
import org.openqa.selenium.Cookie;
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


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    By headerNavBy = By.xpath("//table/tbody/tr[@class='headerNavigation']");
    By logoutButtonBy = By.xpath("//table/tbody/tr[@class='headerNavigation']//a[@href='http://fantasmania.hu/logoff.php']");
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void reload() {
        this.driver.navigate().refresh();
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 
    
    public String getPageTitle() {
        return this.driver.getTitle();
    }

    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }

    public void removeCookies() {
        this.driver.manage().deleteAllCookies();
    }

    public boolean IsCookieExists(String name) {
        Cookie cookie = driver.manage().getCookieNamed(name);
        return null != cookie;
    }
   
    public boolean isLoggedIn() {
        return waitAndReturnElement(headerNavBy).getText().contains("Kilépés");
    }
   
    public boolean isNotLoggedIn() {
        return waitAndReturnElement(headerNavBy).getText().contains("Belépés");
    }

    public void Logout() {
        waitAndReturnElement(logoutButtonBy).click();
    }
}
