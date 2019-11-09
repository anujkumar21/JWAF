package auto.testcases;

import auto.pages.FileDownloaderPage;
import auto.pages.WelcomePage;
import auto.utility.Init;
import org.testng.annotations.Test;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */
public class TestFileDownloader extends Init {

    @Test
    public void testFrame() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle();
        welcomePage.verifyWelcomePageHeader();
        welcomePage.clickOnLink("File Download");

        FileDownloaderPage downloaderPage = new FileDownloaderPage(driver);
        downloaderPage.verifyFileDownloaderHeader();
        downloaderPage.verifyFileDownload();
    }
}
