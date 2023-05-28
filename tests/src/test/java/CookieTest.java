import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  

import java.net.URL;
import java.net.MalformedURLException;


public class CookieTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testCartNotShowingWithoutIDCookie() {
        MainPage mainPage = new MainPage(this.driver);
        SearchResultPage searchResult = mainPage.search("star wars");
        searchResult.PutFirstItemIntoCart();
        CartPage cartPage = new CartPage(this.driver);
        Assert.assertTrue(cartPage.isCartNotEmpty());
        cartPage.removeCookies();
        cartPage.reload();
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @Test
    public void testMoveToCartCreatesIDCookie() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertFalse(mainPage.IsCookieExists("osCsid"));
        SearchResultPage searchResult = mainPage.search("star wars");
        searchResult.PutFirstItemIntoCart();
        Assert.assertTrue(mainPage.IsCookieExists("osCsid"));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
