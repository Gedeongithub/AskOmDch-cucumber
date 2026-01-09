package stepdefinitions;

import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Login_steps {
    private final WebDriver driver=Hooks.driver;
    @Given("the customer is on the AskOmDch account page")
    public void i_am_on_the_ask_om_dch_account_page() {
        driver.get("https://askomdch.com/account/");
    }

    @When("the customer logs in with valid credentials")
    public void the_customer_logs_in_with_valid_credentials(DataTable table) {
        List<String> listTable = table.asList();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//h2[normalize-space(text())='For Him']"))).perform();
        driver.findElement(By.id("username")).sendKeys(listTable.get(0));
        driver.findElement(By.id("password")).sendKeys(listTable.get(1));
        driver.findElement(By.cssSelector(".woocommerce-button.button.woocommerce-form-login__submit")).click();

    }

    @Then("the customer is logged to the account")
    public void the_customer_is_logged_to_the_account() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//a[normalize-space(text())='Dashboard']")))
        );

    }

}
