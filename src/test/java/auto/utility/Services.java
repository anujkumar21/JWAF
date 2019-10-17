package auto.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 14-May-18
 * Time: 8:19 PM
 */

public class Services {
    private static Logger logger = Logger.getLogger(Services.class.getName());
    protected WebDriver driver;

    public Services(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    protected void assertAndClick(String locator) {
        assertElementPresentByXpath(locator);
        driver.findElement(By.xpath(locator)).click();
    }

    protected void assertAndType(String locator, String text) {
        assertElementPresentByXpath(locator);
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    protected void assertElementPresentByXpath(String locator) {
        logger.info("# Verifying element.");
        assertTrue(isElementPresent(locator), "Element " + locator + " not found.");
    }

    protected void assertElementNotPresentByXpath(String locator) {
        logger.info("# Verifying element.");
        assertFalse(isElementPresent(locator), "Element " + locator + " is found.");
    }

    protected boolean isElementPresent(String locator) {
        try {
            driver.findElement(By.xpath(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isElementVisible(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void assertElementVisible(String locator, boolean isVisible) {
        logger.info("# Verifying element visibility.");
        if (isVisible)
            assertTrue(isElementVisible(locator), "Element " + locator + " should be visible.");
        else
            assertFalse(isElementVisible(locator), "Element " + locator + " should not be visible.");
    }

    protected void waitForElementVisible(String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitForElementInVisible(String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    protected WebElement getWebElement(String xpath) {
        return driver.findElement(By.xpath(xpath));

    }
}
