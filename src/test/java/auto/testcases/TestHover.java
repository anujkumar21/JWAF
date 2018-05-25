package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import org.testng.annotations.Test;
import auto.pages.HoverPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestHover extends Init {

  @Test
  public void testFrame() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Hovers");

    HoverPage hoverPage = new HoverPage(driver);
    hoverPage.verifyHoversPageHeader();
    hoverPage.hoverOnImage();

  }



}
