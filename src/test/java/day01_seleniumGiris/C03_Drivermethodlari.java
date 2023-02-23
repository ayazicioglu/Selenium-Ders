package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_Drivermethodlari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize(); //açılan pencereyi tam ekran yaptı

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // gittiginiz sayfadaki title ve url'i yazdirin
        System.out.println("URL : "+driver.getCurrentUrl());
        System.out.println("BASLIK = " + driver.getTitle());

        // amazon anasayfaya gittiginizi test edin



        // Test expected result ile actual result'in karsilastirilmasidir
        // ornegin url amazon iceriyorsa diyebiliriz
        String expectedIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

    }
}
