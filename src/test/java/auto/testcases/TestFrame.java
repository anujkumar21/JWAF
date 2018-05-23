package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import org.testng.annotations.Test;
import auto.pages.FramesPage;
import auto.pages.LoginPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestFrame extends Init {

  @Test
  public void testFrame() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Frames");

    FramesPage framesPage = new FramesPage(driver);
    framesPage.verifyFramesPageHeader();
    framesPage.clickOnLink("Nested Frames");
    framesPage.getFrameText();

  }


  @Test
  public void testIFrame() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Frames");

    FramesPage framesPage = new FramesPage(driver);
    framesPage.verifyFramesPageHeader();
    framesPage.clickOnLink("iFrame");
    framesPage.getIFrame();

  }


}
