package GuiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShippingPage extends BasePage{

    //Constructor
    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By emailAddress=By.xpath("//form[@data-role='email-with-possible-login']/fieldset/div/div/input");
    private final By firstName=By.cssSelector("input[name='firstname']");
    private final By lastName=By.cssSelector("input[name='lastname']");
    private final By streetAddress=By.cssSelector("input[name='street[0]']");
    private final By city=By.cssSelector("input[name='city']");
    private final By postalCode=By.cssSelector("input[name='postcode']");
    private final By country=By.cssSelector("select[name='country_id']");
    private final By phoneNumber=By.cssSelector("input[name='telephone']");
    private final By shippingRadioButton=By.xpath("//input[@name='ko_unique_2']");
    private final By nextButton=By.xpath("//div[@id='shipping-method-buttons-container']/div/button[@type='submit']");

    public void fillShippingInfo(
            String Email,String fName,String lName
            ,String Address,String cityName,int postCode
            ,String countryName, int Phone)  {

        sendKeys(emailAddress,Email);
        sendKeys(firstName,fName);
        sendKeys(lastName,lName);
        sendKeys(streetAddress,Address);
        sendKeys(city,cityName);
        sendKeys(postalCode,String.valueOf(postCode));
        selectByVisibleText(country,countryName);
        sendKeys(phoneNumber,String.valueOf(Phone));

    }

    public void selectShippingMethod() {
        clickElement(shippingRadioButton);
    }

    public void clickNext() {
        clickElement(nextButton);
    }

}
