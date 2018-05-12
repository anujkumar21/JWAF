package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import auto.pages.DropdownPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestDropdownPage extends Init {

    @Test
    public void testDropdownPage() {
        System.out.println("testMe");
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.verifyDropdownPageHeader();


    }

}
