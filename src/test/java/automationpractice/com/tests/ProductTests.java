package automationpractice.com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.*;

public class ProductTests extends TestBase {
    @Test
    public void testProductsCart() {
        driver.findElement(By.id("header_logo")).click();
        driver.findElement(By.className("homefeatured")).click();
        List<WebElement> products = driver.findElement(By.id("homefeatured")).findElements(By.tagName("li"));
        Random rand = new Random();
        int i = rand.nextInt(products.size());
        WebElement element = products.get(i);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Actions build = new Actions(driver);
        build.moveToElement(element).build().perform();
        driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li["+(1+i)+"]/div/div[2]/div[2]/a[1]/span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".continue")));
        el.click();
        assertTrue(driver.findElement(By.className("ajax_cart_quantity")).isDisplayed());

    }
}