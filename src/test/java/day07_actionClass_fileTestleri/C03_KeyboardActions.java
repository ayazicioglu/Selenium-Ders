package day07_actionClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyboardActions extends TestBase {
    //1- https://www.facebook.com adresine gidelim
    //2- Yeni hesap olustur butonuna basalim
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //4- Kaydol tusuna basalim

    @Test
    public void test01(){
        driver.get("https://www.facebook.com");

       driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

       WebElement isimKutusu=driver.findElement(By.xpath("//input[@placeholder='Adın']"));

       Actions actions=new Actions(driver);
       Faker faker=new Faker();
       String fakeEmailAdres=faker.internet().emailAddress();
       actions.click(isimKutusu).sendKeys(faker.name().firstName()).
               sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
               sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).
               sendKeys(Keys.TAB).sendKeys(fakeEmailAdres).
               sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
               sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("12").
               sendKeys(Keys.TAB).sendKeys("Mart").sendKeys(Keys.TAB).
               sendKeys("1996").sendKeys(Keys.TAB).
               sendKeys(Keys.TAB).sendKeys(Keys.TAB).
               sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
               sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
    }
}
