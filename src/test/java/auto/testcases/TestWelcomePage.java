package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import org.testng.annotations.Test;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestWelcomePage extends Init {

    @Test
    public void testWelcomePage() {
        System.out.println("testMe");
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader();

    }

}
