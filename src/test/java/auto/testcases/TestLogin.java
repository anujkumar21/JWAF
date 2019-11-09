package auto.testcases;

import auto.pages.LoginPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static auto.pages.LoginPage.MSG_SUCCESS;
import static org.testng.Assert.assertTrue;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */
public class TestLogin extends Init {

    @DataProvider
    public static Object[][] validCredentials() {
        return new Object[][]{{"tomsmith", "SuperSecretPassword!"}};
    }

    @DataProvider
    public static Object[][] invalidCredentials() {
        return new Object[][]{{"abc", "abc"}};
    }

    @Test(dataProvider = "validCredentials")
    public void testLoginUsingXpath(String username, String password) {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();

        // loginAction method - in which xpath is used as locator
        loginPage.loginAction(username, password);

        String actualMsg = loginPage.getMsgSuccess();
        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");
    }


    @Test(dataProvider = "validCredentials")
    public void testLoginUsingCssSelector(String username, String password) {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();

        // loginActionUsingCssSelector method - in which cssSelector is used as locator
        loginPage.loginActionUsingCssSelector(username, password);

        String actualMsg = loginPage.getMsgSuccess();
        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");
    }

    @Test(dataProvider = "validCredentials")
    public void testLoginByJava8Way(String username, String password) {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();

        // loginActionJava8 method - in which we can use any way XPATH or CSS or ID etc.
        loginPage.loginActionJava8(username, password);

        String actualMsg = loginPage.getMsgSuccess();
        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");
    }

    @Test(dataProvider = "invalidCredentials")
    public void testLoginWithInvalidUser(String username, String password) {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();
        loginPage.verifyLoginWithInvalidUser(username, password);
    }
}
