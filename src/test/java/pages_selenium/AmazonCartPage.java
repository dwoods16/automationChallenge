package pages_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonCartPage extends PageObject {
    private By cartPagePrice = By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']");

    public AmazonCartPage(WebDriver driver) {
        super(driver);
    }

    // Get cart page price text
    public String getCartPagePriceText() {
        waitForElementToAppear(cartPagePrice);
        return driver.findElement(cartPagePrice).getAttribute("textContent");
    }
}
