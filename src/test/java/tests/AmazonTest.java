package tests;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class AmazonTest {
    public WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

    @Test
    public void priceTest() {
        // 1. Visit amazon.com Page
        AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.navigateToAmazonHomePage();

        // 2. Search for Book 'qa testing for beginners'
        amazonHomePage.enterSearch("qa testing for beginners");
        AmazonHomePage_SearchResults amazonHomePage_searchResults = amazonHomePage.clickSearch();

        // 3. Click on 1st item in the listed results
        String searchResultPrice = amazonHomePage_searchResults.getFirstResultPriceText();
        amazonHomePage_searchResults.clickFirstResult();

        // 4. Before Click on add to cart Add to Cart assert price from Step3
        AmazonProductPage amazonProductPage = new AmazonProductPage(driver);
        String productPagePrice = amazonProductPage.getProductPagePriceText();
        Assert.assertEquals(searchResultPrice, productPagePrice);

        // 5. Click on Add to Cart.
        AmazonProductPage_ProductConfirmation amazonProductPage_productConfirmation = amazonProductPage.clickAddToCartButton();

        // 6. Before Click on cart page assert price from Step3.
        String cartSubtotalPrice = amazonProductPage_productConfirmation.getCartSubtotalPriceText();
        Assert.assertEquals(searchResultPrice, cartSubtotalPrice);

        // 7. Click on cart button
        amazonProductPage_productConfirmation.clickCartPageButton();

        // 8. On the cart page assert price from Step3.
        AmazonCartPage amazonCartPage = new AmazonCartPage(driver);
        String cartPagePrice = amazonCartPage.getCartPagePriceText();
        Assert.assertEquals(searchResultPrice, cartPagePrice);
    }

   @AfterMethod
   public void teardown() {
        driver.close();
        driver.quit();
   }
}
