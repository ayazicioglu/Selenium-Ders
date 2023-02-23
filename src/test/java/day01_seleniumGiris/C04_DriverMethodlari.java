package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.wisequarter.com");

        System.out.println(driver.getWindowHandle());
        //CDwindow-5EE8371215A481C26871F7655B9F31A3
        //CDwindow-19C5EB23449F492C12B9C683F93435B8
        // getWindowHandle selenium tarafindan her driver sayfasi icin uretilen
        // unique handle degerini döndürür
        // getWindowHandels() ise test sirasinda birden fazla sayfa acilmissa
        // bir set olarak, tum sayfalarin window handle degerlerini döndürür

        System.out.println(driver.getPageSource());

        // sayfa kodlari "2 hours weekly meeting with the team" iceriyor mu test edin

        String expectedIcerik="2 hours weekly meeting with the team";
        String actualIcerik=driver.getPageSource();

        if (actualIcerik.contains(expectedIcerik)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        Thread.sleep(3000);

        driver.quit();
        // close() ve quit() ikisi de sayfa kapatmak icin kullanilir
        // close() sadece bir sayfa kapatirken
        // quit() test sirasinda acilan tum sayfalari kapatir
    }
}
