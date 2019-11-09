package auto.testcases;

import auto.pages.HorizontalSliderPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */
public class TestHorizontalSlider extends Init {

    @Test
    public void testFrame() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("Horizontal Slider");

        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage(driver);
        horizontalSliderPage.verifyHorizontalSliderPageHeader();
        horizontalSliderPage.horizontalSlide();
    }
}
