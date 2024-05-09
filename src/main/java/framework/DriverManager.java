package framework;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Dineshkumar
 *
 */
public class DriverManager {
	protected static WebDriver driver = null;
	private String url = null;
	private String browserName = null;

	/**
	 * Retrieves the WebDriver instance based on the browser specified in the
	 * environment settings.
	 * 
	 * @return The initialized WebDriver instance.
	 */

	public WebDriver getDriver() {
		browserName = EnvironmentManager.getBrowser("Browser");
		switch (browserName) {
		case "Chrome":
			driver = new ChromeDriver();
			url = EnvironmentManager.getUrl("NY_URL");
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
		case "Edge":
			driver = new EdgeDriver();
			url = EnvironmentManager.getUrl("NY_URL");
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			url = EnvironmentManager.getUrl("NY_URL");
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
		default:
			break;
		}
		return driver;
	}

	public static WebDriver getDriverInstance() {
		return driver;
	}
	
	//This method is added to view the execution flow of the UI
	public static void waitForVisibility() throws Exception {
		Thread.sleep(2000);	
	}
}
