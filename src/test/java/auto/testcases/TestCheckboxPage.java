package auto.testcases;

import auto.pages.CheckboxesPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

public class TestCheckboxPage extends Init {

    @Test
    public void testCheckboxPage() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Checkboxes");

        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.verifyCheckboxPageHeader().clickOnCheckbox(3);
    }

    @Test
    public void testCheckboxViaSmartWay() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Checkboxes");

        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.verifyCheckboxPageHeader().clickOnCheckbox(2, false);
    }

    @Test
    public void testToSelectAllCheckboxes() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Checkboxes");

        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.verifyCheckboxPageHeader().toSelectAllCheckboxes(false);
    }

}
