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
    	this.waitutils=new Waitutils(driver);
    }
    protected void scroll(By locator) {
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }
}