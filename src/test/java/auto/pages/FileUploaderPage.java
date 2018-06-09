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

public class FileUploaderPage extends Services {

  final static String HEADING = "File Uploader";
  WebDriver driver;
  String xpathHeading = "//h3";
  String xpathChooseFile = "//input[@id='file-upload']";
  String xpathBtn = "//input[@id='file-submit']";
  String xpathResult = "//div[@id='uploaded-files']";


  public FileUploaderPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public FileUploaderPage verifyFileUploaderHeader() {
    WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
    String actualHeading = headerEle.getText();
    assertEquals(actualHeading, HEADING,
        "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    return this;
  }

  public void verifyFileUpload() {

    assertAndType(xpathChooseFile, "E:\\eclipse\\selLearning\\download\\menu.pdf");
    assertAndClick(xpathBtn);
    waitForElement(xpathResult);
    assertEquals("menu.pdf", getWebElement(xpathResult).getText().trim());

  }

}
