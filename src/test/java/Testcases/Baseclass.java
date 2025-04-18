package Testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		waits=new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.manage().window().maximize();
	}
	public void teardown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	public void browserCommands() {
		//1.driver.get()
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		//4.driver.close();
		//5.driver.quit();
		}
	public void navigationCommands() {
		// if we use driver.get()- it wont store browser history and cookies and we cant use below methods
		driver.navigate().to("https://google.com");
		driver.navigate().to("https://google.com/maps");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
	}
	public void scrollview(WebElement element) {
	}
	public void openurl(String url) {
		driver.get(url);
	}
}
