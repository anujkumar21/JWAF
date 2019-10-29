package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.pages.HoverPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestHover extends Init {

    @Test
    public void testFrame() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Hovers");

        HoverPage hoverPage = new HoverPage(driver);
        hoverPage.verifyHoversPageHeader();
        hoverPage.hoverOnImage();
    }
}
