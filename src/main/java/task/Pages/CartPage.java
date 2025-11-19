package task.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By backPack = By.id("item_4_title_link");
    private By boltTshirt= By.id("item_1_title_link");
    private By onesie = By.id("item_2_title_link");
    private By removeTshirt = By.id("remove-sauce-labs-bolt-t-shirt");
    private By continueShopping = By.id("continue-shopping");
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isBackPackExist(){
        return !driver.findElements(backPack).isEmpty();
    }
    public boolean isBoltTshirtExist(){
        return !driver.findElements(boltTshirt).isEmpty();
    }
    public boolean isOnesieExist(){
        return !driver.findElements(onesie).isEmpty();
    }
    public void removeTshirt(){
        driver.findElement(removeTshirt).click();
    }
    public InventoryPage continueShoppingClick(){
        driver.findElement(continueShopping).click();
        return new InventoryPage(driver);
    }
}
