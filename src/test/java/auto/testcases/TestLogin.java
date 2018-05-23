package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import org.testng.annotations.Test;
import auto.pages.LoginPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestLogin extends Init {

  @Test
  public void testLogin() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader()
        .clickOnLink("Form Authentication");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.verifyLoginPageHeader();
    loginPage.verifyLogin("tomsmith", "SuperSecretPassword!");
  }

  @Test
  public void testLoginWithInvalidUser() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader()
        .clickOnLink("Form Authentication");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.verifyLoginPageHeader();
    loginPage.verifyLoginWithInvalidUser("abc", "abc");
  }



}
