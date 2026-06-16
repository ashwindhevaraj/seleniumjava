package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Waitutils {
	protected WebDriver driver;
	public Waitutils(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement fluentWait(By locator) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
				
				return wait.until(d->d.findElement(locator));
    }
	/*public static void click(WebDriver driver, By locator) {
        fluentWait(driver, locator).click();
    }
	public static void type(WebDriver driver, By locator, String value) {
        fluentWait(driver, locator).sendKeys(value);
    }*/
	public Alert waitforalert() {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				
				return alert;
	}
}
