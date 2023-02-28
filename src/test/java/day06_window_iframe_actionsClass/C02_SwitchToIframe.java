package day06_window_iframe_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_SwitchToIframe extends TestBase {
    // https://the-internet.herokuapp.com/iframe  adresine gidin
    // "Your content goes here." yazisinin gorunur oldugunu test edin

    @Test
    public void test01(){

        /*
            Bazen locate islemimizden emin olmamiza ragmen
            Locator calismaz
            Bunun sebebi kullanmak istedigimiz webelement'in
            bir iframe'in child'i olmasi olabilir.
            Eger Kullanmak istedigimiz webelement
            anasayfa icine gomulen baska bir websayfasinin elementi ise
            once gomulu sayfaya gecmemiz gerekir
            HTML komutlarinda sayfa icerisine sayfa gomebilmek icin
            <iframe> kullanilir
            Biz de istedigimiz elementi kullanmak icin once
            o frame'e switch yapmaliyiz
            1- gecis yapmak istediginiz frame'i locate edin
            2- switchTo() ile o frame'e gecis yapin
            3- Sonra istediginiz element ile istediginiz islemi yapin
         */
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement frameElement=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);

        WebElement yaziElement=driver.findElement(By.tagName("p"));
        Assert.assertTrue(yaziElement.isDisplayed());

        // Elemental Selenium linkine click yapin
        /*
            Bir frame'e gecis yaptiktan sonra
            oradan cikincaya veya baska bir frame'e gecinceye kadar
            driver o frame icerisinde kalir
            isimiz bittiginde veya baska frame'e gecmek istedigimizde
            once calisacagimiz yere gecis yapmaliyiz
         */
        driver.switchTo().parentFrame();//ic ice framelerde bir üst seviyeye cikar
        //driver.switchTo().defaultContent();//ana sayfaya cikarır
        driver.findElement(By.linkText("Elemental Selenium"));

        bekle(3);

    }
}
