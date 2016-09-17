import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import static org.junit.Assert.*;


public class ExampleTest {

	@Test
	public void app1() throws MalformedURLException
	{
		  final String USERNAME = "nits";
		  final String ACCESS_KEY = "1e9d3e5a-c560-4dda-814d-88d698895884";
		  final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		  DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("platform", "Windows XP");
		    caps.setCapability("version", "43.0");

		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		    /**
		     * Goes to Sauce Lab's guinea-pig page and prints title
		     */

		    driver.get("https://www.facebook.com/");
		  String title = driver.getTitle();
		    
		    assertEquals(title, "Facebook - Log In or Sign Up");
		    driver.quit();
		
	}
}
