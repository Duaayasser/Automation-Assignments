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
        assertTrue(cartPage.isBackPackExist(),"The BackPack is not exist");
        assertTrue(cartPage.isBoltTshirtExist(),"The Bolt T-shirt is not exist");
        assertTrue(cartPage.isOnesieExist(),"The onesie is not exist");
    }
    @Test(dataProvider = "validData", dataProviderClass = JsonDataProvider.class)
    public void removeItemFromCartTest(LoginData data){
        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);
        InventoryPage inventoryPage = loginPage.loginClick();
        inventoryPage.addToCart();
        CartPage cartPage = inventoryPage.goToCart();
        cartPage.removeTshirt();
        cartPage.continueShoppingClick();
        inventoryPage = new InventoryPage(driver); //to return new inventory page with the new changes
        assertTrue(inventoryPage.getButton2Text().contains("Add to cart"));
        assertTrue(inventoryPage.getButton1Text().contains("Remove"));
        assertTrue(inventoryPage.getButton3Text().contains("Remove")); 

    }
}
