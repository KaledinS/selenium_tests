package automationpractice.com.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestClass extends TestBase {
    // public static void main(String args[]) {
//        char[] array = new char[8];
//        int rand;
//        Random r = new Random();
//        for (int i = 0; i < 8; i++) {
//            rand = r.nextInt(127) + 1; //тут менять нужные диапазоны ((max - min) + 1) + min (см ASCII)
//            array[i] = (char) rand;
//        }
//        for (char c : array)
//            System.out.println(c);

//        byte[] array = new byte[10]; // length is bounded by 7
//        new Random().nextBytes(array);
//        String generatedString = new String(array, Charset.forName("ASCII"));
//
//        System.out.println(generatedString);

//        int leftLimit = 97; // letter 'a'
//        int rightLimit = 122; // letter 'z'
//        int targetStringLength = 10;
//        Random random = new Random();
//        StringBuilder buffer = new StringBuilder(targetStringLength);
//        for (int i = 0; i < targetStringLength; i++) {
//            int randomLimitedInt = leftLimit + (int)
//                    (random.nextFloat() * (rightLimit - leftLimit + 1));
//            buffer.append((char) randomLimitedInt);
//        }
//        String generatedString = buffer.toString();
//
//        System.out.println(generatedString);


//        RandomStringGenerator randomStringGenerator =
//                new RandomStringGenerator.Builder()
//                        .withinRange('0', 'z')
//                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
//                        .build();
//        randomStringGenerator.generate(12);

//        System.out.println("Generating String of length 10: "+RandomStringUtils.randomAlphanumeric(10));
//        System.out.println("Generating String of length 10: "+RandomStringUtils.randomAlphanumeric(10));
//        System.out.println("Generating String of length 10: "+RandomStringUtils.randomAlphanumeric(10));
//}

    @Test
    public void testTest() {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email_create")).sendKeys("asdf@as.sd");
        driver.findElement(By.id("SubmitCreate")).click();
        //List<WebElement> elem = driver.findElements(By.id("id_state"));
        List<WebElement> el = driver.findElement(By.id("id_state")).findElements(By.tagName("option"));
        // List<String> str = new ArrayList<>();
        for (WebElement e : el) {
            // str.add(e.toString());
            // System.out.println(str);
            System.out.println(e.getText());
        }
        System.out.println(el.size());
        // System.out.println(el);
        WebElement selectElem = driver.findElement(By.id("id_state"));
        Select select = new Select(selectElem);
        // List options = select.getOptions();
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        System.out.println(selectedOptions);

        List<WebElement> options = driver.findElements(
                By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[7]/div/select/option"));

        System.out.println(options.size());


//        WebElement element=driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
//        Select select1=new Select(element);
//        List<WebElement> list=select1.getOptions();
//        for(int i=1;i<list.size();i++)
//        {
//            System.out.println(list.get(i).getText());
//        }
//
//    }
        WebElement element=driver.findElement(By.id("id_state"));
        Select select1=new Select(element);
        List<WebElement> list = select1.getOptions();
        Random r = new Random();
//        for(int i=0;i<list.size();i++)
//        {
//            System.out.println(list.get(i).getText());
//        }
        System.out.println(list.get(r.nextInt(list.size())).getText());
//return
    }

//    public String method(){
//        WebElement element=driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
//        Select select1=new Select(element);
//        List<WebElement> list = select1.getOptions();
//        Random r = new Random();
////        for(int i=0;i<list.size();i++)
////        {
////            System.out.println(list.get(i).getText());
////        }
//        return list.get(r.nextInt(list.size())).toString();
////return
//    }

}
