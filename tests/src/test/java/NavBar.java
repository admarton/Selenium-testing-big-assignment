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
    private By navItemsBy = By.xpath("//nav/div[@class='Navbar_right__EAgLc']");

    public NavBar(WebDriver driver) {
        super(driver);
    }    

    public String getText() {
        return this.waitAndReturnElement(navItemsBy).getText();
    }
           
}
