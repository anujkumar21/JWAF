package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import org.testng.annotations.Test;
import auto.pages.FramesPage;
import auto.pages.LoginPage;
import auto.pages.MultipleWindowsPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestMultipleWindows extends Init {

  @Test
  public void testFrame() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Multiple Windows");

    MultipleWindowsPage multipleWindowsPage = new MultipleWindowsPage(driver);
    multipleWindowsPage.verifyMultipleWindowsPageHeader();
    multipleWindowsPage.clickOnLink();
    Thread.sleep(3000);
    multipleWindowsPage.getTextOnNewWindow();

  }



}
