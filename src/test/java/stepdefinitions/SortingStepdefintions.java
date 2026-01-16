package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SortingStepdefintions {
    private final WebDriver driver = Hooks.driver;
    @Given("the user is on the online shop homepage")
    public void the_user_is_on_the_online_shop_homepage()
    {
        driver.get("https://askomdch.com/store/");
    }
    @When("the user selects {string} from the sorting dropdown")
    public void the_user_selects_from_the_sorting_dropdown(String option) {
        var optionlocator=driver.findElement(By.cssSelector("select.orderby"));
        optionlocator.click();
        Select select= new Select(optionlocator);
        select.selectByVisibleText(option);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }
    @Then("only products from {string} sorting should be displayed")
    public void only_products_from_sorting_should_be_displayed(String option) {
        System.out.println("The products are displayed according to this "+ option.toUpperCase());
        System.out.println(driver.getCurrentUrl());

    }
}
