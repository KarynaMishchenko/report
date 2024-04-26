package cucumber.builder;

import cucumber.pages.PricingCalculatorPage;
import org.openqa.selenium.WebDriver;

public class PricingCalculatorBuilder {

    private WebDriver driver;
    private String string;
    private Integer integer;

    public PricingCalculatorBuilder setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }
    public PricingCalculatorBuilder setString(String string) {
        this.string = string;
        return this;
    }
    public PricingCalculatorBuilder setInteger(Integer integer) {
        this.integer = integer;
        return this;
    }
    public PricingCalculatorPage createPricingCalculatorPage() {
        return new PricingCalculatorPage(driver, string, integer);
    }
}
