package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.pages.DynamicControlsPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestDynamicControls extends Init {

    @Test
    public void testDynamicControlsRemove() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Dynamic Controls");

        DynamicControlsPage controlsPage = new DynamicControlsPage(driver);
        controlsPage.verifyDynamicControlsPageHeader();
        controlsPage.verifyRemove();
    }

    @Test
    public void testDynamicControlsAdd() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Dynamic Controls");

        DynamicControlsPage controlsPage = new DynamicControlsPage(driver);
        controlsPage.verifyDynamicControlsPageHeader();
        controlsPage.verifyAdd();
    }
}
