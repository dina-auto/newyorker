package framework;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

/**
 * @author Dineshkumar
 */

public class CaptureScreenshot {
	/**
	 * Takes a screenshot of the current WebDriver instance and saves it as a PNG
	 * file with the specified filename. If the screenshot feature is enabled
	 * it captures the screenshot otherwise, it skips the process.
	 * @param driver   The WebDriver instance from which the screenshot is to be taken.
	 * @param filename The filename for the saved screenshot.
	 */

	public static void getScreenshot(WebDriver driver, String filename) throws Exception {
		if (EnvironmentManager.getScreenshot("Status").equals("Yes")) {
			File fis = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(fis, new File(System.getProperty("user.dir") + "\\target\\" + filename + ".png"));
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

	}

}
