package auto.pages;

import auto.utility.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */
public class ChallengingDomPage extends Services {

    final static String HEADING = "Challenging DOM";

    String xpathHeading = "//h3";
    String xpathButtons = "//div[@class='large-2 columns']/a";
    String xpathButtonsViaContains = "//div[contains(@class,'large-2')]/a";
    String xpathButtonsViaStartsWith = "//div[starts-with(@class,'large-2')]/a";

    String xpathTable = "//div[contains(@class,'large-10')]";
    String xpathTableHeader = xpathTable + "/table//th";
    String xpathTableCell = xpathTable + "//tbody//tr[**row**]/td[**col**]";

    public ChallengingDomPage(WebDriver driver) {
        super(driver);
    }

    public void verifyChallengingDomPageHeader() {
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public List<String> getAllButtonText() {
        waitForElement(xpathButtonsViaContains);
        List<WebElement> lstBtns = driver.findElements(By.xpath(xpathButtonsViaContains));
        List<String> buttons = new ArrayList<>();
        for (WebElement btn : lstBtns) {
            buttons.add(btn.getText());
        }
        return buttons;
    }

    public List<String> getAllButtonTextJava8() {
        waitForElement(xpathButtonsViaContains);
        return driver.findElements(By.xpath(xpathButtonsViaContains))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickOnFirstButton() {
        String xpath = xpathButtons + "[1]";
        click(xpath);
    }

    public int getColumnIndex(String columnName) {
        waitForElement(xpathTableHeader);
        List<WebElement> lstCols = driver.findElements(By.xpath(xpathTableHeader));
        int index = 0;
        for (WebElement col : lstCols) {
            String actualCol = col.getText();
            index++;
            if (actualCol.equals(columnName)) {
                return index;
            }
        }

        fail("Given column name " + columnName + " is not present.");
        return index;
    }

    public String getCellText(int row, String columnName) {
        int col = getColumnIndex(columnName);
        String xpath = xpathTableCell.replace("**row**", row + "").replace("**col**", col + "");
        waitForElement(xpath);
        return driver.findElement(By.xpath(xpath)).getText();
    }
}
