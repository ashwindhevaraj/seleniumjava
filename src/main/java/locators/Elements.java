package locators;

import org.openqa.selenium.By;

public class Elements{
	public By elementmenu= By.xpath("//h5[contains(text(),'Elements')]");
	public By radiobuttonmenu = By.xpath("//span[contains(text(),'Radio Button')]");
	public By yesoption_rdo = By.xpath("//label[@for='yesRadio']");
	public By impressive_rdo = By.xpath("//label[@for='impressiveRadio']");
	public By no_rdo = By.xpath("//label[@for='noRadio']");
	//checkboxelements
	public By checkboxmenu = By.xpath("//span[contains(text(),'Check Box')]");
	public By hometoggle = By.xpath("//button[@aria-label='Toggle']");
	public By downloadcheckbox = By.xpath("//label[@for='tree-node-downloads']//preceding-sibling::button");
	public By excelfiletext = By.xpath("//span[contains(text(),'Excel File.doc')]");
	}