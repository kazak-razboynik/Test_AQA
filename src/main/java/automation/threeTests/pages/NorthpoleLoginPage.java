package automation.threeTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NorthpoleLoginPage {
    private final WebDriver driver;

    private static final By CHRISTMAS_GIFT_IDEAS_BTN = By.xpath("//*[@id='home-giving']/div[1]/a[1]");
    private static final By PETS_BTN = By.xpath("//*[@id='GScontain1']/div[4]/a/img");
    private static final By CONTENT_HEADER = By.xpath("//*[@id='content']/h1");

    private static final By TOY_CANVAS = By.xpath("//*[@id='swiffycontainer']/div/canvas");
    private static final By TOY_TEXT = By.xpath("//*[@id='content']/p[1]");

    private static final By LOGIN_BTN = By.xpath("//*[@id='home-login']/a[2]");
    private static final By EMAIL_FIELD = By.name("email");
    private static final By PASSWORD_FIELD = By.name("password");
    private static final By SUBMIT_LOGIN = By.xpath("//*[@id='adultlogin']/form/table/tbody/tr[3]/td[2]/a/img");

    public NorthpoleLoginPage(WebDriver driver) {
    this.driver = driver;
    }

    public NorthpoleLoginPage openGiftIdeasForPets() {
        driver.findElement(CHRISTMAS_GIFT_IDEAS_BTN).click();
        driver.findElement(PETS_BTN).click();
        return this;
    }

    public String getHeaderText() {
        return driver.findElement(CONTENT_HEADER).getText();
    }

    public NorthpoleLoginPage openToySection() {
        WebElement canvas = driver.findElement(TOY_CANVAS);
        new Actions(driver).moveToElement(canvas, 238, 0).click().perform();
        return this;
    }

    public String getToyText() {
        return driver.findElement(TOY_TEXT).getText();
    }

    public NorthpoleLoginPage login(String email, String password) {
        driver.findElement(LOGIN_BTN).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(SUBMIT_LOGIN).click();
        return this;
    }
}

