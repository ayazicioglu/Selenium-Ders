package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    public static void main(String[] args) throws InterruptedException {
        /* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Antartica
    choose your command  -> Browser Commands
    click submit button
 */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        driver.manage().deleteAllCookies();
        driver.findElement(By.id("cookieChoiceDismiss")).click();

        WebElement firstName=driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        firstName.sendKeys("Ahmet");

        WebElement lastName=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        lastName.sendKeys("Yazicioglu");

        driver.findElement(By.id("sex-0")).click();

        driver.findElement(By.id("exp-2")).click();

       WebElement date= driver.findElement(By.id("datepicker"));
       date.sendKeys("20.02.2023");
       Thread.sleep(1000);

       WebElement prof=driver.findElement(By.id("profession-1"));
       prof.click();
       prof.sendKeys(Keys.PAGE_DOWN);

       driver.findElement(By.id("tool-2")).click();
       Thread.sleep(1000);

       WebElement continent=driver.findElement(By.id("continents"));
       continent.sendKeys(Keys.PAGE_DOWN);
       continent.click();
       driver.findElement(By.xpath("//*[text()='Antartica']")).click();


       driver.findElement(By.xpath("//option[text()='Browser Commands']")).click();
       Thread.sleep(1000);

       driver.findElement(By.name("submit")).click();

       Thread.sleep(2000);
       driver.close();
    }
}
