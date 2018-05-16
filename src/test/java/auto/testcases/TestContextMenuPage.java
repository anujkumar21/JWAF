package auto.testcases;
/**
 * Created by: Anuj Kumar 
 * Email: cdac.anuj@gmail.com 
 * Date: 16-May-18
 */

import org.testng.annotations.Test;
import auto.pages.ContextMenuPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestContextMenuPage extends Init {

  @Test
  public void testChallengingPage() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Context Menu");

    ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
    contextMenuPage.verifyContextMenuPageHeader();
    contextMenuPage.verifyContextMenu();

  }

}
