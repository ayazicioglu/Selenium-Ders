package day02_webelements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverMethodlari {
    public static void main(String[] args) {
        //Yeni bir class olusturalim (Homework)
        //ChromeDriver kullanarak, facebook sayfasina gidin
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://wwww.facebook.com");
        // ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify),
        // degilse dogru basligi yazdirin.

        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("facebook title testi PASSED");
        }else {
            System.out.println("facebook title testi FAILED\n Gerçekleşen title "+actualTitle);
        }

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
        // icermiyorsa “actual” URL’i yazdirin.

        String expectedIcerik="facebook";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("facebook URL testi PASSED");
        }else {
            System.out.println("facebook url testi FAILED\n Gerçekleşen URL "+actualUrl);
        }

        // https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

        // Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String expectedBaslik="Walmart.com";
        String actualBaslik=driver.getTitle();

        if (actualBaslik.contains(expectedBaslik)){
            System.out.println("walmart title testi PASSED");
        }else {
            System.out.println("walmart title testi FAILED");
        }
        // Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        // Sayfayi yenileyin
        driver.navigate().refresh();

        // Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //Browser’i  kapatin
        driver.close();
    }
}
