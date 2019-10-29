package auto.pages;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.utility.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

public class DragAndDropPage extends Services {

    private final static String HEADING = "Drag and Drop";
    private String xpathHeading = "//h3";
    private String xpathA = "//div[@id='column-a']";
    private String xpathB = "//div[@id='column-b']";


    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void verifyDragAndDropPageHeader() {
        waitForElement(xpathHeading);
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void dragAtoB() {
        WebElement eleA = driver.findElement(By.xpath(xpathA));
        WebElement eleB = driver.findElement(By.xpath(xpathB));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(eleA, eleB).build().perform();
        actions.clickAndHold(eleA).moveToElement(eleB).build().perform();
    }
}
