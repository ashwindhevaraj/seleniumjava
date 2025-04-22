package locators;

import org.openqa.selenium.By;

public class Alertsclass {
	public static By alerticon= By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");
	public static By alertleftmenu= By.xpath("//span[text()='Alerts']");
	public static By firstclickme = By.id("alertButton");
	public static By timeralert = By.id("timerAlertButton");
	public static By confirmbutton= By.id("confirmButton");
	public static By promptbutton = By.id("promtButton");
    public static By frameleftmenu = By.xpath("(//span[contains(text(),'Frames')])[1]");
    public static By biggerframelocator = By.id("sampleHeading");
}
