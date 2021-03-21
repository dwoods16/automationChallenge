package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage_SearchResults extends AmazonHomePage {
    private final By firstResultPrice = By.xpath("//span[@cel_widget_id='MAIN-SEARCH_RESULTS-0']//span[@class='a-offscreen']");
    private final By firstSearchResult = By.xpath("//span[@cel_widget_id='MAIN-SEARCH_RESULTS-0']");

    public AmazonHomePage_SearchResults(WebDriver driver) {
        super(driver);
    }

    // Get first result price text
    public String getFirstResultPriceText() {
        return driver.findElement(firstResultPrice).getAttribute("textContent");
    }

    // Click first result
    public void clickFirstResult() {
        driver.findElement(firstSearchResult).click();
    }
}
