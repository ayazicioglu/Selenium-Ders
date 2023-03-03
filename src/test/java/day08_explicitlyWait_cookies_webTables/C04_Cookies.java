package day08_explicitlyWait_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void test01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet=driver.manage().getCookies();
        int siraNo=1;
        for (Cookie each:cookiesSet
             ) {
            System.out.println(siraNo+"- "+each.toString());
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSet.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedValue="USD";
        Assert.assertEquals(expectedValue,actualValue);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie benimCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(benimCookie);
        cookiesSet=driver.manage().getCookies();
        siraNo=1;
        for (Cookie each:cookiesSet
             ) {
            System.out.println(siraNo+"- "+each.toString());
            siraNo++;
        }
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        actualValue=driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        expectedValue="cikolatali";
        Assert.assertEquals(expectedValue,actualValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        System.out.println("===========================");
        // olmayan bir elemani test edemem
        // bunun yerine for-each Loop ile ele aldigimiz her cookie'yi kontrol edelim
        // ismi skin olan varsa test failed olsun

        cookiesSet=driver.manage().getCookies();

        for (Cookie each:cookiesSet
        ) {
           Assert.assertFalse(each.getName().equals("skin"));
        }

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.size()==0);
    }
}
