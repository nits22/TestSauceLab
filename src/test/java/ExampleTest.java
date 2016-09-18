import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ExampleTest {

	@Test
	public void app1() throws MalformedURLException
	{
		 final String USERNAME = "nits11";
		  final String ACCESS_KEY = "e1a437bb-51b0-454e-bf4b-806aa5e17876";
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
		  
		    Assert.assertEquals(title,"Facebook - Log In or Sign Up");
		    driver.quit();
		
	}
}
