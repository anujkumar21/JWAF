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

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DisappearingElementsPage extends Services {

    final static String HEADING = "Disappearing Elements";

    String xpathHeading = "//h3";
    private String xpathMenu = "//ul//li//a";
    private String xpathMenuByTxt = xpathMenu + "[text()='**txt**']";

    public DisappearingElementsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyDisappearingElementsPageHeader() {
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public List<String> getAllTabsName() {
        List<String> tabNames = new ArrayList<String>();

        List<WebElement> lstTabs = driver.findElements(By.xpath(xpathMenu));
        for (WebElement ttab : lstTabs) {
            tabNames.add(ttab.getText());
        }
        return tabNames;
    }

    public void verifyDisappearTab(String tabName) {
        String temp = xpathMenuByTxt.replace("**txt**", tabName);
        do {
            driver.navigate().refresh();
            System.out.println("Is Present: " + isElementPresent(temp));
        } while (!isElementPresent(temp));
    }
}
