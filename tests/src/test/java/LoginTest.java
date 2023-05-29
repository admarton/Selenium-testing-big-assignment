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

import java.io.*;
import java.util.Properties;

public class LoginTest {
    public WebDriver driver;
    private Properties config;

    @Before
    public void setup()  throws MalformedURLException, java.io.FileNotFoundException, java.io.IOException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();

        String configFilePath = "src/config.properties";
        FileInputStream propsInput = new FileInputStream(configFilePath);
        config = new Properties();
        config.load(propsInput);
    }
    
    @Test
    public void testLoginAndLogout() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.isNotLoggedIn());
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.Login(config.getProperty("TEST_USER_EMAIL"),
            config.getProperty("TEST_USER_PASSWORD"));
        Assert.assertTrue(loginPage.isLoggedIn());
        loginPage.Logout();
        mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.isNotLoggedIn());
    }
    
    @Test
    public void testLoginFail() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.isNotLoggedIn());
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.Login(RandomString.getAplhaNumeric(10),
            RandomString.getAplhaNumeric(8));
        Assert.assertTrue(loginPage.getBodyText().contains("Hiba: Ez az e-mail és/vagy jelszó nincs beregisztrálva!"));
        Assert.assertTrue(loginPage.isNotLoggedIn());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
