package org.selenide.examples;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppTest 
{
    @BeforeClass
    public static void setupTest(){
        Configuration.browser = "chrome";
        String userProfile= "C:\\Users\\LongNTT-CA\\AppData\\Local\\Google\\Chrome\\User Data\\longpolk";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+userProfile);
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
        //open("https://accounts.zoho.com/signin?servicename=zohopeople&signupurl=https://www.zoho.com/people/signup.html");
    }

    @Test
    public void shouldAnswerWithTrue() throws Exception {
        /*$(By.cssSelector("div#openidcontainer div.fs_signin_options_txt")).shouldBe(Condition.visible).click();
        Thread.sleep(2000);
        $(By.cssSelector("div#fs-google-icon")).click();
        Thread.sleep(2000);
        //$(By.cssSelector("input#identifierId")).setValue("longntt@smartosc.com").pressEnter();
        //$(By.cssSelector("div#password input.whsOnd.zHQkBf")).setValue(("Smartosc@123")).pressEnter();
        $(By.cssSelector("div[data-identifier='longntt@smartosc.com']")).click();*/
        open("https://people.zoho.com/hrportal1524046581683/zp#timesheet/form/add-formLinkName:Time_Log");
        $(By.cssSelector("div[folabel='Division']")).shouldBe(Condition.visible).click();
        $(By.cssSelector("div.select2-drop-active input")).setValue("Smartbox").pressEscape();
        $(By.cssSelector("div[folabel='Division']")).shouldBe(Condition.visible).click();
        $(By.cssSelector("div.select2-drop-active input")).setValue("Test execution").pressEscape();
        $(By.cssSelector("input[name='Timesheet_Hours']")).setValue("8");
        $(By.cssSelector("div[folabel='Project']")).shouldBe(Condition.visible).click();
        $(By.cssSelector("div.select2-drop-active input")).setValue("DS_Sma_1 - Smartbox Dedicated").pressEscape();
        $(By.cssSelector("div[folabel='Task_Description'] textarea")).setValue("Test");
        $(By.cssSelector("input[name='Billable_Hours']")).setValue("8");
    }

    @AfterClass
    public static void tearDown(){
        getWebDriver().quit();
    }
}
