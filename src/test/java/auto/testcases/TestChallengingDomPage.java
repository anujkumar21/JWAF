package auto.testcases;

import auto.pages.ChallengingDomPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */
public class TestChallengingDomPage extends Init {

    @Test
    public void testChallengingPage() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Challenging DOM");

        ChallengingDomPage challengingDomPage = new ChallengingDomPage(driver);
        challengingDomPage.verifyChallengingDomPageHeader();
    }

    @Test
    public void testListOfButtons() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Challenging DOM");

        ChallengingDomPage challengingDomPage = new ChallengingDomPage(driver);
        challengingDomPage.verifyChallengingDomPageHeader();
        List<String> buttons = challengingDomPage.getAllButtonText();
        assertEquals(buttons.size(), 3);
    }

    @Test
    public void testChallengingPageViaJava8() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Challenging DOM");

        ChallengingDomPage challengingDomPage = new ChallengingDomPage(driver);
        challengingDomPage.verifyChallengingDomPageHeader();
        List<String> lst = challengingDomPage.getAllButtonTextJava8();
        System.out.println(lst);
        assertEquals(lst.size(), 3);
    }

    @Test
    public void testCellText() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Challenging DOM");

        ChallengingDomPage challengingDomPage = new ChallengingDomPage(driver);
        challengingDomPage.verifyChallengingDomPageHeader();

        assertEquals(challengingDomPage.getCellText(3, "Sit"), "Definiebas2");
    }
}
