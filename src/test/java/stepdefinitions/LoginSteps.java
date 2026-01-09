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

        @Given("I am in the login page of the Askohmdch web app")
        public void i_am_in_the_login_page_of_the_askohmdch_web_app() {
            driver.get("https://askomdch.com/account/");
        }

        @When("I enter valid credentials {string} {string}")
        public void i_enter_valid_credentials(String username, String password) {
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.name("login")).click();
        }

        @Then("I should be taken to the dashboard page")
        public void i_should_be_taken_to_the_dashboard_page() {
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

