package cucumber.pages;


import cucumber.builder.HomePageBuilder;
import cucumber.builder.PricingCalculatorBuilder;
import cucumber.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class CommonConditions{

    protected static WebDriver driver;
    protected HomePage homePage;
    protected PricingCalculatorPage pricingCalculatorPage;

    @BeforeMethod()
    public void setUp()
    {
        driver = DriverFactory.getDriver();

        pricingCalculatorPage = new PricingCalculatorBuilder() //builder design pattern
                .setDriver(driver)
                .setString("Pricing test")
                .setInteger(1)
                .createPricingCalculatorPage();
        homePage = new HomePageBuilder() //builder design pattern
                .setDriver(driver)
                .setString("Example String")
                .setInteger(123)
                .createHomePage();
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}