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
	}