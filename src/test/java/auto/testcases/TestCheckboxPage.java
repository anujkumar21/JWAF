package auto.testcases;

import auto.pages.CheckboxesPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestCheckboxPage extends Init {

    @Test
    public void testme() {
        System.out.println("testMe");
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Checkboxes");

        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        checkboxesPage.verifyCheckboxPageHeader().clickOnCheckbox(2);
    }

}
