package day05_assertion_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin.
    //	     https://facebook.com
    //	b. Cookies’i kabul edin
    //	c. Create an account buton’una basin
    //	d. Radio button elementlerini locate edin ve size uygun olani secin
    //  e. Sectiginiz radio butoon'un secili, otekilerin ise secili olmadigini test edin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");
    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void test(){
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();

        WebElement female=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement male=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement custom=driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        male.click();
        Assert.assertTrue(male.isSelected());
        Assert.assertFalse(female.isSelected());
        Assert.assertFalse(custom.isSelected());
    }
}
