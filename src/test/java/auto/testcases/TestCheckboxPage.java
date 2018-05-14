package auto.testcases;

/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 12-May-18
 */

import auto.pages.CheckboxesPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestCheckboxPage extends Init {

  @Test
  public void testCheckboxPage() throws InterruptedException {
    System.out.println("testMe");
    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Checkboxes");

    CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
    checkboxesPage.verifyCheckboxPageHeader().clickOnCheckbox(3);
  }

  @Test
  public void testCheckboxViaSmartWay() throws InterruptedException {
    System.out.println("testMe");
    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Checkboxes");

    CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
    checkboxesPage.verifyCheckboxPageHeader().clickOnCheckbox(2, false);

    Thread.sleep(5000);
  }

  @Test
  public void testToSelectAllCheckboxes() throws InterruptedException {
    System.out.println("testMe");
    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Checkboxes");

    CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
    checkboxesPage.verifyCheckboxPageHeader().toSelectAllCheckboxes(false);

    Thread.sleep(5000);
  }

}
