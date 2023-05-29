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


class MainPage extends PageBase {

    private By footerBy = By.xpath("/html/body/table/tbody/tr/td/div");
    private By searchBarBy = By.xpath("//form[@name='search']/input[@name='keywords']");
    private By searchBarButtonBy = By.xpath("//form[@name='search']/input[@type='image']");
    
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("http://fantasmania.hu/");
    }    

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }
    
    public SearchResultPage search(String searchQuery) {     
        this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery);
        this.waitAndReturnElement(searchBarButtonBy).click();
        return new SearchResultPage(this.driver);
    }
}
