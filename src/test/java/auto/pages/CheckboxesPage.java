package auto.pages;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.*;

public class CheckboxesPage {

    final static String HEADING = "Checkboxes";
    WebDriver driver;
    String xpathHeading = "//h3";
    private String xpathCheckbox = "//form[@id='checkboxes']/input[**index**]";
    private String xpathCheckboxes = "//form[@id='checkboxes']/input";

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
        String xpath = xpathCheckbox.replace("**index**", index + "");
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public void clickOnCheckbox(int index, boolean toSelect) {
        String xpath = xpathCheckbox.replace("**index**", index + "");
        WebElement checkboxEle = driver.findElement(By.xpath(xpath));
        changeStatus(checkboxEle, toSelect);
    }

    private void changeStatus(WebElement checkboxEle, boolean toSelect) {
        if (toSelect) {
            if (!checkboxEle.isSelected())
                checkboxEle.click();
            assertTrue(checkboxEle.isSelected(), "Check box is not selected.");
        } else {
            if (checkboxEle.isSelected())
                checkboxEle.click();
            assertFalse(checkboxEle.isSelected(), "Check box is selected.");
        }
    }

    public void toSelectAllCheckboxes(boolean toSelect) {
        List<WebElement> checkboxEles = driver.findElements(By.xpath(xpathCheckboxes));
        for (WebElement ch : checkboxEles)
            changeStatus(ch, toSelect);
    }
}
