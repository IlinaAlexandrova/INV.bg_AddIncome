package setUp;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uiPages.CashboxUserPage;

public class MyStepdefs {

    @Given("User should be login")
    public void user_should_be_login(String loginSubdomain, String loginName, String loginPassword) {
        CashboxUserPage.logInToPage(loginSubdomain, loginName, loginPassword);
    }

    @When("I go to Cashbox page")
    public void i_go_to_cashbox_page() {
        CashboxUserPage.goToCashboxPage();
    }

    @Then("Cashbox page is opened")
    public void cashbox_page_is_opened() {
        CashboxUserPage.assertationCashboxPageIsOpenned();
    }

    @When("I click on NewIncome button")
    public void i_click_on_new_income_button() {
        CashboxUserPage.clickNewIncomeButton();
    }

    @Then("New income page is opened with checked radio button Income")
    public void new_income_page_is_opened_with_checked_radio_button_income() {
        CashboxUserPage.clickNewIncomeButton();
    }

    @Then("I fill {value} and {reason} and click on InsertIncome button")
    public void i_fill_and_and_click_on_insert_income_button(String incomesValue, String incomesReason) {
        CashboxUserPage.fillNewIncomeFields(incomesValue, incomesReason);
    }

    @Then("I click on InsertIncome button")
    public void i_click_on_insert_income_button() {

    }

    @Then("{okmsg} is displayed")
    public void is_displayed() {
        CashboxUserPage.assertNewIncomeIsAddedOrDeleted();
    }

    @Then("I delete the items")
    public void i_delete_the_items() {
        CashboxUserPage.deleteNewEntries();
        CashboxUserPage.assertNewIncomeIsAddedOrDeleted();
    }



}

