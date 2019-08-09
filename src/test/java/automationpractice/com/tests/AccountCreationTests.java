package automationpractice.com.tests;

import automationpractice.com.Helper.AccountHelper;
import automationpractice.com.Helper.AppHelper;
import automationpractice.com.Helper.NavigationHelper;
import automationpractice.com.model.DataRegistration;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;


public class AccountCreationTests extends  TestBase {
       AccountHelper account = new AccountHelper();
       NavigationHelper navigate = new NavigationHelper();
       AppHelper app = new AppHelper();

    @Test(dataProvider = "validDataRegistrations")
    public void createAccountTest(DataRegistration dataRegistration) {
        navigate.goTo("Sign in");
        account.createAccount(dataRegistration.getEmail());
        account.chooseGender();
        account.name(dataRegistration.getFirstName(),dataRegistration.getLastName());
        app.password(dataRegistration.getPassword());
        account.birthDate();
        account.adress(dataRegistration.getFirstName(),dataRegistration.getLastName(),dataRegistration.getCompany()
        ,dataRegistration.getAdress(),dataRegistration.getCity(),dataRegistration.getPostcode());
        account.phone(dataRegistration.getPhoneMobile(),dataRegistration.getAdress());
        account.submitAccount();

        String actualAccount = account.actualAccount();
        String expectedAccount = dataRegistration.getFirstName() + " " + dataRegistration.getLastName();

        assertEquals(actualAccount, expectedAccount);

        navigate.goTo("Sign out");
    }

    @DataProvider
    public Iterator<Object[]> validDataRegistrations() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(DataRegistration.class);
            List<DataRegistration> dataRegistrations = (List<DataRegistration>) xstream.fromXML(xml);
            return dataRegistrations.stream().map((d) -> new Object[]{d}).collect(Collectors.toList()).iterator();
        }
    }




}