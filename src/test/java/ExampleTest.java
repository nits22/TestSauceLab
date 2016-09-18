import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class ExampleTest {
	
	public static WebDriver driver ;
	public static DesiredCapabilities caps;
	@Test
	public void app1() throws MalformedURLException
	{		
		final String USERNAME = "nits11";
		final String ACCESS_KEY = "e1a437bb-51b0-454e-bf4b-806aa5e17876";
		final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows XP");
		caps.setCapability("result", "passed");
		caps.setCapability("version", "43.0");
		caps.setCapability("name", "app1");
		caps.setCapability("method", "PUT");
		driver = new RemoteWebDriver(new URL(URL), caps);

		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		String Actual = "Facebook - Log In or Sign Up";

		Assert.assertTrue(title==title, "Failssss");

		driver.quit();

	}

	/*@AfterMethod(alwaysRun = true)
	public void shutDownDriver(ITestResult result) throws IOException {
	    
	    Object testbed = null;
		// Update SauceLabs result
	    if(testbed.equals("app1")) {
	        String jobID = ((RemoteWebDriver)driver).getSessionId().toString();
	        SauceREST client = new SauceREST("username", "key");
	        Map<String, Object>sauceJob = new HashMap<String, Object>();
	        sauceJob.put("name", "Test method: "+result.getMethod().getMethodName());
	        if(result.isSuccess()) {
	            client.jobPassed(jobID);
	        } else {
	            client.jobFailed(jobID);
	        }
	        client.updateJobInfo(jobID, sauceJob);            
	    }
	    driver.manage().deleteAllCookies();
	    driver.quit();
	}*/
}
