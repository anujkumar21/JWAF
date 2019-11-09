package auto.testcases;

import auto.pages.KeyPressesPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */
public class TestKeyPresses extends Init {

    @Test
    public void testKeyPresses() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Key Presses");

        KeyPressesPage keyPressesPage = new KeyPressesPage(driver);
        keyPressesPage.verifyKeyPressesPageHeader();
        keyPressesPage.pressAnyKey();
    }
}
