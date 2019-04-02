package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactFormTest extends TestBase{
    @Test
    public  void testContact() {
        driver.findElement(By.linkText("Contact us")).click();
        new Select(driver.findElement(By.id("id_contact"))).selectByVisibleText("Customer service");
        driver.findElement(By.id("email")).sendKeys("mail@mail.com");
        driver.findElement(By.id("id_order")).sendKeys("Order reference");
        driver.findElement(By.id("fileUpload")).sendKeys("D:\\c\\repozitories\\selenium-tests\\file.txt");
        driver.findElement(By.id("message")).sendKeys("Message");
        driver.findElement(By.id("submitMessage")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//*[@id=\"center_column\"]/p")));
    }
}
