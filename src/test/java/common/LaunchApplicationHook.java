package common;

import common.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import cucumber.api.java.Before;
import cucumber.api.java.After;

public class LaunchApplicationHook extends BasePage {

    @Before
    public void setUp() throws Exception {
        // set up appium
        File appDir = new File("apps");
        /**UAT apk*/
        File app = new File(appDir, "app-uat-universal-release.apk");
        /**QC apk*/
        //File app = new File(appDir, "app-staging-release.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("deviceName", "R58M66BNXFW");
        capabilities.setCapability("app", app.getAbsolutePath());
        /**UAT package*/
        capabilities.setCapability("appPackage", "com.vingroup.vinid.uat");
        /**Staging package*/
        //capabilities.setCapability("appPackage", "com.vingroup.vinid.staging");
        capabilities.setCapability("appActivity", "com.vingroup.vinid.ui.gateway.GatewayActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.resetApp();
        driver.quit();
    }
}
