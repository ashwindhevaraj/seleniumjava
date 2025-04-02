package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Elements;

public class Homepage {
	private WebDriver driver1;
	public Wait<WebDriver> waits;
	public Elements ele=new Elements();
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
    public void radiobuttonhandling() {
    	WebElement elemenu=driver1.findElement(ele.elementmenu);
    	waits.until(d ->elemenu.isDisplayed());
    	elemenu.click();
    	WebElement radiomenu=driver1.findElement(ele.radiobuttonmenu);
    	waits.until(d ->radiomenu.isDisplayed());
    	radiomenu.click();
    	WebElement yesopt=driver1.findElement(ele.yesoption_rdo);
    	//waits.until(d ->yesopt.isDisplayed());
    	//below is the check for radio button is selected or not
    	System.out.println(yesopt.isSelected());
    	yesopt.click();
    	System.out.println(yesopt.isSelected());
    	WebElement impressopt=driver1.findElement(ele.impressive_rdo);
    	waits.until(d ->impressopt.isDisplayed());
    	impressopt.click();
    	WebElement noopt=driver1.findElement(ele.no_rdo);
    	waits.until(d ->noopt.isDisplayed());
    	//below is the check for radio button is enabled or disabled
    	System.out.println(noopt.isEnabled());
    }
}
