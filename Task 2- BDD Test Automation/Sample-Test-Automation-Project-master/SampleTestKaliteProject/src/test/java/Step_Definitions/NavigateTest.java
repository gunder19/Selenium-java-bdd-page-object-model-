package Step_Definitions;

import Pages.Search_Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import Pages.Search_Page;
public class NavigateTest {

    WebDriver driver=null;
    Search_Page Search;
    WebElement element;


    @Given("^Open Browser$")
    public void open_Browser() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    }

    @When("^Navigate Wiki URL$")
    public void navigate_URL() {
        Search= new Search_Page(driver);
        driver.navigate().to(Search.Site_URL);
    }

    @Then("^Type ((?:\"[^\"]*\")+)$")
    public void type_text(String text) {
            text = text.replace('"', ' ');
            Search.setSearch_type(text);
    }

    @Then("^((?:\"[^\"]*\")+) should be seen$")
    public void pageContainsText(String text) {
        driver.getPageSource().contains(text);
    }


    @When("^Click search element$")
    public void click_button() {
        Search_Page Search= new Search_Page(driver);
        Search.setSearch_button();
    }


    @And("^Verify Current Page URL$")
    public void verify_Current_Page_URL() {
        Search_Page Search= new Search_Page(driver);
        Assert.assertEquals(driver.getCurrentUrl(), Search.getURL());
    }

    @Then("^Close Browser$")
    public void close_Browser() {
        driver.close();
        driver.quit();
    }

//    @And("^Verify Current Page \"(.*?)\" URL$")
//    public void verify_Current_Page_URL(String URL) {
//        Assert.assertEquals(driver.getCurrentUrl(), Search.getURL());
//    }


}
