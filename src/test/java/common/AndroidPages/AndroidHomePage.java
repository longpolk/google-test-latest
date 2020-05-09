package common.AndroidPages;

import common.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AndroidHomePage{

    @FindBy(id = "tvGreeting")
    WebElement txtHello;

    public AndroidHomePage() {
        PageFactory.initElements(BasePage.driver, this);
    }

    public boolean isHomePageDisplayed() {
        return txtHello.isDisplayed();
    }
}
