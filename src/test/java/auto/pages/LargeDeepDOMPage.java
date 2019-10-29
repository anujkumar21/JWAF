package auto.pages;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 16-May-18
 */

import auto.utility.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class LargeDeepDOMPage extends Services {

    static final String FOLLOWING_SIBLINGS_XPATH =
            "//div[@id='sibling-1.2']/following-sibling::div[not(contains(@class,'parent'))]";
    static final String PRECEDING_SIBLINGS_XPATH =
            "//div[@id='sibling-1.3']/preceding-sibling::div[not(contains(@class,'parent'))]";
    static final String PARENT_XPATH = "//div[@id='sibling-2.2']/parent::div";
    static final String ANCESTOR_XPATH =
            "//div[@id='sibling-2.2']/ancestor::div[contains(@id,'sib')]";
    static final String DOM_ELE_XPATH = "//div[text()='**dynamic**']";
    private final static String HEADING = "Large & Deep DOM";
    private String xpathHeading = "//h3";

    public LargeDeepDOMPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLargeDeepDOMPageHeader() {
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void getLargeDOMText() {

        System.out.println(getText(FOLLOWING_SIBLINGS_XPATH));
        System.out.println(getText(PRECEDING_SIBLINGS_XPATH));

    }

    public String getText(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }


    public void getParent(String cellText) {
        String xpath = DOM_ELE_XPATH.replace("**dynamic**", cellText);
        WebElement currEle = driver.findElement(By.xpath(xpath));
        WebElement parent =
                driver.findElement(By.xpath(xpath + "/parent::div[contains(@class,'parent')]"));
        System.out.println("Parent of " + currEle.getText() + ": " + parent.getText());
    }

    public void getAncestor(String cellText) {
        String xpath = DOM_ELE_XPATH.replace("**dynamic**", cellText);
        WebElement currEle = driver.findElement(By.xpath(xpath));
        WebElement parent = driver.findElement(By.xpath(xpath + "/ancestor::div[@class='row']//h3"));
        System.out.println("Ancestor of " + currEle.getText() + ": " + parent.getText());
    }
}
