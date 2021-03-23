package pages_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages_selenium.PageObject;

public class AmazonProductPage extends PageObject {
    private By productPagePrice = By.id("newBuyBoxPrice");
    private By addToCartButton = By.id("add-to-cart-button");

    public AmazonProductPage(WebDriver driver) {
        super(driver);
    }

    // Get first result price text
    public String getProductPagePriceText() {
        waitForElementToAppear(productPagePrice);
        return driver.findElement(productPagePrice).getAttribute("textContent");
    }

    // Click first result
    public AmazonProductPage_ProductConfirmation clickAddToCartButton() {
        waitForElementToAppear(addToCartButton);
        driver.findElement(addToCartButton).click();
        return new AmazonProductPage_ProductConfirmation(driver);
    }
}
