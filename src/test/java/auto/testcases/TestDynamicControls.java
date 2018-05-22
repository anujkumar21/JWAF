package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */ 

import org.testng.annotations.Test;
import auto.pages.DynamicControlsPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestDynamicControls extends Init {

  @Test
  public void testDynamicControlsRemove() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Dynamic Controls");

    DynamicControlsPage controlsPage = new DynamicControlsPage(driver);
    controlsPage.verifyDynamicControlsPageHeader();
    controlsPage.verifyRemove();

  }

  @Test
  public void testDynamicControlsAdd() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Dynamic Controls");

    DynamicControlsPage controlsPage = new DynamicControlsPage(driver);
    controlsPage.verifyDynamicControlsPageHeader();
    controlsPage.verifyAdd();

  }

}
