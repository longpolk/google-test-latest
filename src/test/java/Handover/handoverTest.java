package Handover;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;

public class handoverTest {
    private AppiumDriver<WebElement> driver;
    private List<Integer> values;


    @Before
    public void setUp() throws Exception {
        // set up appium
        File appDir = new File("D:\\Working\\Appium\\automationVinID\\vinhomes\\google-test-latest\\apk");
        /**UAT apk*/
        //File app = new File(appDir, "app-uat-release.apk");
        /**QC apk*/
        File app = new File(appDir, "app-staging-release.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", app.getAbsolutePath());
        /**UAT package*/
        //capabilities.setCapability("appPackage", "com.vingroup.vinid.uat");
        /**Staging package*/
        capabilities.setCapability("appPackage", "com.vingroup.vinid.staging");
        capabilities.setCapability("appActivity", "com.vingroup.vinid.ui.gateway.GatewayActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        values = new ArrayList<>();
        WebDriverWait wait;
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testFlowInspection() throws Exception {
        driver.findElement(By.id("btnAction")).click();
        /**The account has sync*/
        //driver.findElement(By.id("etContent")).sendKeys("0115272727");
        /** The account has more than 2 apartments*/
        //driver.findElement(By.id("etContent")).sendKeys("0115123456");
        /** The account has no apartment*/
        driver.findElement(By.id("etContent")).sendKeys("0115222223");

        driver.findElement(By.id("btnNext")).click();
        driver.findElement(By.id("etContent")).sendKeys("123456");
        driver.findElement(By.id("btnNext")).click();
        driver.findElement(By.id("itemPin")).sendKeys("112233");
        //driver.findElement(By.id("btnNext")).click();
        driver.findElements(By.id("ivStaticIcon")).get(1).click();
        //check if button Tôi là cư dân Vinhomes presents
        Assert.assertTrue(driver.findElement(By.id("btnContinues")).isDisplayed());
        driver.findElement(By.id("btnContinues")).click();
        //check if page welcome resident is displayed
        Assert.assertTrue(driver.findElement(By.id("svWelcome")).isDisplayed());
        driver.findElement(By.id("btnContinues")).click();
        Assert.assertTrue(driver.findElement(By.id("toolbarTitle")).getText().contains("Thông tin cư dân"));
        driver.findElement(By.id("etContent")).sendKeys("0115272727");
        driver.findElement(By.id("btnContinues")).click();

        /**Verify that the page Chọn khu đô thị display*/
        Assert.assertTrue(driver.findElement(By.id("tvTitle")).getText().contains("Bạn đang ở khu đô thị nào?"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Vinhomes Golden River']")).click();

        /**Verify that the page Chọn tòa nhà display*/
        Assert.assertTrue(driver.findElement(By.id("tvTitle")).getText().contains("Bạn đang ở tòa nhà/khu nào?"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Aqua 03']")).click();

        /**Verify that the page Chọn tầng/khu biệt thự display*/
        Assert.assertTrue(driver.findElement(By.id("tvTitle")).getText().contains("Bạn đang ở tầng/khu biệt thự nào?"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Tầng 03']")).click();

        /**Verify that the page Chọn căn hộ/biệt thự display*/
        Assert.assertTrue(driver.findElement(By.id("tvTitle")).getText().contains("Bạn đang ở căn hộ/biệt thự nào?"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='A030307']")).click();

        /**Verify that the page Xác nhận thông tin display*/
        Assert.assertTrue(driver.findElement(By.id("tvTitle")).getText().contains("Xác nhận thông tin"));
        driver.findElement(By.id("tvConfirm")).click();

        Thread.sleep(2000);
    }
}
