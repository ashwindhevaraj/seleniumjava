package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Elements;
import locators.Widgets;

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
    public void elementmenuclick() {
    	WebElement elemenu=driver1.findElement(Elements.elementmenu);
    	waits.until(d ->elemenu.isDisplayed());
    	elemenu.click();
    }
    public void radiobuttonhandling() {
    	elementmenuclick();
    	WebElement radiomenu=driver1.findElement(Elements.radiobuttonmenu);
    	waits.until(d ->radiomenu.isDisplayed());
    	radiomenu.click();
    	WebElement yesopt=driver1.findElement(Elements.yesoption_rdo);
    	//waits.until(d ->yesopt.isDisplayed());
    	//below is the check for radio button is selected or not
    	System.out.println(yesopt.isSelected());
    	yesopt.click();
    	System.out.println(yesopt.isSelected());
    	WebElement impressopt=driver1.findElement(Elements.impressive_rdo);
    	waits.until(d ->impressopt.isDisplayed());
    	impressopt.click();
    	WebElement noopt=driver1.findElement(Elements.no_rdo);
    	waits.until(d ->noopt.isDisplayed());
    	//below is the check for radio button is enabled or disabled
    	System.out.println(noopt.isEnabled());
    }
    public void checkboxhandling() {
    	elementmenuclick();
    	WebElement checkmenu=driver1.findElement(Elements.checkboxmenu);
    	waits.until(d ->checkmenu.isDisplayed());
    	checkmenu.click();
    	WebElement hometoggle1=driver1.findElement(Elements.hometoggle);
    	waits.until(d ->hometoggle1.isDisplayed());
    	hometoggle1.click();
    	WebElement downloadtoggle1=driver1.findElement(Elements.downloadcheckbox);
    	waits.until(d ->downloadtoggle1.isDisplayed());
    	downloadtoggle1.click();
    	WebElement excelfiletext1=driver1.findElement(Elements.excelfiletext);
    	waits.until(d ->excelfiletext1.isDisplayed());
    	excelfiletext1.click();
    }
    public void selecthandling() {
    	elementmenuclick();
    	WebElement widgetmenu1=driver1.findElement(Widgets.widgetmenu);
    	((JavascriptExecutor)driver1).executeScript("arguments[0].scrollIntoView();", widgetmenu1);
    	waits.until(d ->widgetmenu1.isDisplayed());
    	widgetmenu1.click();
    	WebElement selectmenu1=driver1.findElement(Widgets.selectmenu);
    	waits.until(d ->selectmenu1.isDisplayed());
    	selectmenu1.click();
    	WebElement selectdropdown1=driver1.findElement(Widgets.select_by_options);
    	waits.until(d ->selectdropdown1.isDisplayed());
    	selectdropdown1.click();
    	WebElement selectexact=driver1.findElement(Widgets.selectdropdown("Group 1, option 1"));
    	waits.until(d ->selectexact.isDisplayed());
    	selectexact.click();
    }
    public void oldselecthandling() {
    	WebElement oldselect1 = driver1.findElement(Widgets.oldselectdpdown);
    	Select s = new Select(oldselect1);
    	s.selectByVisibleText("Black");
    }
    public void multiselecthandling() {
    	WebElement multi1 = driver1.findElement(Widgets.multiselectdiv);
    	((JavascriptExecutor)driver1).executeScript("arguments[0].scrollIntoView();", multi1);
    	waits.until(d ->multi1.isDisplayed());
    	multi1.click();
    	String s="Green,Blue,Black,Red";
    	String s1[]=s.split(",");
    	for(String v:s1) {
    		WebElement selectexact=driver1.findElement(Widgets.selectdropdowntry(v));
        	waits.until(d ->selectexact.isDisplayed());
        	selectexact.click();
    	}
    		//multi1.sendKeys(v);
    		//multi1.sendKeys(Keys.ENTER);
    	//}
    }
}
