package auto.testcases;

import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestWelcomePage extends Init {

    @Test
    public void testme() {
        System.out.println("testMe");
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle()
                .verifyWelcomePageHeader();

    }

}
