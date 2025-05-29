package stepDefinition;

import io.cucumber.java.en.*;

import StepActions.stepActions;

public class stepDefinitions {

    stepActions actions = new stepActions();

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
    
//    @Then("sort by price")
//    public void sorting(){
//    	actions.sorting();
//    }

    @Then("select all jackets")
    public void selectAllJacketsFromMen() {
        actions.selectAllJackets();
    }
    @Then("add all the prices")
    public void Addtheprices() { 
    	actions.sumOfPrices();
    }

    @Then("verifying the number on the cart matches number of products selected")
    public void verifyCartCountMatchesSelection() throws InterruptedException, AssertionError {
        actions.verifyCartCountMatchesSelection();
    }

   
    @Then("opening cart and checks remove is available for each item")
    public void checkRemoveOptionInCart() {
        actions.verifyRemoveOptionsInCart();
    }

    @Then("proceed to checkout")
    public void proceedToCheckout() {
        actions.proceedToCheckout();
    }

    @Then("fill in personal details and click next")
    public void fillInPersonalDetails() throws InterruptedException {
        actions.fillPersonalDetailsAndContinue();
    }

//    @Then("verify payment info, shipping info, and total price is displayed")
//    public void verifyPaymentInfoShippingInfoAndPriceVisibility() {
//        actions.verifyPaymentInfoShippingInfoAndPriceVisibility();
//    }

//    @Then("verify item total is correct")
//    public void verifyItemTotalCorrect() {
//        actions.verifyItemTotal();
//    }

    @Then("click on Place Order")
    public void clickOnPlaceOrder() throws InterruptedException {
        actions.clickPlaceOrder();
    }

    @Then("get the order confirmation message")
    public void getOrderConfirmationMessage() {
        actions.verifyOrderConfirmationMessage();
    }
}
