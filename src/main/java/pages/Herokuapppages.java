package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
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
	mouseoperation("contextclick",Herokuapplocators.contextclickelement);
}
public void mouseoveroperation() {
	click(Herokuapplocators.hovermenu);
	mouseoperation("mouseover",Herokuapplocators.mouseoverobject);
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
public void tabledataextract() {
	click(Herokuapplocators.challengingdommenu);
	WebElement tableheadername = findelement(Herokuapplocators.tableheadername);
	List<WebElement> tableheaders = tableheadername.findElements(By.xpath("//th"));
	int headerindex =0;
	for(int i=0;i<tableheaders.size();i++) {
		if(tableheaders.get(i).getText().equals("Amet")) {
			headerindex=i;
			break;
		}
	}
	WebElement tabledataname1 = findelement(Herokuapplocators.tabledataname);
	List<WebElement> tablebodydata1 = tabledataname1.findElements(By.xpath("//td["+(headerindex+1)+"]"));
	for(int i=0;i<tablebodydata1.size();i++) {
		if(tablebodydata1.get(i).getText().equals("Consequuntur1")) {
			System.out.println("Table data found at row"+(i+1));
		}
	}
}
public void windowhandling() {
	click(Herokuapplocators.windowmenu);
	String mainwindow=getmainwindow();
	click(Herokuapplocators.windowclickherebutton);
	Set<String> windowhandles = windowhandles();
	for(String window:windowhandles) {
		if(!window.equalsIgnoreCase(mainwindow)) {
			switchtowindow(window);
		}
	}
	gettext(Herokuapplocators.childwindowlocator);
	switchtodefault();
	browserCommands();
}
public void alerthandling() {
	Alert alert;
	click(Herokuapplocators.alertmenu);
	click(Herokuapplocators.alertfirstbutton);
	alert=switchtoalert();
	alert.accept();
	click(Herokuapplocators.alertsecondbutton);
	alert=switchtoalert();
	alert.dismiss();
	System.out.println(gettext(Herokuapplocators.resultofclick));
	click(Herokuapplocators.alertthirdbutton);
	alert = switchtoalert();
	alert.sendKeys("testing purpose");
	alert.accept();
	System.out.println(gettext(Herokuapplocators.resultofclick));
}
public void selecthandling() {
	click(Herokuapplocators.dropdownmenu);
	selecthandle(Herokuapplocators.selectdropdown,"Option 2");
}
public void keyhandling() {
	scroll(Herokuapplocators.keypressmenu);
	click(Herokuapplocators.keypressmenu);
	click(Herokuapplocators.keymessagearea);
	mouseoperation("keyupdown",Herokuapplocators.mouseoverobject);
}
}
