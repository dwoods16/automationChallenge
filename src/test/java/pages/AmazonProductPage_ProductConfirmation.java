package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage_ProductConfirmation extends AmazonHomePage {
    private final By cartSubtotalPrice = By.xpath("//div[@class='a-row a-spacing-micro']//span[@class='a-color-price hlb-price a-inline-block a-text-bold']");
    private final By cartPageButton = By.xpath("//a[@id='hlb-view-cart-announce']");

    public AmazonProductPage_ProductConfirmation(WebDriver driver) {
        super(driver);
    }

    // Get cart subtotal price text
    public String getCartSubtotalPriceText() {
        return driver.findElement(cartSubtotalPrice).getAttribute("textContent");
    }

    // Click cart page button
    public void clickCartPageButton() {
        driver.findElement(cartPageButton).click();
    }
}
