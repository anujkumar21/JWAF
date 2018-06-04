package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import org.testng.annotations.Test;
import auto.pages.AlertPage;
import auto.pages.HoverPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestAlert extends Init {

  @Test
  public void testClickForJSAlert() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("JavaScript Alerts");

    AlertPage alertPage = new AlertPage(driver);
    alertPage.verifyAlertPageHeader();
    alertPage.clickOnButton("Click for JS Alert");
    alertPage.accept();

  }

  @Test
  public void testClickForJSConfirm() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("JavaScript Alerts");

    AlertPage alertPage = new AlertPage(driver);
    alertPage.verifyAlertPageHeader();
    alertPage.clickOnButton("Click for JS Confirm");
    alertPage.cancel();


  }

  @Test
  public void testClickForJSPrompt() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("JavaScript Alerts");

    AlertPage alertPage = new AlertPage(driver);
    alertPage.verifyAlertPageHeader();
    alertPage.clickOnButton("Click for JS Prompt");
    alertPage.typeAndAccept();


  }



}
