package web.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chandank on 03/08/2017.
 */
public class SearchResultsPage extends BasePage {

    @FindBy(id = "nameSearch")
    protected WebElement inputSearchByName;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFilterOption(String option) {
        String locator = "//div[@class='c-serp-filter__list']//li/span[text()='"+option+"']";
        return getDriver().findElement(By.xpath(locator));
    }
}
