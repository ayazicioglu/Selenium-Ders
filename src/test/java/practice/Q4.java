package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q4 {
    public static void main(String[] args) throws InterruptedException {
         /* ...Exercise4...
            Navigate to  https://testpages.herokuapp.com/styled/index.html
            Click on  Calculater under Micro Apps
            Type any number in the first input
            Type any number in the second input
            Click on Calculate
            Get the result
            Print the result
     */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.id("calculatetest")).click();

        WebElement first=driver.findElement(By.id("number1"));
        WebElement second=driver.findElement(By.id("number2"));

        first.sendKeys("25");
        second.sendKeys("75");

        driver.findElement(By.id("calculate")).click();

        WebElement sonucElement=driver.findElement(By.id("answer"));

        System.out.println(sonucElement.getText());

        Thread.sleep(1000);
        driver.close();


    }
}
