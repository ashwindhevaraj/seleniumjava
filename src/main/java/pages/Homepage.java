package pages;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.List;

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
import utilities.Screenshot;
import utilities.Waitutils;
import base.BasePage;
public class Homepage extends BasePage{
	public Homepage(WebDriver driver){
		super(driver);
	}
    //This method will handle all types of alert and as part of learning this is the first topic
    /*public void alerthandling(){
    	scroll(Alertsclass.alerticon);
    	click(Alertsclass.alerticon);
    	scroll(Alertsclass.alertleftmenu);
    	System.out.println(Screenshot.captureScreenshot(driver,"loginpage"));
    	click(Alertsclass.alertleftmenu);
    	scroll(Alertsclass.firstclickme);
    	click(Alertsclass.firstclickme);
    	Alert alert=switchtoalert();
    	String text=alert.getText();
    	System.out.println(text);
    	alert.accept();
    	click(Alertsclass.confirmbutton);
    	Alert alert1=switchtoalert();
    	System.out.println(alert1.getText());
    	alert1.accept();
    	click(Alertsclass.promptbutton);
    	Alert alert2=switchtoalert();
    	System.out.println(alert2.getText());
    	alert2.sendKeys("HI i am automation text");
    	alert.accept();
    }
    public void switchingframes() {
    	scroll(Alertsclass.alerticon);
    	click(Alertsclass.alerticon);
    	click(Alertsclass.frameleftmenu);
    	switchtoframe("frame1");
    	System.out.println(gettext(Alertsclass.biggerframelocator));
    	switchtodefaultcontent();
    	switchtoframe("frame2");
    	System.out.println(gettext(Alertsclass.biggerframelocator));
    	switchtodefaultcontent();
    }*/
    public void elementmenuclick() {
    	scroll(Elements.elementmenu);
    	click(Elements.elementmenu);
    }
    
