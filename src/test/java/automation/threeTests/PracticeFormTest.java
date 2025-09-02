package automation.threeTests;

import automation.threeTests.pages.LoginPage;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PracticeFormTest extends AbstractTest {
    public static String NAME = ConfProperties.getProperty("name");
    public static String EMAIL = ConfProperties.getProperty("email");
    public static String MOBILE = ConfProperties.getProperty("mobile");
    public static String DATE = ConfProperties.getProperty("date");
    public static String SUBJECT = ConfProperties.getProperty("subject");
    public static String PICTURE = ConfProperties.getProperty("picture");
    public static String ADDRESS = ConfProperties.getProperty("address");

    public static LoginPage loginPage;

    @BeforeClass
    public static void preconditions() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() {
        loginPage.inputFirstName(NAME)
                .inputEmail(EMAIL)
                .clickFemaleButtom()
                .inputMobile(MOBILE)
                .inputDate(DATE)
                .inputSubject(SUBJECT)
                .clickMusicButtom()
                .inputPicture(PICTURE)
                .inputAddress(ADDRESS)
                .clickState()
                .clickCity();
        assertEquals("Title is not expected",
                "Selenium - Automation Practice Form",
                loginPage.getTitle());
    }
}
