package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage extends PageObject {
    private final String AMAZON_BASE_URL = "https://www.amazon.com/";
    private By searchField = By.xpath("//input[@id='twotabsearchtextbox']");
    private By searchButton = By.xpath("//input[@id='nav-search-submit-button']");

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    // Navigate to amazon homepage
    public void navigateToAmazonHomePage() {
        driver.get(AMAZON_BASE_URL);
    }

    // Input search text
    public void enterSearch(String searchText) {
        driver.findElement(searchField).sendKeys(searchText);
    }

    // Click search button
    public AmazonHomePage_SearchResults clickSearch() {
        driver.findElement(searchButton).click();
        return new AmazonHomePage_SearchResults(driver);
    }
}
