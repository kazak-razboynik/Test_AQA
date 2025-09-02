package automation.threeTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class LoginPage {
    private static final By FIRST_NAME_FIELD = By.name("name");
    private static final By EMAIL_FIELD = By.name("email");
    private static final By MOBILE_FIELD = By.name("mobile");
    private static final By FEMALE_GENDER_BUTTON = By.xpath("//label[text()='Female']/preceding-sibling::input");
    private static final By TITLE = By.xpath("//h1");
    private static final By BIRTHDATE_FIELD = By.name("dob");
    private static final By SUBJECT_FIELD = By.xpath("//*[@id=\"subjects\"]");
    private static final By MUSIC_BUTTON = By.xpath("//label[text()='Music']/preceding-sibling::input");
    private static final By PICTURE_FIELD = By.xpath("//*[@id=\"picture\"]");
    private static final By ADDRESS_FIELD = By.xpath("/html/body/main/div/div/div[2]/form/div[9]/div/textarea");
    private static final By STATE_BUTTON = By.xpath("/html/body/main/div/div/div[2]/form/div[10]/div/div[1]/select");
    private static final By CITY_BUTTON = By.xpath("/html/body/main/div/div/div[2]/form/div[10]/div/div[2]/select");
    private static final By STATE_NCR_BUTTON = By.xpath("/html/body/main/div/div/div[2]/form/div[10]/div/div[1]/select/option[2]");
    private static final By CITY_AGRA_BUTTON = By.xpath("/html/body/main/div/div/div[2]/form/div[10]/div/div[2]/select/option[2]");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter First Name")
    public LoginPage inputFirstName(String name) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(name);
        return this;
    }

    @Step("Enter Email")
    public LoginPage inputEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        return this;
    }

    @Step("Click Female gender button")
    public LoginPage clickFemaleButtom() {
        driver.findElement(FEMALE_GENDER_BUTTON).click();
        return this;
    }

    @Step("Get Title")
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Enter Mobile number")
    public LoginPage inputMobile(String mobile) {
        driver.findElement(MOBILE_FIELD).sendKeys(mobile);
        return this;
    }

    @Step("Enter Birthdate")
    public LoginPage inputDate(String birthdate) {
        driver.findElement(BIRTHDATE_FIELD).sendKeys(birthdate);
        return this;
    }

    @Step("Enter Subject")
    public LoginPage inputSubject(String subject) {
        driver.findElement(SUBJECT_FIELD).sendKeys(subject);
        return this;
    }

    @Step("Click checkbox Music button")
    public LoginPage clickMusicButtom() {
        driver.findElement(MUSIC_BUTTON).click();
        return this;
    }

    @Step("Enter Picture")
    public LoginPage inputPicture(String picture) {
        driver.findElement(PICTURE_FIELD).sendKeys(picture);
        return this;
    }

    @Step("Enter Address")
    public LoginPage inputAddress(String address) {
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
        return this;
    }

    @Step("Click State - NCR")
    public LoginPage clickState() {
        driver.findElement(STATE_BUTTON).click();
        driver.findElement(STATE_NCR_BUTTON).click();
        return this;
    }

    @Step("Click City - Agra")
    public LoginPage clickCity() {
        driver.findElement(CITY_BUTTON).click();
        driver.findElement(CITY_AGRA_BUTTON).click();
        return this;
    }
}
