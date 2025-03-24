package Testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.testng.asserts.*;


import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Homepage;
class Baseclass {
	protected WebDriver driver;
	protected WebDriverWait waits;
	public void browserSetup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		//below line used for implicitly wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		waits=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	public void openurl(String url) {
		driver.get(url);
	}
}
