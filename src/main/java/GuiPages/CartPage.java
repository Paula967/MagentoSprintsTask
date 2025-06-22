package GuiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    //Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }
    //Locators
    private final By proceedToCheckoutButton=By.cssSelector("button[data-role='proceed-to-checkout']");

    //Actions
    public void clickOnProceedToCheckOut(){
        clickElementJS(proceedToCheckoutButton);
    }
}
