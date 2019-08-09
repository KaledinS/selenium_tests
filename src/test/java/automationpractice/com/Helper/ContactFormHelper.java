package automationpractice.com.Helper;

import automationpractice.com.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ContactFormHelper extends TestBase {
    public void chooseSubject(){
        new Select(driver.findElement(By.id("id_contact"))).selectByVisibleText("Customer service");
    }
  //  public void email(String email){
   //     driver.findElement(By.id("email")).sendKeys(email);
  //  }
    public void order(String order){
        driver.findElement(By.id("id_order")).sendKeys(order);
    }
    public void attachFile(String path){
        driver.findElement(By.id("fileUpload")).sendKeys(path);
    }
    public void message(String message){
        driver.findElement(By.id("message")).sendKeys(message);
    }
    public void submitMessage(){
        driver.findElement(By.id("submitMessage")).click();
    }

}
