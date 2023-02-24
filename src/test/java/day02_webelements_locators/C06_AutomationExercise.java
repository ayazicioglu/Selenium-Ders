package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_AutomationExercise {
    public static void main(String[] args) throws InterruptedException {
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementleri=driver.findElements(By.tagName("a"));
        int expectedLinkSayisi=147;
        int actualLinkSayisi=linkElementleri.size();

        if (expectedLinkSayisi==actualLinkSayisi){
            System.out.println("Link sayisi testi PASSED");
        }else System.out.println("Link sayisi FAILED\n " +
                "Sayfada var olan link sayisi: "+actualLinkSayisi);

        //4- Products linkine tiklayin
        driver.findElement(By.partialLinkText(" Products")).click();

        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElement=driver.findElement(By.id("sale_image"));

        if (specialOfferElement.isDisplayed()){
            System.out.println("specialOffer Testi PASSED");
        }else System.out.println("specialOffer Testi FAILED");

        //6- Sayfayi kapatin
        Thread.sleep(2000);
        driver.close();
    }
}
