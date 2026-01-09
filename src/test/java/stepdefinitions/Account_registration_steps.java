package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Account_registration_steps {
    private WebDriver driver = Hooks.driver;
    @Given("I am on the AskOmDch Account page")
    public void i_am_on_the_ask_om_dch_account_page() {
        driver.get("https://askomdch.com/account/");
    }

    @When("I register with {string}, {string} and {string}")
    public void i_register_with_tester_tester_gmail_com_and_tester(String username,String email,String password) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//h2[normalize-space(text())='For Him']"))).perform();
        driver.findElement(By.id("reg_username")).sendKeys(username);
        driver.findElement(By.id("reg_email")).sendKeys(email);
        driver.findElement(By.id("reg_password")).sendKeys(password);
        driver.findElement(By.cssSelector(".woocommerce-Button.woocommerce-button.button.woocommerce-form-register__submit")).click();

    }

    @Then("my account should be created successfully")
    public void my_account_should_be_created_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
    }

}
