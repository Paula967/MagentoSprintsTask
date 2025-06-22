package GuiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By shippingAndBillingAddress=
            By.xpath("//input[@id='billing-address-same-as-shipping-checkmo']");
    private final By placeOrderButton=
            By.xpath("//button[@title='Place Order']");

    public void CompletePaymentMethod() throws InterruptedException {

        clickElement(shippingAndBillingAddress);
        clickElement(placeOrderButton);

    }
}
