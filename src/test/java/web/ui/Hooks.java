package web.ui;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by chandank on 03/08/2017.
 */
public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: "+scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Finished scenario: "+scenario.getName());
    }
}
