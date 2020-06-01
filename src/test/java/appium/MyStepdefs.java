package appium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static appium.appiumHelper.*;

public class MyStepdefs {
    @Given("user is on phone app")
    public void userIsOnPhoneApp() {
        navigateHelper();
    }


    @When("user click {string}")
    public void userClick(String element) {
        clickHelper(element);
    }

    @And("user types {string} to {string} area")
    public void userTypesToArea(String input, String area) {
        typeHelper(input, area);
    }

    @Then("new account is saved")
    public void newAccountIsSaved() {
    }
}
