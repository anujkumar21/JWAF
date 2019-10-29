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
    public void testDropdownPage() throws InterruptedException {
        System.out.println("testMe");
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.verifyDropdownPageHeader();
        //dropdownPage.selectDropDown(1);
        dropdownPage.selectDropDown("Option 2");
        //dropdownPage.selectDropDownByValue("2");
    }
}
