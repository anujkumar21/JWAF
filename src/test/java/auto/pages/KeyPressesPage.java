package auto.pages;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.utility.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

public class KeyPressesPage extends Services {

    private final static String HEADING = "Key Presses";
    private String xpathHeading = "//h3";

    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    public void verifyKeyPressesPageHeader() {
        waitForElement(xpathHeading);
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void pressAnyKey() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.NUMPAD5).build().perform();
    }
}
