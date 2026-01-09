package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class Login_to_view_cart_and_checkout_steps {
    private final WebDriver driver = Hooks.driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://askomdch.com/account/");
    }

    @When("I log on with valid credentials")
    public void i_log_on_with_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
        List<String> listTable = dataTable.asList();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//h2[normalize-space(text())='For Him']"))).perform();
        driver.findElement(By.id("username")).sendKeys(listTable.get(0));
        driver.findElement(By.id("password")).sendKeys(listTable.get(1));
        driver.findElement(By.cssSelector(".woocommerce-button.button.woocommerce-form-login__submit")).click();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(900));


        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//a[normalize-space(text())='Dashboard']")))
        );
    }

    @Then("I open the cart page")
    public void i_open_the_cart_page() {
        driver.get("https://askomdch.com/cart/");
    }

    @Then("I should see products in the cart")
    public void i_should_see_products_in_the_cart() {
        List<WebElement> items = driver.findElements(By.className("product-name"));
        new WebDriverWait(driver,Duration.ofMillis(900)).until(
                ExpectedConditions.visibilityOf(items.get(items.size()-1))
        );
        System.out.println("No prduct: "+(items.size()-1));
        assertEquals("The products in cart are less or more to the actual ones",items.size()-1,4);

    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        List<WebElement> bottomTitles = driver.findElements(By.className("widget-title"));
        new Actions(driver).moveToElement(bottomTitles.get(2));
        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
    }

    @Then("I should be on the checkout page")
    public void i_should_be_on_the_checkout_page() {
        new WebDriverWait(driver,Duration.ofMillis(500)).until(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.id("place_order")))
        );
        String placeOrderButtonText = "PLACE ORDER";
        assertEquals(
                "No place an order button available",driver.findElement(By.id("place_order")).getText(),
                placeOrderButtonText);


    }
}
