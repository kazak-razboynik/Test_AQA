package automation.threeTests;

import automation.threeTests.pages.NorthpoleLoginPagePage;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NorthpoleTests extends AbstractTest {
    private static NorthpoleLoginPagePage northpolePage;

    @BeforeClass
    public static void initPage() {
        northpolePage = new NorthpoleLoginPagePage(driver);
    }

    @Test
    public void giftForPets() {
        northpolePage.openGiftIdeasForPets();
        assertEquals("Gift Ideas for Pets", northpolePage.getHeaderText());
    }

    @Test
    public void toysSectionTest() {
        northpolePage.openToySection();
        assertEquals(
                "I’m the elf in charge of the Toy Shop, and I can help you find toys! " +
                        "Just click on one of our three toy shelves: Unique, Popular, or Educational Toys to see toys in these or other categories.",
                northpolePage.getToyText()
        );
    }

    @Test
    public void loginTest() {
        northpolePage.login("hhh.hhh96@yandex.ru", "Colos");
        assertEquals("Hello, Oleg! What would you like to do?", northpolePage.getHeaderText());
    }
}
