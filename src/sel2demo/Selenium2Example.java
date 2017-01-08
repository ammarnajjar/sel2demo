package sel2demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Ammar Najjar
 *
 */
public class Selenium2Example {

	public static void main(String[] args) {
		// direct the project to the geckodriver path		
		System.setProperty("webdriver.gecko.driver", System.getenv("GECKO_PATH"));
		
		// create a new instance of the Firefox driver
	    DesiredCapabilities capabilities=DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
	    WebDriver driver = new FirefoxDriver(capabilities);
	    
		// WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
	
		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("Cheese!");
		element.submit();
		System.out.println("Page title is_: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

		System.out.println("Page title is: " + driver.getTitle());
		driver.quit();

	}

}
