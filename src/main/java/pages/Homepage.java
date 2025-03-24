package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	private WebDriver driver1;
	public Wait<WebDriver> waits;
	public Homepage(WebDriver driver,WebDriverWait wait){
	    driver1=driver;
		this.waits=wait;
	}
    private By alerticon= By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");
    private By alertleftmenu= By.xpath("//span[text()='Alerts']");
    private By firstclickme = By.id("alertButton");
    private By timeralert = By.id("timerAlertButton");
    private By confirmbutton= By.id("confirmButton");
    private By promptbutton = By.id("promtButton");
    private By frameleftmenu = By.xpath("(//span[contains(text(),'Frames')])[1]");
    private By biggerframelocator = By.id("sampleHeading");
    		//This method will handle all types of alert and as part of learning this is the first topic
    public void alerthandling(){
    	WebElement alerticon1=driver1.findElement(alerticon);
    	waits.until(d ->alerticon1.isDisplayed());
    	alerticon1.click();    	
    	WebElement alertleftmenu1=driver1.findElement(alertleftmenu);
    	waits.until(d ->alertleftmenu1.isDisplayed());
    	alertleftmenu1.click();
    	WebElement firstclickme1=driver1.findElement(firstclickme);
    	waits.until(d ->firstclickme1.isDisplayed());
    	firstclickme1.click();
    	String text=driver1.switchTo().alert().getText();
    	System.out.println(text);
    	driver1.switchTo().alert().accept();
    	WebElement timeralert1 = driver1.findElement(timeralert);
    	timeralert1.click();
    	waits.until(ExpectedConditions.alertIsPresent()); //for alert to present in screen- we need to use explicit wait and no implicit wait will work here
    	System.out.println(driver1.switchTo().alert().getText());
    	driver1.switchTo().alert().accept();
    	WebElement confirmbutton1 = driver1.findElement(confirmbutton);
    	confirmbutton1.click();
    	System.out.println(driver1.switchTo().alert().getText());
    	driver1.switchTo().alert().accept();
    	WebElement promptbox1 = driver1.findElement(promptbutton);
    	waits.until(d ->promptbox1.isDisplayed());
    	promptbox1.click();
    	waits.until(ExpectedConditions.alertIsPresent());
    	Alert alert=driver1.switchTo().alert();
    	System.out.println(alert.getText());
    	alert.sendKeys("HI i am automation text");
    	alert.accept();
    }
    public void switchingframes() {
    	WebElement alerticon1=driver1.findElement(alerticon);
    	waits.until(d ->alerticon1.isDisplayed());
    	alerticon1.click();
    	WebElement frameleftmenu1=driver1.findElement(frameleftmenu);
    	waits.until(d ->frameleftmenu1.isDisplayed());
    	frameleftmenu1.click();
    	driver1.switchTo().frame("frame1");
    	WebElement bigframe1=driver1.findElement(biggerframelocator);
    	System.out.println(bigframe1.getText());
    	// we need to switch to default before switching to another frame
    	driver1.switchTo().defaultContent();
    	driver1.switchTo().frame("frame2");
    	WebElement bigframe2=driver1.findElement(biggerframelocator);
    	System.out.println(bigframe2.getText());
    	driver1.switchTo().defaultContent();
    }
}
