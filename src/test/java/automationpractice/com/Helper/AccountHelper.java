package automationpractice.com.Helper;

import automationpractice.com.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class AccountHelper extends TestBase {

    public void createAccount(String email) {
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();
    }

    public void chooseGender() {
        driver.findElement(By.id("id_gender1")).click();
    }

    public void name(String firsName, String lastName) {
        driver.findElement(By.id("customer_firstname")).sendKeys(firsName);
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
    }

    public void password(String password) {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public void birthDate() {
        new Select(driver.findElement(By.id("days"))).selectByVisibleText(getDayFromList());
        new Select(driver.findElement(By.id("months"))).selectByVisibleText(getMonthFromList());
        new Select(driver.findElement(By.id("years"))).selectByVisibleText(getYearFromList());
    }

    public void adress(String firstName, String lastName, String company, String adress, String city, String postcode) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address1")).sendKeys(adress);
        driver.findElement(By.id("city")).sendKeys(city);
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(getStateFromList());
        driver.findElement(By.id("postcode")).sendKeys(postcode);
        new Select(driver.findElement(By.id("id_country"))).selectByVisibleText("United States");

    }

    public void phone(String phone, String adress) {
        driver.findElement(By.id("phone_mobile")).sendKeys(phone);
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys(adress);
    }

    public void submitAccount() {
        driver.findElement(By.id("submitAccount")).click();
    }

    public String actualAccount() {
        return driver.findElement(By.className("account")).findElement(By.tagName("span")).getText();
    }

    public String getDayFromList() {
        WebElement element = driver.findElement(By.id("days"));
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        Random r = new Random();
        return list.get(r.nextInt((list.size() - 1) + 1)).getText();
    }

    public String getMonthFromList() {
        WebElement element = driver.findElement(By.id("months"));
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        Random r = new Random();
        return list.get(r.nextInt((list.size() - 1) + 1)).getText();
    }

    public String getYearFromList() {
        WebElement element = driver.findElement(By.id("years"));
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        Random r = new Random();
        return list.get(r.nextInt((list.size() - 1) + 1)).getText();
    }

    public String getStateFromList() {
        WebElement element = driver.findElement(By.id("id_state"));
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        Random r = new Random();
        return list.get(r.nextInt((list.size() - 1) + 1)).getText();
    }
}
