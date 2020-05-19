package auto.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.apache.logging.log4j.LogManager.getLogger;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 12-May-18
 */
public class Init extends DriverFactory {

    private static final String URL = "http://the-internet.herokuapp.com/";

    protected WebDriver driver = null;
    private static final long IMPLICIT_TIME = 5;
    private static Logger logger = getLogger(Init.class.getName());

    /**
     * This function is used for doing web driver setup.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        logger.info("# Setup.");
        driver = getDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, SECONDS);
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
