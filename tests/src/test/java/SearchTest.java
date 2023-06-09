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


public class SearchTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }
    
    @Test
    public void testSearch() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getFooterText().contains("Unibrand Hungary Kft"));

        SearchResultPage searchResultPage = mainPage.search("nincs találat");
        String bodyText = searchResultPage.getBodyText();
        Assert.assertTrue(bodyText.contains("Ezzel a szóval nem találtuk a terméket."));
    }
    
    @Test
    public void testSearchFound() {
        String[] searchQueries={"star wars","pókember","marvel"};  
        for(String searchQuery : searchQueries) {  
            MainPage mainPage = new MainPage(this.driver);
            SearchResultPage searchResultPage = mainPage.search(searchQuery);
            String bodyText = searchResultPage.getBodyText();
            Assert.assertTrue(bodyText.contains("Lista"));
            Assert.assertTrue(bodyText.contains("Összesen"));
        }  
    }
    
    @Test
    public void testSearchNotFound() {
        String[] searchQueries={"something","","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"};  
        for(String searchQuery : searchQueries) {  
            MainPage mainPage = new MainPage(this.driver);
            SearchResultPage searchResultPage = mainPage.search(searchQuery);
            String bodyText = searchResultPage.getBodyText();
            Assert.assertTrue(bodyText.contains("Ezzel a szóval nem találtuk a terméket."));
        }  
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
