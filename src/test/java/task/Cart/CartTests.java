package task.Cart;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import task.Base.BaseTests;
import task.Login.JsonDataProvider;
import task.Pages.CartPage;
import task.Pages.InventoryPage;
import task.Utils.LoginData;

public class CartTests extends BaseTests{
    @Test(dataProvider = "validData", dataProviderClass = JsonDataProvider.class)
    public void cartTest(LoginData data){
        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);
        InventoryPage inventoryPage = loginPage.loginClick();
        inventoryPage.addToCart();
        CartPage cartPage = inventoryPage.goToCart();
        assertTrue(cartPage.isItem1Exist(),"Item 1 is not exist");
        assertTrue(cartPage.isItem2Exist(),"Item 2 is not exist");
        assertTrue(cartPage.isItem3Exist(),"Item 3 is not exist");

    }
}
