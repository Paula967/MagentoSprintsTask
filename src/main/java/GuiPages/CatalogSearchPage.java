package GuiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CatalogSearchPage extends BasePage{

    //Constructor
    public CatalogSearchPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    protected By addToCartButton;
    protected By productSize;
    protected By productColor;
    private final By addToCartMessage=
            By.xpath("//div[@class='message-success success message']");
    private final By showCartButton =
            By.xpath("//a[normalize-space()='shopping cart']");

    //Actions
    public List<WebElement> returnedProducts()  {

        return driver.findElements(By.xpath("//a[@class='product-item-link']"));
    }

    public void AddItemToCart(int index,String Size, String Color)  {

        productSize=By.xpath("(//li[@class='item product product-item'])["+index+"]/div/div/div/div/div/div[@option-label='"+Size+"']");
        clickElementJS(productSize);

        productColor=By.xpath("(//li[@class='item product product-item'])["+index+"]/div/div/div/div/div/div[@option-label='"+Color+"']");
        clickElementJS(productColor);

        scrollIntoView(productColor);

        addToCartButton=By.xpath("(//button[@title='Add to Cart'])["+index+"]");
        clickElementJS(addToCartButton);

    }

    public boolean isAddToCartMessageDisplayed(){
        return isElementDisplayed(addToCartMessage);
    }

    public void clickOnShowCart(){
        clickElement(showCartButton);
    }

}
