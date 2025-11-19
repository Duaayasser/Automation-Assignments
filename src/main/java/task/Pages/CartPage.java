package task.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By item1 = By.id("item_4_title_link");
    private By item2= By.id("item_1_title_link");
    private By item3 = By.id("item_2_title_link");
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isItem1Exist(){
        return !driver.findElements(item1).isEmpty();
    }
    public boolean isItem2Exist(){
        return !driver.findElements(item2).isEmpty();
    }
    public boolean isItem3Exist(){
        return !driver.findElements(item2).isEmpty();
    }
}
