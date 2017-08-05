package web.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Created by chandank on 03/08/2017.
 */
public class SearchResultsPage extends BasePage {

    @FindBy(id = "nameSearch")
    protected WebElement inputSearchByName;

    @FindBy(xpath = "//div[@data-ft='serpHeader']//h1")
    protected WebElement headerText;

    @FindBy(xpath = "//div[contains(@style,'display: block;')]//h2[@itemprop='name']")
    protected List<WebElement> restaurantNames;

    @FindBy(xpath = "//p[@itemprop='servesCuisine']")
    protected List<WebElement> cuisinesTexts;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInputSearchByName() {
        return inputSearchByName;
    }

    public WebElement getHeaderText() {
        return headerText;
    }

    public List<WebElement> getCuisinesTexts() {
        return cuisinesTexts;
    }

    public List<WebElement> getRestaurantNames() {
        return restaurantNames;
    }

    public SearchResultsPage selectSortByOption(String option) {
        By locator = By.xpath("//div[@class='c-serp-filter__list']//li/a[text()='"+option+"']");
        getElement(locator).click();
        return this;
    }

    public SearchResultsPage selectCuisine(String name) {
        By locator = By.xpath("//div[@data-ft='cuisineFilter']//a[contains(@title,'"+name+"')]");
        getElement(locator).click();
        return this;
    }

    public SearchResultsPage filterByName(String name) {
        getInputSearchByName().sendKeys(name);
        return this;
    }

    public boolean resultsDisplayedForPostcode(String postcode) {
        String header = getHeaderText().getText();
        Assert.assertTrue(header.contains(postcode), "Results not displayed for the specified postcode "+postcode);
        int count = Integer.valueOf(header.split(" ")[0]);
        return (count > 0);
    }

    public boolean restaurantServesCuisine(String cuisine) {
        return textDisplayedInList(getCuisinesTexts(),cuisine);
    }

    public boolean restaurantDisplayedWithName(String name) {
        return textDisplayedInList(getRestaurantNames(),name);
    }
}
/*

    String text = getRestaurantNames().get(0).getText();
        if(!text.contains(name)) {
                int counter = 0;
                do{
                counter++;
                try {
                Thread.sleep(1000);
                text = getRestaurantNames().get(0).getText();
                log.info(counter+ "Restaurant name after wait is "+text);
                } catch (InterruptedException e) {
                e.printStackTrace();
                }
                }while (!text.contains(name) && counter < 5);
        }
*/
