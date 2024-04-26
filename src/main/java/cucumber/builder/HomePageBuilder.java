package cucumber.builder;
import cucumber.pages.HomePage;
import org.openqa.selenium.WebDriver;
public class HomePageBuilder implements Builder {
    private WebDriver driver;
    private String string;
    private Integer integer;
    @Override
    public HomePageBuilder setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }
    @Override
    public HomePageBuilder setString(String string) {
        this.string = string;
        return this;
    }
    @Override
    public HomePageBuilder setInteger(Integer integer) {
        this.integer = integer;
        return this;
    }
    public HomePage createHomePage() {
        return new HomePage(driver, string, integer);
    }
}