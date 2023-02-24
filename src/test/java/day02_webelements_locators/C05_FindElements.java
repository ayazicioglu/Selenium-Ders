package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) throws InterruptedException {

       // System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidin
        driver.get("https://wwww.amazon.com");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
       // aramaKutusu.submit();   +Keys.ENTER aynı işi yapar,teksatırda işi çözebiliriz

        List<WebElement> aramaSonuclariElementList=driver.findElements(By.className("sg-col-inner"));
        System.out.println(aramaSonuclariElementList.size());//92

         //System.out.println(aramaSonuclariElementList); list'in referanslarını yazdırır o yüzden foreach ile yazdırablrz
        int elementNo=1;
        for (WebElement eachElement:aramaSonuclariElementList
             ) {
            System.out.println(elementNo + "---" + eachElement.getText());
            elementNo++;
        }

        Thread.sleep(3000);
        driver.close();
    }
}
