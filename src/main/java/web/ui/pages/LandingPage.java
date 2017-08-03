package web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chandank on 03/08/2017.
 */
public class LandingPage extends BasePage {

    @FindBy(id = "postcode")
    protected WebElement inputPostCode;

    @FindBy(xpath = "//button[@type='submit']/span[text()='Find restaurants']")
    protected WebElement buttonFindRestaurants;

    @FindBy(xpath = "//div[@class='errorMessage']")
    protected WebElement errorMessage;

    public LandingPage(WebDriver driver) {
        super(driver);
    }
}
