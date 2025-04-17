package locators;

import org.openqa.selenium.By;

public class Widgets{
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
	}