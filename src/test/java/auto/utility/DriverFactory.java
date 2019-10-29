package auto.utility;

/**
 * Created by: Anuj Kumar
 * Email: cdac.anuj@gmail.com
 * Date: 19-Apr-19
 */

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
    static Logger logger = Logger.getLogger(DriverFactory.class.getName());
    private String browser;

    public WebDriver getDriver() {

        browser = System.getProperty("browser");
        if (browser == null)
            browser = "firefox";
        logger.info("# WebDriver instance for browser: " + browser);

        if (browser.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if (browser.equalsIgnoreCase("ie"))
            return new InternetExplorerDriver();
        else {
            FirefoxProfile ffprofile = createFirefoxProfile();
            return new FirefoxDriver(ffprofile);
        }

    }

    public FirefoxProfile createFirefoxProfile() {

        logger.info("# Setting up Firefox profile.");
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", "E:\\git_projects\\download");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/pdf,application/vnd.ms-excel,application/octet-stream");
        firefoxProfile.setPreference("pdfjs.disabled", true);

        return firefoxProfile;
    }

}
