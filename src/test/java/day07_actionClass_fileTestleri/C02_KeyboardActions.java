package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {
    //1- Bir Class olusturalim KeyboardActions1
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve
    //Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin

    @Test
    public void test01(){
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).keyDown(Keys.SHIFT).sendKeys("s").keyUp(Keys.SHIFT).
                sendKeys("amsung ").keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("71").sendKeys(Keys.ENTER).perform();
        bekle(3);

        //4- aramanin gerceklestigini test edin
        String actualAramaSonucYazi=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String expectedIcerik="Samsung A71";
        Assert.assertTrue(actualAramaSonucYazi.contains(expectedIcerik));

    }
}
