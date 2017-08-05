package web.ui;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by chandank on 05/08/2017.
 */
public class Driver {

    WebDriver driver;
    Logger log = Logger.getLogger(this.getClass().getSimpleName());
    String workingDirectory = System.getProperty("user.dir");
    String url = "https://www.just-eat.co.uk/";

    @Before
    public void setUp(Scenario scenario) {
        log.info(" **** Starting scenario: "+scenario.getName());
        workingDirectory = workingDirectory+"/configuration/chromedriver";
        System.setProperty("webdriver.chrome.driver", workingDirectory);
        driver =  new ChromeDriver(new ChromeOptions());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(url);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException e) {
                System.err.println(e.getMessage());
            }
        }
        driver.quit();
        log.info(" **** Finished scenario: "+scenario.getName());
    }

    public WebDriver getDriver() {
        return driver;
    }
 }
