package steps_definition;

import common.AndroidPages.AndroidTienIchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class TienIchPageSteps {
    AndroidTienIchPage androidTienIchPage = new AndroidTienIchPage();

    @Then("^Verify I am on Tiện Ích page$")
    public void verifyIAmOnTiệnÍchPage() {
        Assert.assertTrue(androidTienIchPage.isOnTienIchPage());
    }


    @And("^I click on Giúp việc link$")
    public void iClickOnGiupViecLink() {
        androidTienIchPage.clickOnLinkJupviec();
    }
}
