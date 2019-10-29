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

import static auto.pages.LoginPage.MSG_SUCCESS;
import static org.testng.Assert.assertTrue;

public class TestLogin extends Init {

    @Test
    public void testLoginUsingXpath() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();

        // loginAction method - in which xpath is used as locator
        loginPage.loginAction("tomsmith", "SuperSecretPassword!");

        String actualMsg = loginPage.getMsgSuccess();
        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");
    }


    @Test
    public void testLoginUsingCssSelector() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();

        // loginActionUsingCssSelector method - in which cssSelector is used as locator
        loginPage.loginActionUsingCssSelector("tomsmith", "SuperSecretPassword!");

        String actualMsg = loginPage.getMsgSuccess();
        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");
    }

    @Test
    public void testLoginByJava8Way() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();

        // loginActionJava8 method - in which we can use any way XPATH or CSS or ID etc.
        loginPage.loginActionJava8("tomsmith", "SuperSecretPassword!");

        String actualMsg = loginPage.getMsgSuccess();
        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");
    }

    @Test(enabled = false)
    public void testLoginWithInvalidUser() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();
        loginPage.verifyLoginWithInvalidUser("abc", "abc");
    }
}
