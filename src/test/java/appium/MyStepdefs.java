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

    @When("user tap {string}")
    public void userTap(String element) {
        tapHelper(element);
    }

    @And("user types {string} to {string} area")
    public void userTypesToArea(String input, String area) {
        typeHelper(input, area);
    }

    @Then("new account is saved")
    public void newAccountIsSaved() {
    }
}
