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
import locators.Alertsclass;
import pages.Baseclass;
public class Homepage extends Baseclass{
	private WebDriver driver1;
	public Wait<WebDriver> waits;
	public Homepage(WebDriver driver,WebDriverWait wait){
	    driver1=driver;
		this.waits=wait;
	}
    //This method will handle all types of alert and as part of learning this is the first topic
    public void alerthandling(){
    	WebElement alerticon1=driver1.findElement(Alertsclass.alerticon);
    	waits.until(d ->alerticon1.isDisplayed());
    	alerticon1.click();    	
    	WebElement alertleftmenu1=driver1.findElement(Alertsclass.alertleftmenu);
    	waits.until(d ->alertleftmenu1.isDisplayed());
    	alertleftmenu1.click();
    	WebElement firstclickme1=driver1.findElement(Alertsclass.firstclickme);
    	waits.until(d ->firstclickme1.isDisplayed());
    	firstclickme1.click();
    	String text=driver1.switchTo().alert().getText();
    	System.out.println(text);
    	driver1.switchTo().alert().accept();
    	WebElement timeralert1 = driver1.findElement(Alertsclass.timeralert);
    	timeralert1.click();
    	waits.until(ExpectedConditions.alertIsPresent()); //for alert to present in screen- we need to use explicit wait and no implicit wait will work here
    	System.out.println(driver1.switchTo().alert().getText());
    	driver1.switchTo().alert().accept();
    	WebElement confirmbutton1 = driver1.findElement(Alertsclass.confirmbutton);
    	confirmbutton1.click();
    	System.out.println(driver1.switchTo().alert().getText());
    	driver1.switchTo().alert().accept();
    	WebElement promptbox1 = driver1.findElement(Alertsclass.promptbutton);
    	waits.until(d ->promptbox1.isDisplayed());
    	promptbox1.click();
    	waits.until(ExpectedConditions.alertIsPresent());
    	Alert alert=driver1.switchTo().alert();
    	System.out.println(alert.getText());
    	alert.sendKeys("HI i am automation text");
    	alert.accept();
    }
    public void switchingframes() {
    	WebElement alerticon1=driver1.findElement(Alertsclass.alerticon);
    	waits.until(d ->alerticon1.isDisplayed());
    	alerticon1.click();
    	WebElement frameleftmenu1=driver1.findElement(Alertsclass.frameleftmenu);
    	waits.until(d ->frameleftmenu1.isDisplayed());
    	frameleftmenu1.click();
    	driver1.switchTo().frame("frame1");
    	WebElement bigframe1=driver1.findElement(Alertsclass.biggerframelocator);
    	System.out.println(bigframe1.getText());
    	// we need to switch to default before switching to another frame
    	driver1.switchTo().defaultContent();
    	driver1.switchTo().frame("frame2");
    	WebElement bigframe2=driver1.findElement(Alertsclass.biggerframelocator);
    	System.out.println(bigframe2.getText());
    	driver1.switchTo().defaultContent();
    }
    public void elementmenuclick() {
    	WebElement elemenu=driver1.findElement(Elements.elementmenu);
    	waits.until(d ->elemenu.isDisplayed());
    	elemenu.click();
    }
    public void widgetmenuclick() {
    	WebElement widgetmenu1=driver1.findElement(Widgets.widgetmainmenu);
    	//((JavascriptExecutor)driver1).executeScript("arguments[0].scrollIntoView();", widgetmenu1);
    	waits.until(d ->widgetmenu1.isDisplayed());
    	widgetmenu1.click();
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
    	widgetmenuclick();
    	WebElement selectmenu1=driver1.findElement(Widgets.selectmenu);
    	((JavascriptExecutor)driver1).executeScript("arguments[0].scrollIntoView();", selectmenu1);
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
    public void linktexthandling(String text) {
    	elementmenuclick();
    	WebElement linktextmenu = driver1.findElement(Elements.linkmenu);
    	waits.until(d ->linktextmenu.isDisplayed());
    	linktextmenu.click();
    	WebElement linktext1 = driver1.findElement(Elements.linktextreturn(text));
    	waits.until(d ->linktext1.isDisplayed());
    	linktext1.click();
    }
    public void mouseactions() {
    	widgetmenuclick();
    	WebElement tooltipmenu1=driver1.findElement(Widgets.tooltipsubmenu);
    	((JavascriptExecutor)driver1).executeScript("arguments[0].scrollIntoView();", tooltipmenu1);
    	waits.until(d ->tooltipmenu1.isDisplayed());
    	tooltipmenu1.click();
    	WebElement hoverbutton1=driver1.findElement(Widgets.hoverbutton);
    	waits.until(d ->hoverbutton1.isDisplayed());
    	actionclass(driver1,hoverbutton1,"click");
    	WebElement tooltiptext2 = driver1.findElement(Widgets.tooltiptext1);
    	waits.until(d ->tooltiptext2.isDisplayed());
    	System.out.println(tooltiptext2.getText());
    	WebElement hovertext1=driver1.findElement(Widgets.hovertextfield);
    	waits.until(d ->hovertext1.isDisplayed());
    	actionclass(driver1,hovertext1,"movetoelement");
    	try {
    	Thread.sleep(5);}
    	catch(Exception e) {
    		System.out.println(e);
    		}
    	}
    public void slideraction() {
    	String a="90";
    	widgetmenuclick();
    	WebElement slidermenu1=driver1.findElement(Widgets.slidermenu);
    	((JavascriptExecutor)driver1).executeScript("arguments[0].scrollIntoView();", slidermenu1);
    	waits.until(d ->slidermenu1.isDisplayed());
    	slidermenu1.click();
    	WebElement slidertooltip1=driver1.findElement(Widgets.slidertooltip);
    	waits.until(d ->slidertooltip1.isDisplayed());
    	//slidertooltip1.sendKeys("value",a);
    	/*int b[]=new int[2];
    	b=getxandylocation(slidertooltip1);
    	System.out.println(b[0]+" "+b[1]);
    	try {
    		Thread.sleep(5000);
    	}
    	catch(Exception e) {
    		System.out.println("delay");
    	}
    	WebElement sliderfinalbox1=driver1.findElement(Widgets.sliderinputbox);
    	waits.until(d ->sliderfinalbox1.isDisplayed());
    	try {
    		Thread.sleep(2000);
    	}
    	catch(Exception e) {
    		System.out.println("delay");
    	}
    	System.out.println(sliderfinalbox1.getText());
    	System.out.println(sliderfinalbox1.getCssValue("value"));*/
    	actionclass(driver1,slidertooltip1,"movebyoffset");
    	try {
    		Thread.sleep(2000);
    	}
    	catch(Exception e) {
    		System.out.println("delay");
    	}
    }
}
