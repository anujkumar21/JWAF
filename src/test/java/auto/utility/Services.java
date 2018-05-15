package auto.utility;

import java.util.NoSuchElementException;
/**
 * Created by: Anuj Kumar Email: cdac.anuj@gmail.com Date: 14-May-18 Time: 8:19 PM
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    verifyElementPresentByXpath(locator);
    driver.findElement(By.xpath(locator)).click();

  }
  
  public void assertAndType(String locator, String text) {

    verifyElementPresentByXpath(locator);
    driver.findElement(By.xpath(locator)).sendKeys(text);;

  }



  public void verifyElementPresentByXpath(String locator) {
    System.out.println("# Verifying element.");
    Assert.assertTrue(isElementPresent(locator), "Element " + locator + " not found.");
  }

  public boolean isElementPresent(String locator) {
    try {
      driver.findElement(By.xpath(locator));
      return true;
    } catch (NoSuchElementException e) {

      return false;
    }

  }



}
