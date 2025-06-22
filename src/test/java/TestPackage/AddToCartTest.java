package TestPackage;

import GuiPages.CartPage;
import GuiPages.CatalogSearchPage;
import GuiPages.HomePage;
import Utils.TestDataUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class AddToCartTest extends BaseClass {
    HomePage homePage;
    CatalogSearchPage catalogSearchPage;
    CartPage cartPage;


    @Test
    public void testAddToCart()  {

        String filePath="src/test/resources/testDataFiles/ProductName.json";
        JsonNode rootNode= TestDataUtils.readJsonFile(filePath);
        String searchTerm=TestDataUtils.getStringValue(rootNode,"productName");
        homePage = new HomePage(driver);
        homePage.searchForItem(searchTerm);

        catalogSearchPage = new CatalogSearchPage(driver);
        List< WebElement> results =catalogSearchPage.returnedProducts();
        Assert.assertFalse(results.isEmpty(), "BUG: No products found for search term!");

        String fileProductDetailsPath="src/test/resources/testDataFiles/productDetails.json";
        JsonNode rootNodeDetails=TestDataUtils.readJsonFile(fileProductDetailsPath);

        int productNumber=rootNodeDetails.get("productNumber").asInt();
        String productSize=rootNodeDetails.get("Size").asText();
        String productColor=rootNodeDetails.get("Color").asText();
        catalogSearchPage.AddItemToCart(productNumber,productSize,productColor);
        Assert.assertTrue(catalogSearchPage.isAddToCartMessageDisplayed(),"BUG: Add to cart message was not displayed!");

        catalogSearchPage.clickOnShowCart();
        cartPage=new CartPage(driver);
        cartPage.clickOnProceedToCheckOut();


    }
}
