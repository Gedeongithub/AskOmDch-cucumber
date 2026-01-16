package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCartPage(){
        load("/cart");
    }
}
