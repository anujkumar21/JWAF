package auto.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Init {
    public WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        System.out.println("*** Setup ***");
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/");

    }

    @AfterMethod
    public void teardown() {
        System.out.println("*** Teardown ***");
        driver.quit();

    }

}
