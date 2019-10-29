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

import static org.testng.Assert.assertEquals;

public class DynamicControlsPage extends Services {

    private final static String HEADING = "Dynamic Controls";
    private String xpathHeading = "//h4";
    private String xpathBtn = "//button[@id='btn']";
    private String xpathCheckbox = "//div[@id='checkbox']";
    private String xpathLoading = "//div[@id='loading']";


    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyDynamicControlsPageHeader() {
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void verifyRemove() {
        assertElementPresentByXpath(xpathCheckbox);
        click(xpathBtn);
        waitForLoading();
        assertElementNotPresentByXpath(xpathCheckbox);
    }

    public void verifyAdd() {
        verifyRemove();
        click(xpathBtn);
        waitForLoading();
        assertElementPresentByXpath(xpathCheckbox);
    }

    private void waitForLoading() {
        waitForElement(xpathLoading);
        waitForElementVisible(xpathLoading);
        assertElementVisible(xpathLoading, true);
        waitForElementInVisible(xpathLoading);
        assertElementVisible(xpathLoading, false);
    }
}
