package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import auto.pages.ChallengingDomPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestChallengingDomPage extends Init {

    @Test
    public void testChallengingPage() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Challenging DOM");

        ChallengingDomPage challengingDomPage = new ChallengingDomPage(driver);
        challengingDomPage.verifyChallengingDomPageHeader();
        challengingDomPage.getAllButtonText();
        challengingDomPage.clickOnFirstButton();

        System.out.println(challengingDomPage.getColumnIndex("Sit"));

        System.out.println(challengingDomPage.getCellText(3, "Sit"));
    }
}
