package auto.testcases;

import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */
public class TestWelcomePage extends Init {

    @Test
    public void testWelcomePage() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
    }
}
