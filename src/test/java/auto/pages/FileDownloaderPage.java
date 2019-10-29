package auto.pages;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import auto.utility.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class FileDownloaderPage extends Services {

    final static String HEADING = "File Downloader";
    WebDriver driver;
    String xpathHeading = "//h3";
    String xpathLink = "//a[text()='some-file.txt']";


    public FileDownloaderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyFileDownloaderHeader() {
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void verifyFileDownload() {
        click(xpathLink);
    }
}
