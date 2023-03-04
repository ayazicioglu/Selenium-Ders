package day09_excel_sceenshot_jsexecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_JavaScriptExecuterClick extends TestBase {
    @Test
    public void test01(){
        //wisaquarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");

        //refresh diyerek reklamdan kurtul
        driver.navigate().refresh();

        //Java Test otomation tanitimina kadar asagı inin
        WebElement otomasyonElement=driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));
        bekle(2);
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        bekle(2);
        jse.executeScript("arguments[0].scrollIntoView();",otomasyonElement);

        // ve resmi click yapın
        jse.executeScript("arguments[0].click();",otomasyonElement);
        bekle(2);

        //ekrana "JUnit bitti" yazdirin
        jse.executeScript("alert('JUnit Bitti');");
        bekle(2);
    }
}
