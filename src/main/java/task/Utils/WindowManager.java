package task.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigation;
    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigation = driver.navigate();
    }

  public void switchToNewTab() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(driver -> driver.getWindowHandles().size() > 1);

    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(tabs.size() - 1));

    
    wait.until(driver1 -> !driver1.getCurrentUrl().equals("about:blank"));
}



public void goBack(){
        navigation.back();
    }

}
