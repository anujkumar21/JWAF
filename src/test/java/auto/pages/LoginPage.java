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
    public static final String MSG_SUCCESS = "You logged into a secure area!";
    private static final String MSG_ERROR = "Your username is invalid!";
    private static final String MSG_LOGOUT = "You logged out of the secure area!";
    private String xpathHeading = "//h2";

    //XPATH
    private String xpathUsername = "//input[@name='username']";
    private String xpathPassword = "//input[@name='password']";
    private String xpathLoginBtn = "//button[@type='submit']";

    //CSS
    private String cssUsername = "input[name='username']";
    private String cssPassword = "input[name='password']";
    private String cssLoginBtn = "button[type='submit']";

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
        loginAction(username, password);
        waitForElementVisible(xpathMsg);
        String actualMsg = driver.findElement(By.xpath(xpathMsg)).getText().trim();
        assertTrue(actualMsg.contains(MSG_SUCCESS),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_SUCCESS + "'.");
    }

    public String getMsgSuccess() {
        waitForElementVisible(xpathMsg);
        return driver.findElement(By.xpath(xpathMsg)).getText().trim();
    }

    public void loginAction(String username, String password) {
        type(xpathUsername, username);
        type(xpathPassword, password);
        click(xpathLoginBtn);
    }

    public void loginActionUsingCssSelector(String username, String password) {
        typeViaCss(cssUsername, username);
        typeViaCss(cssPassword, password);
        clickViaCss(cssLoginBtn);
    }

    public void loginActionJava8(String username, String password) {
        type(By::xpath, xpathUsername, username);
        type(By::cssSelector, cssPassword, password);
        click(xpathLoginBtn);
    }

    public void verifyLoginAndLogout(String username, String password) {
        verifyLogin(username, password);
        waitForElementVisible(xpathLogoutBtn);
        click(xpathLogoutBtn);
        waitForElementVisible(xpathMsg);
        String actualMsg = driver.findElement(By.xpath(xpathMsg)).getText().trim();
        assertTrue(actualMsg.contains(MSG_LOGOUT),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_LOGOUT + "'.");
    }

    public void verifyLoginWithInvalidUser(String username, String password) {
        type(xpathUsername, username);
        type(xpathPassword, password);
        click(xpathLoginBtn);

        waitForElementVisible(xpathMsg);
        String actualMsg = driver.findElement(By.xpath(xpathMsg)).getText().trim();

        assertTrue(actualMsg.contains(MSG_ERROR),
                "Actual '" + actualMsg + "' should be same as expected '" + MSG_ERROR + "'.");
    }
}
