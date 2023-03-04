package day09_excel_sceenshot_jsexecuter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactorySpi;

public class C04_TumSayfaScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {
        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //Nutella icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //Sonuclarin Nutella icerdiğini test edin
        String expectedIcerik="Nutella";
        String actualSonucYazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        //ve rapora eklenmek icin tum sayfanin ekran goruntusunu alın

        //Tum sayfa screenshot icin
        //1-TakeScreenshot objesi olustur
        TakesScreenshot ts= (TakesScreenshot) driver;

        //2-screenshot'i kaydedecegimiz bir dosya olusturalim
        File tumSayfaSS=new File("target/screenshot.png");

        //3-gecici bir dosya olusturup ts objesi ile alinan gorutuyu dosyaya kaydediyoruz
        File geciciResim=ts.getScreenshotAs(OutputType.FILE);

        //4-gecici dosyayi tumSayfaSS dosyasina kopyalayım
        FileUtils.copyFile(geciciResim,tumSayfaSS);

        bekle(3);
    }
}
