package appium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static appium.appiumHelper.*;
import static appium.ScrollSwipeActionHelper.*;

public class MyStepdefs {

    @Given("user is on app")
    public void userIsOnApp() {
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


    @And("user scroll to {string}")
    public void userScrollTo(String arg0) {
        scrollToHelper(arg0);
    }


    @And("user scroll {string} to {string}")
    public void userScrollTo(String arg0, String arg1) {
        touchActionMoveToElementHelper(arg0, arg1);
    }
}
