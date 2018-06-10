package auto.pages;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 12-May-18
 */

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import auto.utility.Services;

public class FileDownloaderPage extends Services {

  final static String HEADING = "File Downloader";
  WebDriver driver;
  String xpathHeading = "//h3";
  String xpathLink = "//a[text()='some-file.txt']";


  public FileDownloaderPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public FileDownloaderPage verifyFileDownloaderHeader() {
    WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
    String actualHeading = headerEle.getText();
    assertEquals(actualHeading, HEADING,
        "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    return this;
  }

  public void verifyFileDownload() {

    assertAndClick(xpathLink);

  }

}
