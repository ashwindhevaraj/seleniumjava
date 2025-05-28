package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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

import java.time.Duration;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.asserts.*;


import io.github.bonigarcia.wdm.WebDriverManager;
import locators.Widgets;
public class Baseclass {
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
}
