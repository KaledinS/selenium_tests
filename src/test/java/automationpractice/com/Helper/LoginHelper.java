package automationpractice.com.Helper;

import automationpractice.com.tests.TestBase;
import org.openqa.selenium.By;

public class LoginHelper extends TestBase{
    public  void singIn(){
        driver.findElement(By.name("SubmitLogin")).click();
    }
    public void singOut(){
        driver.findElement(By.linkText("Sign out")).click();
    }
}
