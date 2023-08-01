import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test1 {
	public String username = "krishnachaitanya.thripuraribhotla";
	public String accesskey = "YlLzPDrpfDr9egFlb2fCpLhXUbWriu2Z75htDQuf0cPQWVYKF0";
	public static RemoteWebDriver driver = null;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;

	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("version", "86.0");
		capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any
															// available one
		capabilities.setCapability("build", "Cigniti");
		capabilities.setCapability("name", "Cignititest");
		capabilities.setCapability("visual", "true");
		capabilities.setCapability("video", "true");
		capabilities.setCapability("network", "true");
		capabilities.setCapability("console", "true");

		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testSimple() throws Exception {
		// String url="//www.lambdatest.com/integrations";
		// Change it to production page

		driver.get("https://www.lambdatest.com");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
			driver.quit();
		}
	}
}
