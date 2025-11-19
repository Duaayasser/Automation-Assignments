package task.Inventory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import task.Base.BaseTests;
import task.Login.JsonDataProvider;
import task.Pages.InventoryPage;
import task.Utils.LoginData;
public class InventoryTests extends BaseTests{
    @Test(dataProvider = "validData", dataProviderClass = JsonDataProvider.class)
    public void inventoryTest(LoginData data){
        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);
        InventoryPage inventoryPage = loginPage.loginClick();
        assertEquals(inventoryPage.getTitle(),"Swag Labs","The titls is incorrect");
        assertTrue(inventoryPage.checkCartIcon(),"The cart icon is not displayed");
       int itemCount = inventoryPage.getInventoryItemsCount();
       assertEquals(itemCount, 6,"Incorrect items count");
    }
    @Test(dataProvider = "validData", dataProviderClass = JsonDataProvider.class)
    public void linkenInIconTest(LoginData data){
        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);
        InventoryPage inventoryPage = loginPage.loginClick();
        inventoryPage.clickLinkedInIcon();
        getWindowManager().switchToNewTab();
        String currURL = driver.getCurrentUrl();
        assertTrue(currURL.contains("linkedin"),"The URL is incorrect");
    }
    @Test(dataProvider = "validData", dataProviderClass = JsonDataProvider.class)
    public void facebookIconTest(LoginData data){
        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);
        InventoryPage inventoryPage = loginPage.loginClick();
        inventoryPage.clickFacebookIcon();
        getWindowManager().switchToNewTab();
        String currURL = driver.getCurrentUrl();
        assertTrue(currURL.contains("facebook"),"The URL is incorrect");
    }
    @Test(dataProvider = "validData", dataProviderClass = JsonDataProvider.class)
    public void twitterIconTest(LoginData data){
        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);
        InventoryPage inventoryPage = loginPage.loginClick();
        inventoryPage.clickTwitterIcon();
        getWindowManager().switchToNewTab();
        String currURL = driver.getCurrentUrl();
        assertTrue(currURL.contains("x.com"),"The URL is incorrect");
    }
    @Test(dataProvider = "validData", dataProviderClass = JsonDataProvider.class)
    public void emptyCartTest(LoginData data){
        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);
        InventoryPage inventoryPage = loginPage.loginClick();
        boolean emptyList = inventoryPage.isCartEmpty();
        assertTrue(emptyList,"The cart is not empty");
    }
    
}
