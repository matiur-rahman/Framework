package generic;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: mrahman
 * Date: 4/28/13
 * Time: 2:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class SauceConnectTest {

    private WebDriver driver;

    @Parameters({"username", "key", "os", "browser", "browserVersion"})
    @BeforeMethod
    public void setUp(@Optional("rahmanww") String username,
                      @Optional("e45ab198-cbcb-4f8f-89b9-639b0894e0bf") String key,
                      @Optional("mac") String os,
                      @Optional("iphone") String browser,
                      @Optional("5.0") String browserVersion,
                      Method method) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", Platform.valueOf(os));
        capabilities.setCapability("name", method.getName());
        this.driver = new RemoteWebDriver(
                new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
    }

    @Test
    public void webDriver() throws Exception {
        driver.get("http://www.amazon.com/");
       // assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}