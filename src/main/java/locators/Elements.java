package locators;

import org.openqa.selenium.By;

public class Elements{
	public static final By elementmenu= By.xpath("//h5[contains(text(),'Elements')]");
	public static final By radiobuttonmenu = By.xpath("//span[contains(text(),'Radio Button')]");
	public static final By yesoption_rdo = By.xpath("//label[@for='yesRadio']");
	public static final By impressive_rdo = By.xpath("//label[@for='impressiveRadio']");
	public static final By no_rdo = By.xpath("//label[@for='noRadio']");
	//checkboxelements
	public static final By checkboxmenu = By.xpath("//span[contains(text(),'Check Box')]");
	public static final By hometoggle = By.xpath("//button[@aria-label='Toggle']");
	public static final By downloadcheckbox = By.xpath("//label[@for='tree-node-downloads']//preceding-sibling::button");
	public static final By excelfiletext = By.xpath("//span[contains(text(),'Excel File.doc')]");
	public static final By linkmenu = By.xpath("//span[contains(text(),'Broken Links - Images')]");
	public static By linktextreturn(String text) {
		return By.linkText(text);
	}
	public static By fileuploadsubmenu = By.xpath("//span[contains(text(),'Upload and Download')]");
	public static By uploadbutton = By.xpath("//input[@id='uploadFile']");
	public static By webtablesubmenu = By.xpath("//span[text()='Web Tables']");
	public static By alldatatable = By.xpath("//div[@class='rt-tbody']//div[@role='gridcell']");
	public static By brokenlinkmenu = By.xpath("//span[text()='Broken Links - Images']");
}