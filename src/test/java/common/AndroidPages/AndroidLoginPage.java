package common.AndroidPages;

import common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AndroidLoginPage{

    @FindBy(id = "btnAction")
    WebElement btnAction;
    @FindBy(id = "etContent")
    WebElement txtPhone;
    @FindBy(id = "etContent")
    WebElement txtOTP;
    @FindBy(id = "etPin")
    WebElement txtPIN;
    @FindBy( id = "btnNext")
    WebElement btnNext;

    public AndroidLoginPage(){
        PageFactory.initElements(BasePage.driver, this);
    }

    public void enterPhoneAndOTPAndPIN(String phone, String otp, String pin){
        if(btnAction.isDisplayed()){
            btnAction.click();
        }
        txtPhone.click();
        txtPhone.sendKeys(phone);
        btnNext.click();

        txtOTP.click();
        txtOTP.sendKeys(otp);
        btnNext.click();

        txtPIN.click();
        txtPIN.sendKeys(pin);
    }
}
