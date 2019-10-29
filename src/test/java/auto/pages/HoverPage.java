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

public class HoverPage extends Services {

    private final static String HEADING = "Hovers";
    private String xpathHeading = "//h3";

    private String xpathImage1 = "//div[@class='figure'][2]";
    private String xpathName1 = xpathImage1 + "//div[@class='figcaption']/h5";

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    public void verifyHoversPageHeader() {
        waitForElement(xpathHeading);
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void hoverOnImage() {
        WebElement img1 = driver.findElement(By.xpath(xpathImage1));
        Actions actions = new Actions(driver);
        actions.moveToElement(img1).build().perform();
        waitForElementVisible(xpathName1);
        assertElementPresentByXpath(xpathName1);
        System.out.println(driver.findElement(By.xpath(xpathName1)).getText());
    }
}
