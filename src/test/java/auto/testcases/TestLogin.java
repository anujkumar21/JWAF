package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.pages.LoginPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestLogin extends Init {

    @Test
    public void testLogin() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader()
                .clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();
        loginPage.verifyLogin("tomsmith", "SuperSecretPassword!");
    }

    @Test
    public void testLoginWithInvalidUser() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader()
                .clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();
        loginPage.verifyLoginWithInvalidUser("abc", "abc");
    }
}
