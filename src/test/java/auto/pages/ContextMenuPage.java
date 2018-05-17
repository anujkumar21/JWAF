package auto.pages;
/**
 * Created by: Anuj Kumar 
 * Email: cdac.anuj@gmail.com 
 * Date: 16-May-18
 */

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import auto.utility.Services;

public class ContextMenuPage extends Services {

  private final static String HEADING = "Context Menu";
  private String xpathHeading = "//h3";
  private String xpathHotSpot = "//div[@id='hot-spot']";

  public ContextMenuPage(WebDriver driver) {
    super(driver);
  }

  public void verifyContextMenuPageHeader() {
    WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
    String actualHeading = headerEle.getText();
    assertEquals(actualHeading, HEADING,
        "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
  }


  public void verifyContextMenu() throws InterruptedException {

    waitForElement(xpathHotSpot);
    WebElement hotSpotEle = driver.findElement(By.xpath(xpathHotSpot));

    Actions actions = new Actions(driver);

    actions.contextClick(hotSpotEle).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ENTER).build().perform();

    Thread.sleep(2000);
    Alert alert = driver.switchTo().alert();                
    alert.accept();

  }


}
