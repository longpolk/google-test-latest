package steps_definition.hooks;

import common.AndroidPages.AndroidHomePage;
import common.AndroidPages.AndroidLoginPage;
import common.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class jupviecCommonSteps{

    AndroidLoginPage androidLoginPage = new AndroidLoginPage();
    AndroidHomePage androidHomePage = new AndroidHomePage();

    @Given("I login VinID app with phone number (.*) and OTP (.*) and PIN (.*)")
    public void iLoginVinIDAppWithPhoneNumberAndOTPAndPIN(String phone, String otp, String pin){
        androidLoginPage.enterPhoneAndOTPAndPIN(phone, otp, pin);
    }

    @Then("^Verify I am on Homepage of VinID$")
    public void iAmOnHomepageOfVinID() {
        Assert.assertTrue(androidHomePage.isHomePageDisplayed());
    }

    @When("^I click on (.*) shortcut$")
    public void iClickOnShortcut(String link) {
        androidHomePage.clickOnLink(link);
    }
}
