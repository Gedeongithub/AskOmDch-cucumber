package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class RegistrationSteps {
    private final WebDriver driver = Hooks.driver;
    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        driver.get("https://askomdch.com/account/");
    }

    @When("I register with username {string}, email {string}, and password {string}")
    public void i_register_with_username_email_and_password(String username, String email, String password) {
        driver.findElement(By.id("reg_username")).sendKeys(username);
        driver.findElement(By.id("reg_email")).sendKeys(email);
        driver.findElement(By.id("reg_password")).sendKeys(password);
        driver.findElement(By.cssSelector(".woocommerce-Button.woocommerce-button.button.woocommerce-form-register__submit")).click();
    }

    @Then("I should be taken to Account page")
    public void i_should_be_taken_to_account_page() {
        boolean logoutButtonVisible = driver.findElement(By.xpath("//a[normalize-space(text())='Logout']")).isDisplayed();
        Assert.assertTrue("Account page not displayed!", logoutButtonVisible);
    }

}
