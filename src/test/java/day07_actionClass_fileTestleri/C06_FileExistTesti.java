package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C06_FileExistTesti extends TestBase {
    @Test
    public void test01(){

        //user.home
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        //3. logo.png dosyasını indirelim
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim



        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. logo.png dosyasını indirelim
        driver.findElement(By.linkText("logo.png")).click();
        bekle(5);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dinamikDosyaYolu=System.getProperty("user.home")+"/Downloads/logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));



    }
}
