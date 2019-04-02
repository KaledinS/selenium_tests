package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class ProductTests extends TestBase {
    @Test
    public void testProductsCart() {
        driver.findElement(By.id("header_logo")).click();
        driver.findElement(By.className("homefeatured")).click();
        List<WebElement> products = driver.findElement(By.id("homefeatured")).findElements(By.tagName("li"));
        Random rand = new Random();
        int i = rand.nextInt(products.size());
        WebElement element = products.get(i);
        Actions build = new Actions(driver);
        build.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li["+(1+i)+"]/div/div[2]/div[2]/a[1]/span")).click();
        driver.findElement(By.cssSelector(".continue")).click();
        Assert.assertTrue(driver.findElement(By.className("ajax_cart_quantity")).isDisplayed());
    }
}