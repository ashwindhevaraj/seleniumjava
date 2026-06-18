package base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import locators.Alertsclass;
import utilities.Waitutils;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected Waitutils waitutils;

    public BasePage(WebDriver driver) {
    	this.driver=driver;
    	//this.waitutils=new Waitutils();
    }
    public void scroll(By locator) {
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }
    public void browserCommands() {
		//1.driver.get()
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		//4.driver.close();
		//5.driver.quit();
		}
    public void click(By locator) {
    	Waitutils.click(driver,locator);
    }
    public void type(By locator,String value) {
    	Waitutils.type(driver, locator, value);
    }
    public Alert switchtoalert() {
    	return driver.switchTo().alert();
    }
    public void switchtoframe(String frameid) {
    	driver.switchTo().frame(frameid);
    }
    public String gettext(By locator) {
    	return driver.findElement(locator).getText();
    }
    public void switchtodefaultcontent() {
    	driver.switchTo().defaultContent();
    }
    public boolean isselectedcheck(By locator) {
    	return driver.findElement(locator).isSelected();
    }
    public boolean isdisplayedcheck(By locator) {
    	return driver.findElement(locator).isDisplayed();
    }
    public boolean isenabledcheck(By locator) {
    	return driver.findElement(locator).isEnabled();
    }
    public void refresh() {
    	driver.navigate().refresh();
    }
}