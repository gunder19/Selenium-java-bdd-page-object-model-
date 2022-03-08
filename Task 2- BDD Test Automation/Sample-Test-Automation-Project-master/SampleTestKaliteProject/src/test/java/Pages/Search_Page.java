package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search_Page {

    public String Site_URL="https://en.wikipedia.org/w/index.php?search";

    protected WebDriver driver;

    private By search_button = By.xpath("//span[text()='Search']");

    private By search_text = By.xpath("//*[@id='ooui-php-1']");

    public Search_Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL() {
        return Site_URL;
    }

    public void setSearch_button() {

        driver.findElement(search_button).click();
    }

    public void setSearch_type(String text) {
        if(driver.findElement(search_text).isEnabled() || driver.findElement(search_text).isDisplayed())
            try{
                Thread.sleep(3000);
                driver.findElement(search_text).click();
                driver.findElement(search_text).sendKeys(text);
            }catch (Exception e)
            {
                System.out.print("Error");
            }

    }



}
