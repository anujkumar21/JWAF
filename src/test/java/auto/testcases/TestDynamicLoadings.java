package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import org.testng.annotations.Test;
import auto.pages.DynamicloadingsPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestDynamicLoadings extends Init {

  @Test
  public void testDynamicLoadingsHidden() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Dynamic Loading");

    DynamicloadingsPage dynamicloadingsPage = new DynamicloadingsPage(driver);
    dynamicloadingsPage.verifyDynamicControlsPageHeader();
    dynamicloadingsPage.clickOnLink("Example 1");
    dynamicloadingsPage.makeHiddenElementVisible();

  }

  @Test
  public void testDynamicLoadingsRender() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Dynamic Loading");

    DynamicloadingsPage dynamicloadingsPage = new DynamicloadingsPage(driver);
    dynamicloadingsPage.verifyDynamicControlsPageHeader();
    dynamicloadingsPage.clickOnLink("Example 2");
    dynamicloadingsPage.renderNewElement();

  }


}
