package web.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by chandank on 05/08/2017.
 */
public class BasePage {

    protected WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass().getSimpleName());

    public static final int MICRO_TIMEOUT = 1;
    public static final int TINY_TIMEOUT = 3;
    public static final int SHORT_TIMEOUT = 5;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement waitForElement(WebElement element, int timeInSeconds) {
        WebElement element1 = null;
        WebDriverWait wait = new WebDriverWait(getDriver(), timeInSeconds);
        try {
            element1 = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            log.info("Couldn't find expected element " + element + " " + e.getMessage());
        }
        return element1;
    }

    public boolean isPageLoaded(WebElement... element) {
        return isDisplayed(element);
    }

    public boolean isDisplayed(WebElement... element) {
        boolean displayed = false;
        for (int f = 0; f < element.length; f++) {
            displayed = elementDisplayed(element[f]);
            if (!displayed) {
                throw new IllegalStateException("Expected element was not displayed on screen. " + element[f]);
            }
        }
        return displayed;
    }

    public boolean elementDisplayed(WebElement element) {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean displayed = false;
        try {
            if (element != null) {
                displayed = element.isDisplayed();
            }
        } catch (Exception e) {
            displayed = false;
        }
        return displayed;
    }

    public WebElement getElement(By by) {
        return getDriver().findElement(by);
    }

    public boolean textDisplayedInList(List<WebElement> elements, String name) {
        for(WebElement element: elements) {
            String text = element.getText();
            if(!text.contains(name)) {
                log.info(element.getText()+" does not contain "+name);
                return false;
            }
        }
        return true;
    }

}
