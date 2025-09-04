package automation.threeTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    public static WebDriver driver;

    public static String URL = ConfProperties.getProperty("northpole");
    public static String WEBDRIVER = ConfProperties.getProperty("chromedriver");

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", WEBDRIVER);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(URL);
    }

    @AfterClass
    public static void shutDown() {
        driver.quit();
    }
}
