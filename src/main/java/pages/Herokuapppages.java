package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import locators.Herokuapplocators;

public class Herokuapppages extends BasePage {
public Herokuapppages(WebDriver driver) {
	super(driver);
}
public void brokenimagehandler() {
	click(Herokuapplocators.brokenimagemenu);
	List<WebElement> broken=findelements(Herokuapplocators.brokenimages);
	for(int i=0;i<broken.size();i++) {
		String src=broken.get(i).getAttribute("src");
		try {
			HttpURLConnection connection=(HttpURLConnection)new URL(src).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int response=connection.getResponseCode();
			if(response>=400)
				System.out.println("Invalid image "+src);
			else
				System.out.println("Valid image "+src);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
public void tabledataprint() {
	click(Herokuapplocators.challengingdommenu);
	WebElement table = findelement(Herokuapplocators.tablename);
	for(WebElement row: table.findElements(By.tagName("tr"))) {
		for(WebElement column:row.findElements(By.xpath("./td | ./th"))) {
			System.out.print(column.getText()+" ");
		}
		System.out.println();
	}
}
public void contextoperation() {
	click(Herokuapplocators.contextmenu);
	mouseoperation(Herokuapplocators.contextclickelement);
}
public void draganddrop() {
	click(Herokuapplocators.draganddropmenu);
	draganddropaction(Herokuapplocators.dragoption1,Herokuapplocators.dragoption2);
}
public void frameoperations() {
	click(Herokuapplocators.framemenu);
	click(Herokuapplocators.iframemenu);
	switchtoframe(Herokuapplocators.iframeid);
	System.out.println(gettext(Herokuapplocators.iframebody));
	navigateback();
	click(Herokuapplocators.nestedframemenu);
	switchtoframe(Herokuapplocators.frametop);
	switchtoframe(Herokuapplocators.framemiddle);
	System.out.println(gettext(Herokuapplocators.frametext));
}
}
