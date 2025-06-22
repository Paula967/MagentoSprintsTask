package GuiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends BasePage{


    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By orderID= By.xpath("//div[@class='checkout-success']//p[1]");

    public String OrderMessage(){

        return getText(orderID);

    }
}
