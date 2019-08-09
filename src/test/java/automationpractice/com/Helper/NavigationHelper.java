package automationpractice.com.Helper;

import automationpractice.com.tests.TestBase;
import org.openqa.selenium.By;

public class NavigationHelper extends TestBase {
    public void goTo(String link){
        driver.findElement(By.linkText(link)).click();
    }
}
