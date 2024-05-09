package framework;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Dineshkumar
 *
 */
public class EnvironmentManager {

	private static Properties properties = new Properties();

	static {
		InputStream input = null;
		try {
			properties.load(input = new FileInputStream("src/main/resources/config/config.properties"));
		} catch (Exception e) {
			System.out.println("Exception thrown at EnvironmentManager class static block -" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static String getUrl(String url) {
		return properties.getProperty(url);
	}

	public static String getBrowser(String browser) {
		return properties.getProperty(browser);
	}

	public static String getScreenshot(String status) {
		return properties.getProperty(status);
	}

	public static String getDetails(String status) {
		return properties.getProperty(status);
	}
}