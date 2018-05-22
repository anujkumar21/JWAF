package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */ 

import org.testng.annotations.Test;
import auto.pages.DisappearingElementsPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestDisappearingElementsPage extends Init {

  @Test
  public void testChallengingPage() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader()
        .clickOnLink("Disappearing Elements");

    DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage(driver);
    disappearingElementsPage.verifyDisappearingElementsPageHeader();
    Thread.sleep(5000);

  }

}
