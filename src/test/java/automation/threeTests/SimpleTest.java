package automation.threeTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SimpleTest {
    @Test()
    public void loginTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");

        driver.findElement(By.name("name")).sendKeys("Masha Kot");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.xpath("//label[text()='Female']/preceding-sibling::input")).click();
        assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Selenium - Automation Practice Form");
        driver.quit();
    }
}
