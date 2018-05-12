package auto.pages;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class CheckboxesPage {

    final static String HEADING = "Checkboxes";
    WebDriver driver;
    String xpathHeading = "//h3";
    String xpathCheckbox = "//form[@id='checkboxes']/input[**index**]";

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckboxesPage verifyCheckboxPageHeader() {
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
        return this;
    }

    public CheckboxesPage clickOnCheckbox(int index) {
        xpathCheckbox = xpathCheckbox.replace("**index**", index + "");
        driver.findElement(By.xpath(xpathCheckbox)).click();
        return this;
    }

}
