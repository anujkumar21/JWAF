package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.pages.DynamicloadingsPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestDynamicLoadings extends Init {

    @Test
    public void testDynamicLoadingsHidden() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Dynamic Loading");

        DynamicloadingsPage dynamicloadingsPage = new DynamicloadingsPage(driver);
        dynamicloadingsPage.verifyDynamicControlsPageHeader();
        dynamicloadingsPage.clickOnLink("Example 1");
        dynamicloadingsPage.makeHiddenElementVisible();

    }

    @Test
    public void testDynamicLoadingsRender() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Dynamic Loading");

        DynamicloadingsPage dynamicloadingsPage = new DynamicloadingsPage(driver);
        dynamicloadingsPage.verifyDynamicControlsPageHeader();
        dynamicloadingsPage.clickOnLink("Example 2");
        dynamicloadingsPage.renderNewElement();

    }


}
