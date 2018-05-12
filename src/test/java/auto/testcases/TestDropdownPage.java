package auto.testcases;

import auto.pages.DropdownPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestDropdownPage extends Init {

    @Test
    public void testme() {
        System.out.println("testMe");
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.verifyDropdownPageHeader();


    }

}
