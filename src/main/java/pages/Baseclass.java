package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.asserts.*;


import io.github.bonigarcia.wdm.WebDriverManager;
import locators.Widgets;
public class Baseclass {
	protected WebDriver driver;
	//protected WebDriverWait waits;
	protected Wait<WebDriver> waits;
	public static Logger log;
	public void browserSetup(String browser){
		log = LogManager.getLogger(Baseclass.class);
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			log.info("chromedriver setup completed- it will open up");
			//driver=new ChromeDriver(); if you run in local
			ChromeOptions options=new ChromeOptions();
			try {
				driver=new RemoteWebDriver(new URL("http://192.168.0.105:4444"),options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//log.info("edgedriver setup completed- it will open up");
			//driver=new EdgeDriver(); use this if you run in local
			EdgeOptions options = new EdgeOptions();
			try {
				driver=new RemoteWebDriver(new URL("http://192.168.0.105:4444"),options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//below line used for implicitly wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		waits=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(5L))
				.ignoring(NoSuchElementException.class);
		driver.manage().window().maximize();
	}
	public void teardown() {
		if(driver!=null) {
			log.info("Closing this method as final step here");
			driver.quit();
		}
	}
	public void navigationCommands() {
		// if we use driver.get()- it wont store browser history and cookies and we cant use below methods
		driver.navigate().to("https://google.com");
		driver.navigate().to("https://google.com/maps");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
	}
	public void scrollview(WebDriver driver,WebElement element) {
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	public void openurl(String url) {
		driver.get(url);
	}
	public int[] getxandylocation(WebElement element) {
		Point coordinates = element.getLocation();
		int a[]=new int[2];
		a[0] = coordinates.getX();
		a[1] = coordinates.getY();
		return a;
	}
	public void actionclass(WebDriver driver,WebElement element,String acts) {
		Actions act = new Actions(driver);
		Action act2;
		if(acts.equals("movetoelement")) {
			act2=act.moveToElement(element).build();
			act2.perform();
		}
		else if(acts.equals("click")) {
			act2=act.click(element).build();
			act2.perform();
		}
		else if(acts.equals("movebyoffset")) {
			int a[]=getxandylocation(element);
			System.out.println(a[0]+" "+a[1]);
			act2=(Action) act.moveByOffset(a[0]+95,a[1]).click().build();
			act2.perform();
		}
		else if(acts.equals("keydown")) {
			act2=act.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys(acts).build();
			act2.perform();
		}
		else if(acts.equals("hover")) {
			act2=(Action) act.clickAndHold().moveToElement(element).build();
			act2.perform();
		}
	}
	public void selectdropdown(WebElement element,String text) {
		Select s = new Select(element);
    	s.selectByVisibleText(text);
	}
	public String getcurrentwindow(WebDriver driver) {
		return driver.getWindowHandle();
	}
	public void windowhandlethings(String parent,WebDriver driver,By element) {
		Set<String> s=driver.getWindowHandles();
		Iterator<String> s1=s.iterator();
		while(s1.hasNext()) {
			String child = s1.next();
			if(!child.equalsIgnoreCase(parent)) {
				driver.switchTo().window(child);
				WebElement element1=driver.findElement(element);
				//waits.until(d ->element1.isDisplayed());
				System.out.println(element1.getText());
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}
	public void brokenlink(WebDriver driver) throws IOException {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//Iterator<WebElement> link2 = links.iterator();
		for(int i=0;i<links.size();i++) {
			WebElement e1=links.get(i);
			String url=e1.getAttribute("href");
			if(url!=null)
			verifylink(url);
		}
	}
	public void verifylink(String url) throws IOException {
		URL link = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)link.openConnection();
		conn.setConnectTimeout(3000);
		conn.connect();
		if(conn.getResponseCode()==200) {
			System.out.println(url+" - "+conn.getResponseMessage());
		}
		else {
			System.out.println(url+" - "+conn.getResponseMessage()+" is a broken link");
		}
	}
}
