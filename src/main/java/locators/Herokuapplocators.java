package locators;

import org.openqa.selenium.By;

public class Herokuapplocators {
	public static By brokenimagemenu= By.xpath("//a[text()='Broken Images']");
	public static By brokenimages= By.xpath("//img");
	public static By challengingdommenu = By.xpath("//a[text()='Challenging DOM']");
	public static By tablename = By.xpath("//table");
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
}
