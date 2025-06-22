package TestPackage;

import GuiPages.CatalogSearchPage;
import GuiPages.HomePage;
import Utils.TestDataUtils;
import com.fasterxml.jackson.databind.JsonNode;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TestProductSearchInHomePage extends BaseClass {
    HomePage homePage;
    CatalogSearchPage catalogSearchPage;
    @Test
    public void testProductSearch() throws IOException, InterruptedException {

        String filePath="src/test/resources/testDataFiles/ProductName.json";
        JsonNode rootNode= TestDataUtils.readJsonFile(filePath);
        String searchTerm=TestDataUtils.getStringValue(rootNode,"productName");
        homePage=new HomePage(driver);
        homePage.searchForItem(searchTerm);

        catalogSearchPage=new CatalogSearchPage(driver);
        List<WebElement> results =catalogSearchPage.returnedProducts();
        Assert.assertFalse(results.isEmpty(), "No Elements");
    }

}
