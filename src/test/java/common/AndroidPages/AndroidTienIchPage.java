package common.AndroidPages;

import common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AndroidTienIchPage extends BasePage {

    @FindBy(id = "toolbarTitle")
    WebElement txtToolbar;

    @FindBy(xpath = "//android.widget.TextView[@text='Giúp việc']")
    WebElement linkJupViec;

    public AndroidTienIchPage(){
        PageFactory.initElements(BasePage.driver, this);
    }

    public boolean isOnTienIchPage(){
        return (txtToolbar.getText().equals("Tiện ích"));
    }

    public void clickOnLinkJupviec(){
        linkJupViec.click();
    }
}
