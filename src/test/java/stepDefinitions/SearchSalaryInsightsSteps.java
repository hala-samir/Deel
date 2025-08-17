package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.SalaryInsightsPage;

public class SearchSalaryInsightsSteps {
    SalaryInsightsPage salaryInsightsPage ;

    @Given("a user selects the role {string}")
    public void user_selects_the_role(String roleName) {
        salaryInsightsPage = new SalaryInsightsPage();
        salaryInsightsPage.selectJobFromDropDownMenu(roleName);
    }

    @And("a user selects the country {string}")
    public void user_selects_the_country(String countryName) {
        salaryInsightsPage.selectCountryFromDropDownMenu(countryName);
    }

    @When("a user clicks the search button")
    public void a_user_clicks_the_search_button(){
        salaryInsightsPage.clickSearchButton();
    }

    @Then("the selected data {string} and {string} appear in the page")
    public void the_selected_data_and_appears_in_the_page(String roleName, String countryName) {
        Assert.assertTrue(salaryInsightsPage.getResultHeadingText().contains(roleName), roleName+" the expected role didn't appear");
        Assert.assertTrue(salaryInsightsPage.getResultHeadingText().contains(countryName),  countryName+" the expected country didn't appear");
    }
}
