package automationpractice.com.tests;

import automationpractice.com.Helper.AppHelper;
import automationpractice.com.Helper.LoginHelper;
import automationpractice.com.Helper.NavigationHelper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends TestBase {
    AppHelper app = new AppHelper();
    NavigationHelper navigate = new NavigationHelper();
    LoginHelper login = new LoginHelper();

    @Test
    public void testLogin() {

        navigate.goTo("Sign in");
        app.email("test_automationpractice@mail.ru");
        app.password("password");
        login.singIn();
        assertTrue(isElementPresent(By.className("logout")));
        login.singOut();
        assertTrue(isElementPresent(By.id("login_form")));
    }
}
