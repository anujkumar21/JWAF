package auto.testcases;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.pages.FileUploaderPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestFileUploader extends Init {

    @Test
    public void testFrame() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("File Upload");

        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver);
        fileUploaderPage.verifyFileUploaderHeader();
        fileUploaderPage.verifyFileUpload();
    }
}