    public void widgetmenuclick() {
    	scroll(Widgets.widgetmainmenu);
    	click(Widgets.widgetmainmenu);
    }
    public void alertmenuclick() {
    	click(Alertsclass.alerticon);
    }
    /*public void radiobuttonhandling() {
    	elementmenuclick();
    	click(Elements.radiobuttonmenu);
    	click(Elements.yesoption_rdo);
    	System.out.println(isselectedcheck(Elements.yesoption_rdo));
    	click(Elements.yesoption_rdo);
    	System.out.println(isselectedcheck(Elements.yesoption_rdo));
    	click(Elements.impressive_rdo);
    	System.out.println(isdisplayedcheck(Elements.no_rdo));
    	System.out.println(isenabledcheck(Elements.no_rdo));
    }
    public void checkboxhandling() {
    	elementmenuclick();
    	refresh();
    	click(Elements.hometoggle);
    	click(Elements.downloadcheckbox);
    	click(Elements.excelfiletext);
    }*/
    public void selecthandling() {
    	widgetmenuclick();
    	refresh();
    	scroll(Widgets.selectmenu);
    	click(Widgets.selectmenu);
    	click(Widgets.select_by_options);
    	click(Widgets.selectdropdown("Group 1, option 1"));
    }
    /*public void oldselecthandling() {
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
    	widgetmenuclick();
    	WebElement slidermenu1=driver1.findElement(Widgets.slidermenu);
    	scrollview(driver1,slidermenu1);
    	waits.until(d ->slidermenu1.isDisplayed());
    	slidermenu1.click();
    	WebElement slidertooltip1=driver1.findElement(Widgets.slidertooltip);
    	waits.until(d ->slidertooltip1.isDisplayed());
    	actionclass(driver1,slidertooltip1,"movebyoffset");
    	WebElement sliderfinalbox1=driver1.findElement(Widgets.sliderinputbox);
    	waits.until(d ->sliderfinalbox1.isDisplayed());
    	System.out.println(sliderfinalbox1.getAttribute("value"));
    }
    public void progressbar() {
    	widgetmenuclick();
    	WebElement progressmenu1 = driver1.findElement(Widgets.progresssubmenu);
    	scrollview(driver1,progressmenu1);
    	waits.until(d ->progressmenu1.isDisplayed());
    	progressmenu1.click();
    	WebElement startstopbtn = driver1.findElement(Widgets.startstopbutton);
    	waits.until(d ->startstopbtn.isDisplayed());
    	startstopbtn.click();
    	WebElement progressreader1 = driver1.findElement(Widgets.progressbarreading);
    	waits.until(ExpectedConditions.textToBePresentInElement(progressreader1,"54"));
    	startstopbtn.click();
    }
    public void datepicker(String month,String year,String day) {
    	widgetmenuclick();
    	WebElement datepickermenu1 = driver1.findElement(Widgets.datepickersubmenu);
    	scrollview(driver1,datepickermenu1);
    	waits.until(d ->datepickermenu1.isDisplayed());
    	datepickermenu1.click();
    	WebElement selectelement1 = driver1.findElement(Widgets.selectdateelement);
    	waits.until(d ->selectelement1.isDisplayed());
    	selectelement1.click();
    	WebElement selectmonthdropdown1 = driver1.findElement(Widgets.selectmonthdropdown);
    	selectdropdown(selectmonthdropdown1,month);
    	WebElement selectyeardropdown1 = driver1.findElement(Widgets.selectyeardropdown);
    	selectdropdown(selectyeardropdown1,year);
    	WebElement dateselect1 = driver1.findElement(Widgets.exactdataselect(day));
    	waits.until(d ->dateselect1.isDisplayed());
    	dateselect1.click();
    	System.out.println(selectelement1.getAttribute("value"));
    }
    public void datepicker2(String time,String day) {
    	widgetmenuclick();
    	WebElement datepickermenu1 = driver1.findElement(Widgets.datepickersubmenu);
    	scrollview(driver1,datepickermenu1);
    	waits.until(d ->datepickermenu1.isDisplayed());
    	datepickermenu1.click();
    	WebElement datetimeelement1 = driver1.findElement(Widgets.dataandtimeelement);
    	waits.until(d ->datetimeelement1.isDisplayed());
    	datetimeelement1.click();
    	WebElement monthdropdown1 = driver1.findElement(Widgets.monthdropdown);
    	monthdropdown1.click();
    	WebElement monthselect1 = driver1.findElement(Widgets.monthselect);
    	waits.until(d -> monthselect1.isDisplayed());
    	monthselect1.click();
    	WebElement yeardropdown1 = driver1.findElement(Widgets.yeardropdownlocal);
    	waits.until(d ->yeardropdown1.isDisplayed());
    	yeardropdown1.click();
    	WebElement yearselect1 = driver1.findElement(Widgets.yearselect);
    	waits.until(d ->yearselect1.isDisplayed());
    	yearselect1.click();
    	WebElement dateselect2 = driver1.findElement(Widgets.exactdataselect(day));
    	waits.until(d ->dateselect2.isDisplayed());
    	dateselect2.click();
    	WebElement timeselect1 = driver1.findElement(Widgets.timeselect(time));
    	scrollview(driver1,timeselect1);
    	waits.until(d ->timeselect1.isDisplayed());
    	timeselect1.click();
    	System.out.println(datetimeelement1.getAttribute("value"));
    }
    public void keyboardaction() {
    	widgetmenuclick();
    	WebElement autocompletemenu1 = driver1.findElement(Widgets.autocompletemenu);
    	scrollview(driver1,autocompletemenu1);
    	waits.until(d ->autocompletemenu1.isDisplayed());
    	autocompletemenu1.click();
    	WebElement autocompletetext1 = driver1.findElement(Widgets.autocompletetextbox);
    	waits.until(d ->autocompletetext1.isDisplayed());
    	actionclass(driver1,autocompletetext1,"keydown");
    	try {
    		Thread.sleep(5000);
    	}
    	catch(Exception e) {
    		System.out.println("kkk");
    	}
    }
    public void fileupload() {
    	elementmenuclick();
    	WebElement fileuploadmenu1 = driver1.findElement(Elements.fileuploadsubmenu);
    	scrollview(driver1,fileuploadmenu1);
    	waits.until(d ->fileuploadmenu1.isDisplayed());
    	fileuploadmenu1.click();
    	WebElement fileuploadbtn1 = driver1.findElement(Elements.uploadbutton);
    	waits.until(d ->fileuploadbtn1.isDisplayed());
    	fileuploadbtn1.sendKeys("//Users//aswdevaraj//Downloads//sampleFile.jpeg");
    	try {
    		Thread.sleep(5000);
    	}
    	catch(Exception e) {
    		System.out.println("kkk");
    	}
    }
    public void windowhandling() {
    	alertmenuclick();
    	WebElement browserwindow1 = driver1.findElement(Alertsclass.browserwindowsubmenu);
    	waits.until(d ->browserwindow1.isDisplayed());
    	browserwindow1.click();
    	String parentwindow = getcurrentwindow(driver1);
    	WebElement newtab1 = driver1.findElement(Alertsclass.newtabbutton);
    	waits.until(d ->newtab1.isDisplayed());
    	newtab1.click();
    	//waits.until(d ->samplehead1.isDisplayed());
    	//newtab1.click();
    	//WebElement samplehead1 = driver1.findElement();
    	windowhandlethings(parentwindow,driver1,Alertsclass.sampleheadingtext);
    	WebElement newwindow1 = driver1.findElement(Alertsclass.newwindow);
    	waits.until(d ->newwindow1.isDisplayed());
    	newwindow1.click();
    	windowhandlethings(parentwindow,driver1,Alertsclass.sampleheadingtext);
    }
    public void webtablehandling()throws Exception {
    	int r=0;
    	elementmenuclick();
    	WebElement webtable1 = driver1.findElement(Elements.webtablesubmenu);
    	waits.until(d ->webtable1.isDisplayed());
    	webtable1.click();
    	List<WebElement> colheader = driver1.findElements(Elements.tablecolheader);
    	System.out.println("No of cols "+colheader.size());
    	List<WebElement> rowheader = driver1.findElements(Elements.tablerowheader);
    	System.out.println("No of rows "+rowheader.size());
    	for(int i=2;i<=4;i++) {
    		By tableexactdata = By.xpath("(//div[@role='row'])["+i+"]//div[5]");
    		String max = driver1.findElement(tableexactdata).getText();
    		NumberFormat f = NumberFormat.getNumberInstance();
    		Number max1 = f.parse(max);
    		int max2= max1.intValue();
    		if(max2>r) {
    			r=max2;
    		}
    	}
    	System.out.println("max salary is "+r);
    	/*List<WebElement> datatable1 = driver1.findElements(Elements.alldatatable);
    	for(WebElement x : datatable1) {
    		if(!(x.getText().toString().contains(" "))) {
    			System.out.println(x.getText().toString());
    		}
    	}*/
    	
   /* }
    public void brokenlinkcheck() throws IOException {
    	elementmenuclick();
    	WebElement brokenlink1 = driver1.findElement(Elements.brokenlinkmenu);
    	scrollview(driver1,brokenlink1);
    	waits.until(d ->brokenlink1.isDisplayed());
    	brokenlink1.click();
    	brokenlink(driver1);
    }
    public void tooltipvalidations() {
    	elementmenuclick();
    	widgetmenuclick();
    	WebElement tooltipmenu1=driver1.findElement(Widgets.tooltipsubmenu);
    	((JavascriptExecutor)driver1).executeScript("arguments[0].scrollIntoView();", tooltipmenu1);
    	waits.until(d ->tooltipmenu1.isDisplayed());
    	tooltipmenu1.click();
    	WebElement hoverbutton1=driver1.findElement(Widgets.hoverbutton);
    	waits.until(d ->hoverbutton1.isDisplayed());
    	actionclass(driver1,hoverbutton1,"hover");
    	WebElement tooltiptext1=driver1.findElement(Widgets.tooltiptext);
    	waits.until(d -> tooltiptext1.isDisplayed());
    	System.out.println(tooltiptext1.getText().toString());
    }*/
}
