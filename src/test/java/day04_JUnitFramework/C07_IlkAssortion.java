package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_IlkAssortion {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin
    //   farkli test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedURL="https://www.bestbuy.com/";
        String actualURL=driver.getCurrentUrl();

        Assert.assertEquals(expectedURL,actualURL);
    }
    @Test
    public void test02(){
        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test03(){
        //		○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test04(){
        WebElement frLink=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(frLink.isDisplayed());
    }
}
