package task.Utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewTab() {
    String currentTab = driver.getWindowHandle();
    for (String tab : driver.getWindowHandles()) {
        if (!tab.equals(currentTab)) {
            driver.switchTo().window(tab);
            break;
        }
    }
}

}
