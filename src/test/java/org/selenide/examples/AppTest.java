package org.selenide.examples;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppTest 
{
    private String employeeNameValue = " Nguyễn Thành Thoại Long - 1879";

    private By employeeName = By.xpath("//span[text()='"+employeeNameValue+"']");
    private By division = By.cssSelector("div[folabel='Division']");
    private By input = By.cssSelector("div.select2-drop-active input.select2-focused");
    private By taskName = By.cssSelector("div[folabel='Task']");
    private By timesheetHour = By.cssSelector("input[name='Timesheet_Hours']");
    private By project = By.cssSelector("div[folabel='Project']");
    private By taskDes = By.cssSelector("div[folabel='Task_Description'] textarea");
    private By billableHour = By.cssSelector("input[name='Billable_Hours']");


    private String divisionValue = "Smartbox";
    private String taskValue = "Test execution";
    private String projectValue = "DS_Sma_1 - Smartbox Dedicated";
    private String taskDesValue = "Continue beta testing on Denmark Preprod";
    private String timesheetHourValue = "8";
    private String billableHourValue = "8";

    @BeforeClass
    public static void setupTest(){
        System.setProperty("webdriver.chrome.driver", "D:\\Working\\Selenide\\timesheet-smartosc\\driver\\chromedriver_win32\\chromedriver.exe");
        Configuration.browser = "chrome";
        String userProfile= "C:\\Users\\longp\\AppData\\Local\\Google\\Chrome\\User Data\\longpolk";
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
        $(employeeName).shouldBe(Condition.appears);
        $(division).shouldBe(Condition.visible).click();
        Thread.sleep(1500);
        $(input).setValue(divisionValue);
        $(By.xpath("//span[text()='"+divisionValue+"']/ancestor::li")).shouldBe(Condition.visible).click();
        $(taskName).shouldBe(Condition.visible).click();
        Thread.sleep(1500);
        $(input).setValue(taskValue);
        $(By.xpath("//span[text()='"+taskValue+"']/ancestor::li")).shouldBe(Condition.visible).click();
        $(timesheetHour).setValue(timesheetHourValue);
        $(project).shouldBe(Condition.visible).click();
        Thread.sleep(1500);
        $(input).setValue(projectValue);
        $(By.xpath("//span[text()='"+projectValue+"']/ancestor::li")).shouldBe(Condition.visible).click();
        $(taskDes).setValue(taskDesValue);
        $(billableHour).setValue(billableHourValue);
    }

    @AfterClass
    public static void tearDown(){
        getWebDriver().quit();
    }
}
