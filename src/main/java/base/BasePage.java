package base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import jdk.javadoc.internal.doclets.toolkit.taglets.snippet.Action;
import locators.Alertsclass;
import utilities.Waitutils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

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
    public void switchtoframe(By locator) {
    	driver.switchTo().frame(findelement(locator));
    }
    public String gettext(By locator) {
    	return driver.findElement(locator).getText();
    }
    public void switchtodefaultcontent() {
    	driver.switchTo().defaultContent();
    }
    public void selecthandle(By locator,String visibletext) {
    	Select select = new Select(findelement(locator));
    	select.selectByVisibleText(visibletext);
    	//select.selectByIndex(0);
    	//select.selectByValue(visibletext); <option value ='orange'> orange1</option>
    	//select.getAllSelectedOptions() - return type is List<WebElement>
    	//select.getOptions()- return type is List<WebElement>
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
    public List<WebElement> findelements(By locator){
    	return driver.findElements(locator);
    }
    public WebElement findelement(By locator) {
    	return driver.findElement(locator);
    }
    public void mouseoperation(String action,By locator) {
    	Actions act=new Actions(driver);
    	if(action.equals("contextclick")) {
    	act.contextClick(findelement(locator)).perform();
    	}
    	else if(action.equals("mouseover")) {
    		act.moveToElement(findelement(locator)).perform();
    	}
    	else if(action.equals("keyupdown")) {
    		act.keyDown(Keys.SHIFT).sendKeys("testing").keyUp(Keys.SHIFT).perform();
    	}
    }
    public void draganddropaction(By locator1,By locator2) {
    	Actions act=new Actions(driver);
    	act.dragAndDrop(findelement(locator1),findelement(locator2)).perform();
    }
    public void navigateback() {
    	driver.navigate().back();
    }
    public String getmainwindow() {
    	return driver.getWindowHandle();
    }
    public Set<String> windowhandles(){
    	return driver.getWindowHandles();
    }
    public void switchtowindow(String windowname) {
    	driver.switchTo().window(windowname);
    }
    public void switchtodefault() {
    	driver.switchTo().defaultContent();
    }
}