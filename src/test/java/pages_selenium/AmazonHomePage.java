package pages_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage extends PageObject {
    private final String AMAZON_BASE_URL = "https://www.amazon.com/";
    private By searchField = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    // Navigate to amazon homepage
    public void navigateToAmazonHomePage() {
        driver.get(AMAZON_BASE_URL);
    }

    // Input search text
    public void enterSearch(String searchText) {
        waitForElementToAppear(searchField);
        driver.findElement(searchField).sendKeys(searchText);
    }

    // Click search button
    public AmazonHomePage_SearchResults clickSearch() {
        waitForElementToAppear(searchButton);
        driver.findElement(searchButton).click();
        return new AmazonHomePage_SearchResults(driver);
    }
}
