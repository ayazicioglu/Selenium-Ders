package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    /* ...Exercise2...
 1 - Java class'imiza chromedriver.exe'yi tanitalim
 2 - Driver olusturalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklemesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.otto.de");

        String actualOttoTitle=driver.getTitle();
        String actualOttoURL=driver.getCurrentUrl();
        String actualIcerik="OTTO";

        if (actualOttoTitle.contains(actualIcerik)){
            System.out.println("ottoTitle testi PASSED");
        }else System.out.println("ottoTitle testi FAILED");

        if (actualOttoURL.contains(actualIcerik)){
            System.out.println("ottoURL testi PASSED");
        }else System.out.println("ottoURL testi FAILED");

        driver.navigate().to("https://wisequarter.com/");
        String actualWiseTitle=driver.getTitle();
        boolean isTrue=actualWiseTitle.contains("Quarter");

        if (isTrue){
            System.out.println("wiseTitle testi PASSED");
        }else System.out.println("wiseTitle testi FAILED");

        System.out.println("2.yöntem ternary");
        System.out.println(isTrue ? "wiseTitle testi PASSED" :"wiseTitle testi FAILED");

        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().back();

        driver.quit();

    }
}
