package auto.testcases;

import auto.pages.FramesPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */
public class TestFrame extends Init {

    @Test
    public void testFrame() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Frames");

        FramesPage framesPage = new FramesPage(driver);
        framesPage.verifyFramesPageHeader();
        framesPage.clickOnLink("Nested Frames");
        framesPage.getFrameText();
    }

    @Test
    public void testIFrame() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Frames");

        FramesPage framesPage = new FramesPage(driver);
        framesPage.verifyFramesPageHeader();
        framesPage.clickOnLink("iFrame");
        framesPage.getIFrame();
    }
}
