package task.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import task.Pages.LoginPage;

public class BaseTests {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);   
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
