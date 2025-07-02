package automation.threeTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class NorthpoleTests {

    @Test

    public void giftForPets(){
        //подключаем хромдрайвер
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");
        //запустить браузер
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        //переход на сайт
        driver.get("https://www.northpole.com/");

        //нажимаем кнопку "Christmas Gift Ideas"
        driver.findElement(By.xpath("//*[@id=\"home-giving\"]/div[1]/a[1]"))
                .click();
        //нажимаем кнопку "Pets"
        driver.findElement(By.xpath("//*[@id=\"GScontain1\"]/div[4]/a/img"))
                .click();
        //Проверка ожидаемого (Hello, Lelele! What would you like to do?)
        assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText(), "Gift Ideas for Pets");
        //закрыть браузер
        driver.quit();
    }

    @Test

    public void toysSectionTest(){
        //подключаем хромдрайвер
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

        //запустить браузер
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //переход на сайт
        driver.get("https://www.northpole.com/");

        WebElement canvas = driver.findElement(By.xpath("//*[@id='swiffycontainer']/div/canvas"));

        Actions actions = new Actions(driver);

        // Переместиться к элементу <canvas> с нужным смещением и кликнуть
        actions.moveToElement(canvas, 238, 0).click().perform();

        //Проверка ожидаемого
        assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText(),
                "I’m the elf in charge of the Toy Shop, and I can help you find toys! Just click on one of our three toy shelves: Unique, Popular, or Educational Toys to see toys in these or other categories.");
        //закрыть браузер
        driver.quit();
    }

    @Test

    public void loginTest(){
        //подключаем хромдрайвер
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver.exe");

        //запустить браузер
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //переход на сайт
        driver.get("https://www.northpole.com/");

        //нажать на “Parent / Adult Log In“
        driver.findElement(By.xpath("//*[@id=\"home-login\"]/a[2]")).click();
        //вводим email
        driver.findElement(By.name("email")).sendKeys("hhh.hhh96@yandex.ru");
        //вводим пароль
        driver.findElement(By.name("password")).sendKeys("Colos");
        //нажать на "Log In"
        driver.findElement(By.xpath("//*[@id=\"adultlogin\"]/form/table/tbody/tr[3]/td[2]/a/img")).click();
        //Проверка ожидаемого
        assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText(), "Hello, Oleg! What would you like to do?");
        //закрыть браузер
        driver.quit();
    }

}
