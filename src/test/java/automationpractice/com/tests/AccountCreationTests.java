package automationpractice.com.tests;

import automationpractice.com.model.DataRegistration;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class AccountCreationTests extends TestBase {

    @Test(dataProvider = "validGroups")
    public void createAccountTest(DataRegistration dataRegistration) {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email_create")).sendKeys(dataRegistration.getEmail());
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(dataRegistration.getFirstName());
        driver.findElement(By.id("customer_lastname")).sendKeys(dataRegistration.getLastName());
        driver.findElement(By.id("passwd")).sendKeys(dataRegistration.getPassword());
        new Select(driver.findElement(By.id("days"))).selectByVisibleText(getDayFromList());
        new Select(driver.findElement(By.id("months"))).selectByVisibleText(getMonthFromList());
        new Select(driver.findElement(By.id("years"))).selectByVisibleText(getYearFromList());
        driver.findElement(By.id("firstname")).sendKeys(dataRegistration.getFirstName());
        driver.findElement(By.id("lastname")).sendKeys(dataRegistration.getLastName());
        driver.findElement(By.id("company")).sendKeys(dataRegistration.getCompany());
        driver.findElement(By.id("address1")).sendKeys(dataRegistration.getAdress());
        driver.findElement(By.id("city")).sendKeys(dataRegistration.getCity());
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText(getStateFromList());
        driver.findElement(By.id("postcode")).sendKeys(dataRegistration.getPostcode());
        new Select(driver.findElement(By.id("id_country"))).selectByVisibleText("United States");
        driver.findElement(By.id("phone_mobile")).sendKeys(dataRegistration.getPhoneMobile());
        driver.findElement(By.id("alias")).sendKeys(dataRegistration.getAdress());
        driver.findElement(By.id("submitAccount")).click();

        String actualAccount = driver.findElement(By.className("account")).findElement(By.tagName("span")).getText();
        String expectedAccount = dataRegistration.getFirstName() + " " + dataRegistration.getLastName();

        Assert.assertEquals(actualAccount, expectedAccount);

        driver.findElement(By.linkText("Sign out")).click();
    }

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(DataRegistration.class);
            List<DataRegistration> groups = (List<DataRegistration>) xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    public String getStateFromList() {
        WebElement element = driver.findElement(By.id("id_state"));
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        Random r = new Random();
        return list.get(r.nextInt((list.size() - 1) + 1)).getText();
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
}