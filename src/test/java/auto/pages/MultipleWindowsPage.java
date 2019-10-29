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

import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class MultipleWindowsPage extends Services {

    private final static String HEADING = "Opening a new window";
    private String xpathHeading = "//h3";

    private String xpathLink = "//a[text()='Click Here']";


    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyMultipleWindowsPageHeader() {
        waitForElement(xpathHeading);
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void clickOnLink() {
        click(xpathLink);
    }

    public void getTextOnNewWindow() throws InterruptedException {
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        Iterator<String> itr = windowHandles.iterator();
        while (itr.hasNext()) {
            String win = itr.next();
            driver.switchTo().window(win);
            Thread.sleep(3000);
            if (driver.getTitle().equals("New Window")) {
                System.out.println(getWebElement("//h3").getText());
                driver.close();
            }
        }

        windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        itr = windowHandles.iterator();

        while (itr.hasNext()) {
            String win = itr.next();
            driver.switchTo().window(win);
            Thread.sleep(3000);
            if (driver.getTitle().equals("The Internet")) {
                System.out.println(getWebElement("//h3").getText());
            }
        }
    }
}
