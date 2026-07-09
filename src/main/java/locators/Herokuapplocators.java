package locators;

import org.openqa.selenium.By;

public class Herokuapplocators {
	public static By brokenimagemenu= By.xpath("//a[text()='Broken Images']");
	public static By brokenimages= By.xpath("//img");
	public static By challengingdommenu = By.xpath("//a[text()='Challenging DOM']");
	public static By tablename = By.xpath("//table");
	public static By tableheadername = By.xpath("//table//thead//tr");
	public static By tabledataname = By.xpath("//table//tbody//tr");
	public static By contextmenu = By.xpath("//a[text()='Context Menu']");
	public static By contextclickelement = By.id("hot-spot");
	public static By draganddropmenu = By.xpath("//a[text()='Drag and Drop']");
	public static By dragoption1 = By.id("column-a");
	public static By dragoption2 = By.id("column-b");
	public static By framemenu = By.xpath("//a[text()='Frames']");
	public static By iframemenu = By.xpath("//a[text()='iFrame']");
	public static By iframeid = By.id("mce_0_ifr");
	public static By iframebody = By.xpath("//body[@id='tinymce']//p");
	public static By nestedframemenu = By.xpath("//a[text()='Nested Frames']");
	public static By frametop = By.xpath("//frame[@name='frame-top']");
	public static By framemiddle = By.xpath("//frame[@name='frame-middle']");
	public static By frametext = By.id("content");
	public static By windowclickherebutton = By.xpath("//a[text()='Click Here']");
	public static By windowmenu = By.xpath("//a[text()='Multiple Windows']");
	public static By childwindowlocator = By.xpath("//div[@class='example']//h3[text()='New Window']");
	public static By hovermenu = By.xpath("//a[text()='Hovers']");
	public static By mouseoverobject = By.xpath("//div[@class='figure'][2]");
	public static By alertmenu = By.xpath("//a[text()='JavaScript Alerts']");
	public static By alertfirstbutton = By.xpath("//button[text()='Click for JS Alert']");
	public static By alertsecondbutton = By.xpath("//button[text()='Click for JS Confirm']");
	public static By alertthirdbutton = By.xpath("//button[@onclick='jsPrompt()']");
	public static By resultofclick = By.cssSelector("#result");
	public static By dropdownmenu = By.xpath("//a[text()='Dropdown']");
	public static By selectdropdown= By.cssSelector("#dropdown");
	public static By keypressmenu = By.xpath("//a[text()='Key Presses']");
	public static By keymessagearea = By.cssSelector("#target");
}
