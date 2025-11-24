package task.Base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import task.Pages.LoginPage;
import task.Utils.WindowManager;

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

    @AfterMethod
public void cleanTabs() {
    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
    String firstTab = tabs.get(0);

    for (String tab : tabs) {
        if (!tab.equals(firstTab)) {
            driver.switchTo().window(tab);
            driver.close();
        }
    }

    driver.switchTo().window(firstTab);
}


    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
}
