package auto.utility;
/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Init {
    protected WebDriver driver = null;

    /**
     * This function is used for doing web driver setup.
     */
    @BeforeMethod
    public void setUp() {
        System.out.println("*** Setup ***");
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * This function is quit the driver instance.
     */
    @AfterMethod
    public void teardown() {
        System.out.println("*** Teardown ***");
        if (driver != null)
            driver.quit();

    }

}
