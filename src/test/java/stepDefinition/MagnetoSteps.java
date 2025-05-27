package stepDefinition;

import io.cucumber.java.en.*;

import StepActions.MagnetoActions;

public class MagnetoSteps {

    MagnetoActions actions = new MagnetoActions();

    @Given("open url and click on Sign In")
    public void openUrlAndClickOnSignIn() {
        actions.openUrlAndClickSignIn();
    }

    @When("log in with valid credentials")
    public void logInWithValidCredentials() {
        actions.logInWithValidCredentials();
    }

    @Then("navigate to Men Jackets section")
    public void navigateToMenJacketsSection() {
        actions.navigateToMenJackets();
    }

    @Then("select all jackets and notes the prices")
    public void selectAllJacketsFromMen() {
        actions.selectAllJackets();
    }
    @Then("Add the prices")
    public void Addtheprices() { 
    	actions.sumOfPrices();
    }

    @Then("verifying the number on the cart matches number of products selected")
    public void verifyCartCountMatchesSelection() {
        actions.verifyCartCount();
    }

    @Then("opening cart and checks remove is available for each item")
    public void checkRemoveOptionInCart() {
        actions.verifyRemoveOptionsInCart();
    }

    @Then("proceed to checkout")
    public void proceedToCheckout() {
        actions.proceedToCheckout();
    }

    @Then("fill in personal details and continues")
    public void fillInPersonalDetails() {
        actions.fillPersonalDetailsAndContinue();
    }

    @Then("verify payment info, shipping info, and total")
    public void verifyPaymentShippingAndTotal() {
        actions.verifyPaymentShippingAndTotal();
    }

    @Then("verify item total is correct")
    public void verifyItemTotalCorrect() {
        actions.verifyItemTotal();
    }

    @Then("click on finish")
    public void clickOnFinish() {
        actions.clickFinish();
    }

    @Then("get the order confirmation message")
    public void getOrderConfirmationMessage() {
        actions.verifyOrderConfirmationMessage();
    }
}
