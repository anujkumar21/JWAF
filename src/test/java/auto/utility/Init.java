package auto.utility;
/*
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.apache.log4j.Logger.getLogger;

public class Init extends DriverFactory {

    static Logger logger = getLogger(Init.class.getName());

    protected WebDriver driver = null;

    /**
     * This function is used for doing web driver setup.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        logger.info("# Setup.");
        driver = getDriver();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * This function is quit the driver instance.
     */
    @AfterMethod(alwaysRun = true)
    public void teardown() {
        logger.info("# Teardown.");
        if (driver != null)
            driver.quit();
    }
}
