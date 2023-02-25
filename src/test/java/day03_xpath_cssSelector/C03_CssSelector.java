package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_CssSelector {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-  bir class olusturun
        //2-  https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-  Sayfa basliginin “Spend less” ifadesi icerdigini test edin

        String expectedIcerik="Spend less";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("title testi PASSED");
        }else System.out.println("title testi FAILED");

        //6-  Gift Cards sekmesine basin
        driver.findElement(By.cssSelector("a[data-csa-c-slot-id='nav_cs_3']")).click();

        //7-  Birthday butonuna basin
        driver.findElement(By.cssSelector("img[alt='Birthday']")).click();

        //8-  Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();

        //9-  Gift card details’den 25 $’i  secin
        driver.findElement(By.cssSelector("#gc-mini-picker-amount-1")).click();

        //10- Urun ucretinin 25$ oldugunu test edin
        WebElement urunUcret=driver.findElement(By.cssSelector("#gc-live-preview-amount"));
        String expectedUcret="25$";
        String actualUcret=urunUcret.getText();

        if (expectedUcret.equals(actualUcret)){
            System.out.println("Ucret testi PASSED "+actualUcret);
        }else System.out.println("Ucret testi FAILED "+actualUcret);

        //11- Sayfayi kapatin
        driver.close();
    }
}
