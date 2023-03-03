package day08_explicitlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C06_WebTables extends TestBase {
    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        WebElement header=driver.findElement(By.xpath("//div[@class='rt-tr']"));
        System.out.println(header.getText());

        //3. 3.sutunun basligini yazdirin
        System.out.println(driver.findElement(By.xpath("//div[text()='Age']")).getText());

        //4. Tablodaki tum datalari yazdirin
        System.out.println(driver.findElement(By.className("web-tables-wrapper")).getText());

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
      List<WebElement> toplamHucreElementList= driver.findElements(By.xpath("((//div[@role='row'])//div[@role='gridcell'])"));
        //System.out.println("toplamHucre = " + toplamHucreElementList.size());
        int sayac=0;
      for (int i = 1; i <=toplamHucreElementList.size() ; i++) {
          WebElement hucre=driver.findElement(By.xpath("(//div[@role='row']//div[@role='gridcell'])["+i+"]"));
            if (hucre.getText().isBlank()){
                sayac++;
            }
        }
        System.out.println(toplamHucreElementList.size()-sayac+" adet hucre bos degil");


        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayiElement=driver.findElements(By.xpath("(//div[@role='rowgroup'])"));
        System.out.println("Satir sayisi: "+satirSayiElement.size());

        //7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunSayiElement=driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println("Sutun sayisi: "+sutunSayiElement.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolonElement=driver.findElements(By.xpath("//div[@role='row']//div[@role='gridcell'][3]"));
        int sira=1;
        for (WebElement each:ucuncuKolonElement
             ) {
            System.out.println(sira+"- "+each.getText());
            sira++;
        }

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("Salary: "+driver.findElement(By.xpath("((//div[@role='row'])[4]/div[@role='gridcell'])[5]")).getText());

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin
        datayazdir(4,5);
    }
    public void datayazdir(int satir,int sutun){
        String dataXpath="((//div[@role='row'])["+satir+"]/div[@role='gridcell'])["+sutun+"]";
        String istenenData=driver.findElement(By.xpath(dataXpath)).getText();
        System.out.println(istenenData);
    }
}
