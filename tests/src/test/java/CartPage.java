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


class CartPage extends PageBase {
    
    private By checkoutBy = By.xpath("//td/form[@name='cart_quantity']//a/img[@alt='Pénztár']");
    private By nextBy = By.xpath("//td/form[@name='cart_quantity']//a/img[@alt='Folytatás']");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver.get("http://fantasmania.hu/shopping_cart.php");
    }  

    public boolean isCartNotEmpty() {
        try {
            this.waitAndReturnElement(checkoutBy);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isCartEmpty() {
        try {
            this.waitAndReturnElement(nextBy);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
