package day07_actionClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {
    @Test
    public void test01(){


        // bilgisayarimizin temel dosya yolu user.home

        //C:\Users\Ahmet Yazıcıoğlu\Desktop\TheDelta
        // /Users/ahmetbulutluoz/Desktop/Thedelta.docx
        //C:\Users\FURKAN\Desktop\TheDelta.docx"
        //C:\Users\Lenovo\Desktop\TheDelta.docx


        // icinde bulundugumuz projenin temel dosya yolu user.dir
        //C:\Users\Ahmet Yazıcıoğlu\IdeaProjects\seleniumTeam108\src\test\java\day07_actionClass_fileTestleri\text.txt

        String dosyaYolu="C:\\Users\\Ahmet Yazıcıoğlu\\Desktop\\TheDelta.docx";
        boolean sonuc= Files.exists(Paths.get(dosyaYolu));
        System.out.println("sonuc = " + sonuc);



        /*
            Bilgisayarimizda bir dosyanin var oldugunu test etmek icin
            dosya yoluna ihtiyacimiz var
            Ancak herkesin bilgisayarindaki dosya yollari
            farkliliklar gosterir
            herkesin bilgisayarina gore farkli olan kismi
            java'dan bir komut ile elde edebiliriz
         */

        System.out.println(System.getProperty("user.home")); //ana dosya yolu'nu yazdırır: C:\Users\Ahmet Yazıcıoğlu

        dosyaYolu=System.getProperty("user.home")+"\\Desktop\\TheDelta.docx";

        System.out.println(System.getProperty("user.dir"));
    }
}
