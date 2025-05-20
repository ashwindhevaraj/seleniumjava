package locators;

import org.openqa.selenium.By;

public class Widgets{
	public static final By widgetmainmenu = By.xpath("//h5[contains(text(),'Widgets')]");
	public static final By widgetmenu= By.xpath("//div[contains(text(),'Widgets')]");
	public static final By selectmenu = By.xpath("//span[text()='Select Menu']");
	//select menu elements
	public static final By select_by_options = By.xpath("//div[@id='withOptGroup']");
	public static By selectdropdown(String text) {
		return By.xpath("//*[contains(text(),'"+text+"')]");
	}
	public static final By oldselectdpdown = By.id("oldSelectMenu");
	public static final By multiselectdiv = By.xpath("//div[contains(text(),'Select...')]");
	public static By selectdropdowntry(String text) {
		return By.xpath("//div[contains(text(),'"+text+"')]");
	}
	public static final By tooltipsubmenu = By.xpath("//span[text()='Tool Tips']");
	public static final By hoverbutton = By.xpath("//button[@id='toolTipButton']");
	public static final By hovertextfield = By.xpath("//input[@id='toolTipTextField']");
	public static final By tooltiptext1 = By.xpath("//div[contains(text(),'You hovered over the Button')]");
	public static final By slidermenu = By.xpath("//span[text()='Slider']");
	public static final By slidertooltip = By.xpath("//input[@class='range-slider range-slider--primary']");
	public static final By sliderinputbox = By.xpath("//input[@id='sliderValue']");
	public static final By startstopbutton = By.xpath("//button[@id='startStopButton']");
	public static final By progresssubmenu = By.xpath("//span[contains(text(),'Progress Bar')]");
	public static final By progressbarreading = By.xpath("//div[@role='progressbar']");
	public static final By datepickersubmenu = By.xpath("//span[contains(text(),'Date Picker')]");
	public static final By selectdateelement = By.xpath("//input[@id='datePickerMonthYearInput']");
	public static final By selectmonthdropdown = By.xpath("//select[@class='react-datepicker__month-select']");
	public static final By selectyeardropdown = By.xpath("//select[@class='react-datepicker__year-select']");
	public static final By exactdataselect(String text) {
		int k=Integer.parseInt(text);
		if(k<10) {
			return By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--00"+text+"')]");
		}
		else
			return By.xpath("//div[contains(@class,'react-datepicker__day react-datepicker__day--0"+text+"')]");
		}
	public static final By dataandtimeelement = By.xpath("//input[@id='dateAndTimePickerInput']");
	public static final By monthdropdown = By.xpath("//div[@class='react-datepicker__month-read-view']");
	public static final By monthselect = By.xpath("//div[@class='react-datepicker__month-option'][2]");
	public static final By yeardropdownlocal = By.xpath("//div[@class='react-datepicker__year-read-view']");
	public static final By yearselect = By.xpath("//div[@class='react-datepicker__year-option'][2]");
	public static final By timeselect(String time) {
		return By.xpath("//li[@class='react-datepicker__time-list-item ' and contains(text(),'"+time+"')]");
	}
	
	}
