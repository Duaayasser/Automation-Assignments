package task.Login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import task.Base.BaseTests;
import task.Pages.InventoryPage;
import task.Utils.LoginData;

public class LoginTests extends BaseTests {

    @Test(dataProvider = "validData", dataProviderClass = JsonDataProvider.class)
    public void validLogin(LoginData data) {

        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);

        InventoryPage inventoryPage = loginPage.loginClick();

        assertEquals(inventoryPage.getTitle(), "Swag Labs", "Login failed — Title mismatch");
    }

    @Test(dataProvider = "invalidCredentialsData", dataProviderClass = JsonDataProvider.class)
    public void invalidLogin(LoginData data) {

        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);
        loginPage.loginClick();

      
        String message = loginPage.getExpectedMsg();
        assertTrue(message.contains(data.expectedMessage));
    }

    @Test(dataProvider = "missingPasswordData", dataProviderClass = JsonDataProvider.class)
    public void missingPasswordLogin(LoginData data) {

        loginPage.setUsername(data.username);
        loginPage.setPassword(data.password);
        loginPage.loginClick();

       
        String message = loginPage.getExpectedMsg();
        assertTrue(message.contains(data.expectedMessage));
    }
}
