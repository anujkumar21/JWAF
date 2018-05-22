package auto.pages;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 21-May-18
 */

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import auto.utility.Services;

public class DisappearingElementsPage extends Services {

  final static String HEADING = "Disappearing Elements";

  String xpathHeading = "//h3";
  private String xpathMenu = "//ul//li//a";
  private String xpathMenuByTxt = xpathMenu+"[text()='**txt**']";


  public DisappearingElementsPage(WebDriver driver) {
    super(driver);
  }

  public void verifyDisappearingElementsPageHeader() {
    WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
    String actualHeading = headerEle.getText();
    assertEquals(actualHeading, HEADING,
        "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
  }

  
}
