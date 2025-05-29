package stepDefinition;

import io.cucumber.java.en.*;

import StepActions.stepActions;

public class stepDefinitions {

    stepActions actions = new stepActions();

    @Given("the user is on the homepage and clicks Sign In")
    public void openUrlAndClickOnSignIn() {
        actions.openUrlAndClickSignIn();
    }

    @When("the user logs in with valid credentials")
    public void logInWithValidCredentials() {
        actions.logInWithValidCredentials();
    }

    @Then("navigates to the Men Jackets section")
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
    @Then("adds up all the prices")
    public void Addtheprices() { 
    	actions.sumOfPrices();
    }

    @Then("the number in the cart should match the number of selected products")
    public void verifyCartCountMatchesSelection() throws InterruptedException, AssertionError {
        actions.verifyCartCountMatchesSelection();
    }

   
    @Then("the cart should show a remove button for each item")
    public void checkRemoveOptionInCart() {
        actions.verifyRemoveOptionsInCart();
    }

    @Then("the user proceeds to checkout")
    public void proceedToCheckout() {
        actions.proceedToCheckout();
    }

    @Then("fills in personal details and clicks Next")
    public void fillInPersonalDetails() throws InterruptedException {
        actions.fillPersonalDetailsAndContinue();
    }

    @Then("the payment info, shipping info, and total price should be displayed")
    public void verifyPaymentInfoShippingInfoVisibility() {
        actions.verifyPaymentInfoShippingInfoVisibility();
    }

//    @Then("the item total should be correct")
//    public void verifyItemTotalCorrect() {
//        actions.verifyItemTotal();
//    }

    @Then("the user clicks on Place Order")
    public void clickOnPlaceOrder() throws InterruptedException {
        actions.clickPlaceOrder();
    }

    @Then("the order confirmation message should be displayed")
    public void getOrderConfirmationMessage() {
        actions.verifyOrderConfirmationMessage();
    }
}
