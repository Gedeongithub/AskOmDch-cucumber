package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver = Hooks.driver;

    @Given("the customer is on the login page of app")
    public void the_customer_is_on_the_login_page_of_app() {
        driver.get("https://askomdch.com/account/");
    }

    @When("the customer enters valid credentials")
    public void the_customer_enters_valid_credentials() {
        driver.findElement(By.id("username")).sendKeys("fuad");
        driver.findElement(By.id("password")).sendKeys("fuad");
        driver.findElement(By.name("login")).click();
    }

    @Then("the customer should be taken to the dashboard page")
    public void the_customer_should_be_taken_to_the_dashboard_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement overview = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#post-1235 div.woocommerce p:nth-child(2)")
        ));
        overview.isDisplayed();

        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
        logout.click();
        driver.quit();
    }

}