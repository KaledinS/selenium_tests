package automationpractice.com.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends TestBase {
    @Test
    public  void testLogin(){
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys("test_automationpractice@mail.ru");
        driver.findElement(By.id("passwd")).sendKeys("password");
        driver.findElement(By.name("SubmitLogin")).click();
        assertTrue(isElementPresent(By.className("logout")));
        driver.findElement(By.linkText("Sign out")).click();
        assertTrue(isElementPresent(By.id("login_form")));
    }
}
