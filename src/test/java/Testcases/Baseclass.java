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
	public void chromeSetup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	public void edgeSetup() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}	
}
