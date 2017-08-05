package web.ui.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import web.ui.Driver;
import web.ui.pages.BasePage;
import web.ui.pages.LandingPage;
import web.ui.pages.SearchResultsPage;

/**
 * Created by chandank on 05/08/2017.
 */
public class Steps extends BasePage{

    LandingPage landingPage = new LandingPage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    public Steps(Driver driver) {
        super(driver.getDriver());
    }

    @Given("^I want food in \"([^\"]*)\"$")
    public void iWantFoodIn(String arg0) throws Throwable {
        landingPage.enterPostcode(arg0);
    }

    @When("^I search for restaurants$")
    public void iSearchForRestaurants() throws Throwable {
        landingPage.findRestaurants();
    }

    @Then("^I should see some restaurants in \"([^\"]*)\"$")
    public void iShouldSeeSomeRestaurantsIn(String arg0) throws Throwable {
        Assert.assertTrue(
                searchResultsPage
                        .resultsDisplayedForPostcode(arg0));
    }

    @When("^I filter results for cuisine \"([^\"]*)\"$")
    public void iFilterResultsForCuisine(String arg0) throws Throwable {
        searchResultsPage.selectCuisine(arg0);
    }

    @Then("^I should see \"([^\"]*)\" cuisine restaurants$")
    public void iShouldSeeCuisineRestaurants(String arg0) throws Throwable {
        Assert.assertTrue(
                searchResultsPage
                .restaurantServesCuisine(arg0));
    }

    @When("^I filter results by restaurant name \"([^\"]*)\"$")
    public void iFilterResultsByRestaurantName(String arg0) throws Throwable {
        searchResultsPage.filterByName(arg0);
    }

    @Then("^I should see the \"([^\"]*)\" restaurants$")
    public void iShouldSeeTheRestaurant(String arg0) throws Throwable {
        Assert.assertTrue(
                searchResultsPage
                .restaurantDisplayedWithName(arg0));
    }
}
