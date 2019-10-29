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
import static org.testng.Assert.assertTrue;

public class LoginPage extends Services {

    private final static String HEADING = "Login Page";
    private static final String MSG_SUCCESS = "You logged into a secure area!";
    private static final String MSG_ERROR = "Your username is invalid!";
    private static final String MSG_LOGOUT = "You logged out of the secure area!";
    private String xpathHeading = "//h2";
    private String xpathUsername = "//input[@name='username']";
    private String xpathPassword = "//input[@name='password']";
    private String xpathLoginBtn = "//button[@type='submit']";
    private String xpathLogoutBtn = "//a[contains(@class,'button')]";
    private String xpathMsg = "//div[@id='flash']";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoginPageHeader() {
        waitForElement(xpathHeading);
        WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
        String actualHeading = headerEle.getText();
        assertEquals(actualHeading, HEADING,
                "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
    }

    public void verifyLogin(String username, String password) {
        assertAndType(xpathUsername, username);
        assertAndType(xpathPassword, password);
        assertAndClick(xpathLoginBtn);

        waitForElementVisible(xpathMsg);
        String actualMsg = driver.findElement(By.xpath(xpathMsg)).getText().trim();

        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");

        waitForElementVisible(xpathLogoutBtn);
        assertAndClick(xpathLogoutBtn);

        waitForElementVisible(xpathMsg);
        actualMsg = driver.findElement(By.xpath(xpathMsg)).getText().trim();
        assertTrue(actualMsg.contains(MSG_LOGOUT),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_LOGOUT + "'.");
    }

    public void verifyLoginWithInvalidUser(String username, String password) {
        assertAndType(xpathUsername, username);
        assertAndType(xpathPassword, password);
        assertAndClick(xpathLoginBtn);

        waitForElementVisible(xpathMsg);
        String actualMsg = driver.findElement(By.xpath(xpathMsg)).getText().trim();

        assertTrue(actualMsg.contains(MSG_ERROR),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_ERROR + "'.");
    }
}
