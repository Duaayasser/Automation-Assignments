package task.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By pageTitle = By.className("app_logo");
    private By cartIcon = By.className("shopping_cart_link");
    private By inventoryItems = By.className("inventory_item");
    private By linkedInIcon = By.className("social_linkedin");
    private By cartBadge = By.className("shopping_cart_badge");
    private By item1 = By.id("add-to-cart-sauce-labs-backpack");
    private By item2 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By item3 = By.id("add-to-cart-sauce-labs-onesie");
    public InventoryPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
    public LinkedInPage clickLinkedInIcon(){
        driver.findElement(linkedInIcon).click();
        return new LinkedInPage(driver);
    }
    public boolean isCartEmpty(){
        List<WebElement> badge = driver.findElements(cartBadge);
        return badge.size() == 0;
    }
    public void addToCart(){
        driver.findElement(item1).click();
        driver.findElement(item2).click();
        driver.findElement(item3).click();
    }
    public CartPage goToCart(){
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }
}
