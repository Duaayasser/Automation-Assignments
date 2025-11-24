package task.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void removeTshirt() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(removeTshirt));
    driver.findElement(removeTshirt).click();
}

    public InventoryPage continueShoppingClick(){
        driver.findElement(continueShopping).click();
        return new InventoryPage(driver);
    }
}
