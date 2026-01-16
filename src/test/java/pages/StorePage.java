package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StorePage extends BasePage {

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void openStorePage(){
        load("/store");
    }

    public void addProductToCart(String productName){
        By product = By.xpath("//h2[normalize-space()='"+productName+"']");
        //h2[normalize-space()='Anchor Bracelet']
        By addToCartBtn = By.xpath("//a[contains(@aria-label, 'Add') and contains(@aria-label, '"
                + productName + "')]");

        WebElement productElement =  wait.until(driver ->
                driver.findElement(product));
        System.out.println("Title: "+productElement.getText());
        productElement.findElement(addToCartBtn).click();
    }

    public boolean isProductInCart(String productName){
        return driver.findElements(By.xpath("//td[@class='product-name']//a[normalize-space()='" +productName+ "']")).size()> 0;

    }

}
