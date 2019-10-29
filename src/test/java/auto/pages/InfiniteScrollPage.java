package auto.pages;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 21-May-18
 */

import auto.utility.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class InfiniteScrollPage extends Services {

    private final static String HEADING = "Infinite Scroll";
    private String xpathHeading = "//h3";

    private String xpathImage1 = "//div[@class='figure'][2]";

    public InfiniteScrollPage(WebDriver driver) {
        super(driver);
    }

    public void verifyInfiniteScrollPageHeader() {
        waitForElement(xpathHeading);
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }


    public void scrollVerticallyPage() {
        String myScript = "window.scrollTo(0,document.body.scrollHeight)";
        ((JavascriptExecutor) driver).executeScript(myScript);
    }

    public void scrollHorizontallyPage() {
        String myScript = "window.scrollBy(400,0)";
        ((JavascriptExecutor) driver).executeScript(myScript);
    }


    public void scrollWithinParticularEle() {
        String myScript = "arguments[0].scrollIntoView();";
        WebElement element = driver.findElement(By.xpath("//td[@class='column-49' and text()='9.49']"));
        ((JavascriptExecutor) driver).executeScript(myScript, element);
    }
}
