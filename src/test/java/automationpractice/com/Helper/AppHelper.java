package automationpractice.com.Helper;

import automationpractice.com.tests.TestBase;
import org.openqa.selenium.By;

public class AppHelper extends TestBase {
    public void password(String password) {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }
    public void email(String email){
        driver.findElement(By.id("email")).sendKeys(email);

    }
}
