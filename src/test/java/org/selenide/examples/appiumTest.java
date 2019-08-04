package org.selenide.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

//import org.json.simple.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class appiumTest {
    private AppiumDriver<WebElement> driver;
    private List<Integer> values;


    @Before
    public void setUp() throws Exception {
        // set up appium
        File appDir = new File("D:\\Working\\Appium\\test");//System.getProperty("user.dir"), "D:\\Working\\Appium\\test");
        File app = new File(appDir, "VinID_v5.0.0.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "5");
        capabilities.setCapability("deviceName", "Test");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        values = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testBasicAlert() throws Exception {
        Assert.assertTrue(true);
        //driver.findElement(By.xpath("//UIAButton[2]")).click();
        //Alert alert = driver.switchTo().alert();
        //check if title of alert is correct
        //assertEquals("Cool title this alert is so cool.", alert.getText());
        //alert.accept();
    }
}
