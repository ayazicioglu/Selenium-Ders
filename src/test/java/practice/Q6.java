package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q6 {

    @BeforeClass
    public static void setup(){
        System.out.println("Before Class");
    }

    @AfterClass
    public static void teardown(){
        System.out.println("After Class");
    }

    @Before
    public void before(){
        System.out.println("Before");
    }

    @After
    public void after(){
        System.out.println("After");
    }

    @Test
    public void ahmet(){

        System.out.println("Ahmet");
    }

    @Test
    public void betul(){
        System.out.println("Betul");
    }

    @Test
    public void cengiz(){
        System.out.println("Cengiz");
    }
}
