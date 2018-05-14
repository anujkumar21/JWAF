package auto.pages;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import auto.utility.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class DropdownPage extends Services {

    final static String HEADING = "Dropdown List";
    WebDriver driver;
    String xpathHeading = "//h3";
    String xpathDropdown = "//select[@id='dropdown']";

    public DropdownPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyDropdownPageHeader() {
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void selectDropDown(int index) {
        // waitForElement(xpathDropdown);
        WebElement ele = driver.findElement(By.xpath(xpathDropdown));

    }

}
