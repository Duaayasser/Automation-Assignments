package task.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By pageTitle = By.className("app_logo");
    private By cartIcon = By.className("shopping_cart_link");
    private By inventoryItems = By.className("inventory_item");
    public InventoryPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
    }
    public String getTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public boolean checkCartIcon(){
        return driver.findElement(cartIcon).isDisplayed();
    }
    public int getInventoryItemsCount(){
        return driver.findElements(inventoryItems).size();
    }
}
