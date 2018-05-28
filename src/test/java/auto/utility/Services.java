package auto.utility;

/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 14-May-18 Time: 8:19 PM
 */
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Services {

  protected WebDriver driver;

  public Services(WebDriver driver) {
    this.driver = driver;
  }

  public void waitForElement(String locator) {

    new WebDriverWait(driver, 20)
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
  }

  public void assertAndClick(String locator) {

    assertElementPresentByXpath(locator);
    driver.findElement(By.xpath(locator)).click();

  }

  public void assertAndType(String locator, String text) {

    assertElementPresentByXpath(locator);
    driver.findElement(By.xpath(locator)).sendKeys(text);;

  }



  public void assertElementPresentByXpath(String locator) {
    System.out.println("# Verifying element.");
    Assert.assertTrue(isElementPresent(locator), "Element " + locator + " not found.");
  }

  public void assertElementNotPresentByXpath(String locator) {
    System.out.println("# Verifying element.");
    Assert.assertFalse(isElementPresent(locator), "Element " + locator + " is found.");
  }

  public boolean isElementPresent(String locator) {
    try {
      driver.findElement(By.xpath(locator));
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }

  }


  public boolean isElementVisible(String locator) {

    try {
      return driver.findElement(By.xpath(locator)).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }

  }

  public void assertElementVisible(String locator, boolean isVisible) {
    System.out.println("# Verifying element visibility.");

    if (isVisible)
      Assert.assertTrue(isElementVisible(locator), "Element " + locator + " should be visible.");
    else
      Assert.assertFalse(isElementVisible(locator),
          "Element " + locator + " should not be visible.");
  }

  public void waitForElementVisible(String locator) {

    new WebDriverWait(driver, 20)
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
  }

  public void waitForElementInVisible(String locator) {

    new WebDriverWait(driver, 20)
        .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
  }

  public WebElement getWebElement(String xpath) {

    return driver.findElement(By.xpath(xpath));

  }


}
