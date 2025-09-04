package automation.threeTests;

import automation.threeTests.pages.NorthpoleLoginPage;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class NorthpoleTests extends AbstractTest {
    private static NorthpoleLoginPage northpolePage;
    private static String EMAIL = ConfProperties.getProperty("NorthpoleEmail");
    private static String PASSWORD = ConfProperties.getProperty("NorthpolePassword");
    private static String LOGIN_TEXT = ConfProperties.getProperty("NorthpoleLoginTestText");
    private static String TOY_SECTION_TEXT = ConfProperties.getProperty("NorthpoleToysSectionTestText");

    @Before
    public void setUpTest() {
        super.setUp();
        northpolePage = new NorthpoleLoginPage(driver);
    }

    @After
    public void tearDownTest() {
        super.shutDown();
    }

    @Test
    public void giftForPets() {
        northpolePage.openGiftIdeasForPets();
        assertEquals("Gift Ideas for Pets", northpolePage.getHeaderText());
    }

    @Test
    public void toysSectionTest() {
        northpolePage.openToySection();
        assertEquals(TOY_SECTION_TEXT,
        northpolePage.getToyText()
        );
    }

    /*@Test
    public void loginTest() {
        northpolePage.login(EMAIL, PASSWORD);
        assertEquals(LOGIN_TEXT, northpolePage.getHeaderText());
    }*/

    private String normalizeText(String text) {
        if (text == null) return null;
        return text.replace("'", "").replace("’", "").trim();
    }

    @Test
    public void loginTest() {
        northpolePage.login(EMAIL, PASSWORD);


        assertEquals(
                normalizeText(LOGIN_TEXT),
                normalizeText(northpolePage.getHeaderText())
        );
    }
}
