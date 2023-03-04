package day09_excel_sceenshot_jsexecuter;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import static utilities.TestBaseClass.driver;

public class C07_ReusableMethodsElementSs extends TestBase {

    @Test
    public void test01(){
        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //Nutella icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //Sonuclarin Nutella icerdiğini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik = "Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        //ve rapora eklenmek icin sonuc yazi elementinin goruntusunu alın
        ReusableMethods.webElementScreenshot(sonucYaziElementi);
    }
}
