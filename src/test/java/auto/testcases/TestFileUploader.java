package auto.testcases;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import org.testng.annotations.Test;
import auto.pages.FileDownloaderPage;
import auto.pages.FileUploaderPage;
import auto.pages.WelcomePage;
import auto.utility.Init;

public class TestFileUploader extends Init {

  @Test
  public void testFrame() throws InterruptedException {

    WelcomePage welcomePage = new WelcomePage(driver);
    welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("File Upload");

    FileUploaderPage fileUploaderPage = new FileUploaderPage(driver);
    fileUploaderPage.verifyFileUploaderHeader();
    fileUploaderPage.verifyFileUpload();

    Thread.sleep(5000);
  }


}
