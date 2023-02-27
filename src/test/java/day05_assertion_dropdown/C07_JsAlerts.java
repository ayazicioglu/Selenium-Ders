package day05_assertion_dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseClass;

public class C07_JsAlerts extends TestBaseClass {

    // Gerekli ayarlamalari yapip
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
    // 1.alert'e tiklayalim
    // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
    // OK tusuna basip alert'i kapatalim

    // 2.alert'e tiklayalim
    // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

    // 3.alert'e tiklayalim
    // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
    // Cikan sonuc yazisinin Abdullah icerdigini test edelim

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(2);

        // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        String expectedIcerik="I am a JS Alert";
        String actualIcerik=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedIcerik,actualIcerik);

        // OK tusuna basip alert'i kapatalim
        driver.switchTo().alert().accept();
        bekle(2);
    }

    @Test
    public void test02(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        bekle(2);

        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        String cancelYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedCancelYazisi="You clicked: Cancel";
        bekle(2);

        Assert.assertEquals(expectedCancelYazisi,cancelYazisi);
    }
    @Test
    public void test03(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        bekle(2);

        // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();
        bekle(2);

        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedSonucYazisi="Abdullah";
        String actualSonucYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));

    }
}
