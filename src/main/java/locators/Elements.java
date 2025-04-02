package locators;

import org.openqa.selenium.By;

public class Elements{
	public By elementmenu= By.xpath("//h5[contains(text(),'Elements')]");
	public By radiobuttonmenu = By.xpath("//span[contains(text(),'Radio Button')]");
	public By yesoption_rdo = By.xpath("//label[@for='yesRadio']");
	public By impressive_rdo = By.xpath("//label[@for='impressiveRadio']");
	public By no_rdo = By.xpath("//label[@for='noRadio']");
	}