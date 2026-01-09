package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategoryStepDefinitions {
    private final WebDriver driver = Hooks.driver;



    @When("the user selects {string} from the category dropdown")
    public void the_user_selects_from_the_category_dropdown(String category) {
        var tit=driver.findElement(By.cssSelector(".dropdown_product_cat"));
        tit.click();
        Select select=new Select(tit);
        select.selectByValue(category);
    }

    @Then("only products from {string} category should be displayed")
    public void only_products_from_category_should_be_displayed(String category) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.woocommerce-products-header__title.page-title")));

        String firstThreeChars = category.length() >= 3 ? category.substring(0, 3) : category;
        Assert.assertTrue("You are not on the correct page. Expected to see: " + firstThreeChars,
                text.getText().toLowerCase().contains(firstThreeChars));
        System.out.println(text.getText());
    }


}

