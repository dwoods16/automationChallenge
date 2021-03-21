package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage extends PageObject {
    private By productPagePrice = By.xpath("//span[@id='newBuyBoxPrice']");
    private By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");

    public AmazonProductPage(WebDriver driver) {
        super(driver);
    }

    // Get first result price text
    public String getProductPagePriceText() {
        return driver.findElement(productPagePrice).getAttribute("textContent");
    }

    // Click first result
    public AmazonProductPage_ProductConfirmation clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
        return new AmazonProductPage_ProductConfirmation(driver);
    }
}
