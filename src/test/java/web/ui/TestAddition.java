package web.ui;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by chandank on 03/08/2017.
 */

@CucumberOptions(plugin = { "html:build/cucumber-html-report",
        "junit:build/cucumber-junit.xml",
        "json:build/cucumber.json",
        "pretty:build/cucumber-pretty.txt",
        "usage:build/cucumber-usage.json"
},
        features = { "src/main/resources/features" },
//        glue = { "com/thetrainline/common/steps" },
        tags = { "@test", "~@ios_only" }
)
public class TestAddition extends AbstractTestNGCucumberTests {

}
