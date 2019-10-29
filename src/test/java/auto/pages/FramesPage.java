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

import static org.testng.Assert.assertEquals;

public class FramesPage extends Services {

    private final static String HEADING = "Frames";
    private String xpathHeading = "//h3";

    private String xpathLinks = "//a[contains(text(),'**link**')]";
    private String xpathFrameTop = "//frame[@name='frame-top']";
    private String xpathFrameBottom = "//frame[@name='frame-bottom']";
    private String xpathFrameLeft = "//frame[@name='frame-left']";
    private String xpathFrameMiddle = "//frame[@name='frame-middle']";
    private String xpathIFrame = "//iframe";


    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void verifyFramesPageHeader() {
        waitForElement(xpathHeading);
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void clickOnLink(String link) {
        String xpath = xpathLinks.replace("**link**", link);
        click(xpath);
    }

    public void getFrameText() {
        waitForElement(xpathFrameBottom);
        WebElement bottomFrame = driver.findElement(By.xpath(xpathFrameBottom));
        driver.switchTo().frame(bottomFrame);

        System.out.println(driver.findElement(By.xpath("//body")).getText());
        driver.switchTo().parentFrame();

        WebElement topFrame = driver.findElement(By.xpath(xpathFrameTop));
        driver.switchTo().frame(topFrame);

        WebElement leftFrame = driver.findElement(By.xpath(xpathFrameLeft));
        driver.switchTo().frame(leftFrame);

        System.out.println(driver.findElement(By.xpath("//body")).getText());
        driver.switchTo().parentFrame();

        WebElement middleFrame = driver.findElement(By.xpath(xpathFrameMiddle));
        driver.switchTo().frame(middleFrame);

        System.out.println(driver.findElement(By.xpath("//body")).getText());
    }


    public void getIFrame() throws InterruptedException {
        waitForElement(xpathIFrame);
        WebElement iFrame = driver.findElement(By.xpath(xpathIFrame));
        driver.switchTo().frame(iFrame);
        WebElement editor = driver.findElement(By.xpath("//p"));
        System.out.println(editor.getText());
        editor.clear();
        editor.click();
        Thread.sleep(2000);
        editor.sendKeys("Anuj Kumar");
        Thread.sleep(2000);
        System.out.println(editor.getText());
    }
}
