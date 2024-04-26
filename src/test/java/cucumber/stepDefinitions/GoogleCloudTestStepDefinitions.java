package cucumber.stepDefinitions;

import cucumber.builder.PricingCalculatorBuilder;
import cucumber.factory.DriverFactory;
import cucumber.pages.HomePage;
import cucumber.pages.PricingCalculatorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleCloudTestStepDefinitions {
    protected static WebDriver driver;

    private HomePage homePage;
    private PricingCalculatorPage pricingCalculatorPage;

    public GoogleCloudTestStepDefinitions() {
        // Initialize your dependencies here
        driver = DriverFactory.getDriver();
        this.homePage = new HomePage(driver, "test", 5);
    }
    @Given("I am on the Google Cloud home page")
    public void i_am_on_the_google_cloud_home_page() {
        homePage = new HomePage(driver, "Example String", 123);
        homePage.openGoogleCloud();
    }

    @When("I search for {string}")
    public void i_search_for(String searchString) {
        homePage.clickOnSearch();
        homePage.enterTextInSearchBar(searchString);
        homePage.submitSearch();
    }

    @Then("I should see the pricing calculator result")
    public void i_should_see_the_pricing_calculator_result() {
        homePage.selectCalculator();
    }

    @And("I select the pricing calculator result")
    public void i_select_the_pricing_calculator_result() {
        homePage.selectCalculator();
    }

    @And("I enter {string} as the number of instances")
    public void i_enter_number_of_instances(String instances) {
        pricingCalculatorPage = new PricingCalculatorBuilder().setDriver(driver).createPricingCalculatorPage();
        pricingCalculatorPage.enterNumberOfInstances(instances);
    }

    @And("I select the series {string}")
    public void i_select_series(String series) {
        pricingCalculatorPage.clickOnSeries().selectSeries(series);
    }

    @And("I choose machine type {string}")
    public void i_choose_machine_type(String machineType) {
        pricingCalculatorPage.clickOnMachineType().selectMachineType(machineType);
    }

    @And("I add a GPU with type {string}")
    public void i_add_a_gpu_with_type(String gpuType) {
        pricingCalculatorPage.addGPU()
                .clickOnGPUType()
                .selectGPUType(gpuType);
        pricingCalculatorPage.clickOnGPUNumbers()
                .selectGPUNumber();
    }

    @And("I select the number of GPUs")
    public void i_select_the_number_of_gpus() {

    }

    @And("I choose local SSD size {string}")
    public void i_choose_local_ssd_size(String ssdSize) {
        pricingCalculatorPage.clickOnLocalSSD().selectLocalSSD(ssdSize);
    }

    @And("I add the configuration to the estimate")
    public void i_add_the_configuration_to_the_estimate() {
        pricingCalculatorPage.addToEstimate();
    }

    @And("I send the estimate by email")
    public void i_send_the_estimate_by_email() {
        pricingCalculatorPage.emailEstimateClick();
    }
    @And("I enter email value in Email field")
    public void i_enter_email_value(){
        pricingCalculatorPage.emailField("mishcenko@gmail.com");
    }
    @And("I click on Send Email button")
    public void i_click_send_email_button(){
        pricingCalculatorPage.sendEmailButtonClick();
    }

    @Then("I see that prices are up to date")
    public void user_sees_email_your_estimate_form() {
        Assert.assertTrue(pricingCalculatorPage.pricesText().getText().contains("Prices are up to date"));
    }

}
