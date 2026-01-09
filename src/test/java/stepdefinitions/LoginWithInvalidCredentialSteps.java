package stepdefinitions;


import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;


import java.util.SplittableRandom;

import static org.junit.Assert.assertEquals;


public class LoginWithInvalidCredentialSteps{

    private WebDriver driver = Hooks.driver;
    private String username;


    @Given("the user is on the Askmodch homepage")
    public void the_user_is_on_the_askmodch_homepage() {
        driver.get("https://askomdch.com/");
    }

    @Given("the user opens the Account menu")
    public void the_user_opens_the_account_menu() {
        driver.findElement(By.linkText("Account")).click();
    }

    @When("the user enters invalid {string} and {string}")
    public void the_user_enters_invalid_credentials(String username, String password) {
        this.username = username;
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("clicks the Login button")
    public void clicks_the_login_button() {
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }

    @Then("an error message is displayed")
    public void an_error_message_is_displayed() {

        String actualMessage = driver
                .findElement(By.cssSelector("ul.woocommerce-error li"))
                .getText();

        String expectedMessage = (
                "Error: The password you entered for the username "
                        + username
                        + " is incorrect. Lost your password?"
        );

        assertEquals("Error message not displayed correctly",expectedMessage, actualMessage);
    }



}
