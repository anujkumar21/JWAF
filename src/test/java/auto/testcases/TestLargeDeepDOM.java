package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import org.testng.annotations.Test;
import auto.pages.LargeDeepDOMPage;
import auto.pages.LoginPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestLargeDeepDOM extends Init {

  @Test
  public void testLargeDeepDOM() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Large & Deep DOM");
    
    LargeDeepDOMPage deepDOMPage = new LargeDeepDOMPage(driver);
    deepDOMPage.verifyLargeDeepDOMPageHeader();
    deepDOMPage.getLargeDOMText();
    
    deepDOMPage.getParent("2.3");
    deepDOMPage.getAncestor("2.3");


  }



}
