package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.pages.AlertPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestAlert extends Init {

    @Test(groups = {"smoke", "regression"})
    public void testClickForJSAlert() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("JavaScript Alerts");

        AlertPage alertPage = new AlertPage(driver);
        alertPage.verifyAlertPageHeader();
        alertPage.clickOnButton("Click for JS Alert");
        alertPage.accept();

    }

    @Test(groups = {"regression"})
    public void testClickForJSConfirm() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("JavaScript Alerts");

        AlertPage alertPage = new AlertPage(driver);
        alertPage.verifyAlertPageHeader();
        alertPage.clickOnButton("Click for JS Confirm");
        alertPage.cancel();
    }

    @Test(groups = {"alert"})
    public void testClickForJSPrompt() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("JavaScript Alerts");

        AlertPage alertPage = new AlertPage(driver);
        alertPage.verifyAlertPageHeader();
        alertPage.clickOnButton("Click for JS Prompt");
        alertPage.typeAndAccept();
    }
}
