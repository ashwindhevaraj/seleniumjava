package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Factory.Driverfactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	@BeforeSuite
	@Parameters({"browser"})
	public void setupTest(String browser) {
		driver=Driverfactory.createdriver(browser);
	}
	@AfterSuite
	public void teardown() {
		if(driver!=null) {
			//log.info("Closing this method as final step here");
			driver.quit();
		}
		
	}
	public void remoteexecution(AbstractDriverOptions<?> options) {
		try {
			driver=new RemoteWebDriver(new URL("http://192.168.0.105:4444"),options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
