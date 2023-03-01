package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class C05_DinamikDosyaYolu {
    @Test
    public void test01(){
        String dosyaYolu=System.getProperty("user.home")+"/Desktop/TheDelta.docx";
        Assert.assertTrue(Files.exists(Path.of(dosyaYolu)));
    }
}
