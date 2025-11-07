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
}
