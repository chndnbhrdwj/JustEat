package web.ui;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by chandank on 03/08/2017.
 */
public class MyStepdefs {

    Addition addition;
    int result = 0;

    @When("^I want to (add|minus) (\\d+) and (\\d+)$")
    public void iWantToAddAnd(String operation, int arg0, int arg1) throws Throwable {
        addition = new Addition();
        if(operation.equals("add")){
            result = addition.sum(arg0,arg1);
        }
        if(operation.equals("minus")){
            result = addition.minus(arg0,arg1);
        }
    }

    @Then("^I should see result as (\\d+)$")
    public void iShouldSeeResultAs(int arg0) throws Throwable {
        Assert.assertEquals(result,arg0);
    }
}
