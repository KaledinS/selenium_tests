package automationpractice.com.tests;

import automationpractice.com.Helper.AppHelper;
import automationpractice.com.Helper.ContactFormHelper;
import automationpractice.com.Helper.NavigationHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactFormTest extends TestBase {
    NavigationHelper navigate = new NavigationHelper();
    ContactFormHelper contactForm = new ContactFormHelper();
    AppHelper app = new AppHelper();

    @Test
    public void testContact() {

        navigate.goTo("Contact us");
        contactForm.chooseSubject();
        app.email("mail@mail.com");
        contactForm.order("Order reference");
        contactForm.attachFile("D:\\c\\repozitories\\selenium-tests\\file.txt");
        contactForm.message("Message");
        contactForm.submitMessage();

        assertTrue(isElementPresent(By.xpath("//*[@id=\"center_column\"]/p")));
    }
}
