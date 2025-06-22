package TestPackage;

import GuiPages.*;
import Utils.TestDataUtils;
import com.fasterxml.jackson.databind.JsonNode;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PaymentTest extends BaseClass{
    HomePage homePage;
    CatalogSearchPage catalogSearchPage;
    CartPage cartPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;
    SuccessPage successPage;

    @Test
    public void testPaymentMethod() throws InterruptedException {

        String filePath="src/test/resources/testDataFiles/ProductName.json";
        JsonNode rootNode= TestDataUtils.readJsonFile(filePath);
        String searchTerm=TestDataUtils.getStringValue(rootNode,"productName");
        homePage = new HomePage(driver);
        homePage.searchForItem(searchTerm);

        catalogSearchPage = new CatalogSearchPage(driver);
        List<WebElement> results =catalogSearchPage.returnedProducts();
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

        shippingPage=new ShippingPage(driver);
        String fileProductShippingPath="src/test/resources/testDataFiles/ShippingInformations.json";
        JsonNode rootNodeShipping= TestDataUtils.readJsonFile(fileProductShippingPath);

        String email= rootNodeShipping.get("emailAddress").asText();
        String firstName=rootNodeShipping.get("firstName").asText();
        String lastName=rootNodeShipping.get("lastName").asText();
        String streetAddress=rootNodeShipping.get("streetAddress").asText();
        String cityName=rootNodeShipping.get("city").asText();
        int postCode=rootNodeShipping.get("postalCode").asInt();
        String countryName=rootNodeShipping.get("country").asText();
        int phoneNumber=rootNodeShipping.get("phoneNumber").asInt();

        shippingPage.fillShippingInfo(email,firstName,lastName
                ,streetAddress,cityName,postCode
                ,countryName,phoneNumber);
        shippingPage.selectShippingMethod();
        shippingPage.clickNext();

        paymentPage=new PaymentPage(driver);
        paymentPage.CompletePaymentMethod();
        successPage=new SuccessPage(driver);
        String actualMessage=successPage.OrderMessage();
        Assert.assertTrue(actualMessage.contains("Your order # is:"),"BUG: Order confirmation message not displayed!");
        System.out.println(actualMessage);

    }
}
