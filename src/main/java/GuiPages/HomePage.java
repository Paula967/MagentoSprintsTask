package GuiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By searchBar=By.id("search");
    private final By searchButton=By.cssSelector("button[title='Search']");

    //Actions
    public void searchForItem(String Item){
        sendKeys(searchBar,Item);
        clickElement(searchButton);
    }

}
