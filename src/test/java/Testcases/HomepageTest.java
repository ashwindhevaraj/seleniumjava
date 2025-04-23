package Testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Baseclass;
import pages.Homepage;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;


class HomepageTest extends Baseclass {
	private Homepage hmpage;
	@BeforeClass
	public void setupTest() {
		browserSetup("chrome");
		hmpage=new Homepage(driver,waits);
	}
	@AfterClass
	public void rampdown() {
		teardown();
	}
	@DataProvider(name="logindata")
	public Object[][] createdata(){
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"problem_user","secret_sauce"}
			};
	}
	@Test()
	public void test_login() {
		//this line extracts data from resource bundle available in src/main/resources/config.properties
		ResourceBundle rb=ResourceBundle.getBundle("config");
		System.out.println(rb.getString("username"));
		openurl("https://demoqa.com/");		
		//hmpage.alerthandling();
		//hmpage.switchingframes();
		//browserCommands();
		//navigationCommands();
		//hmpage.radiobuttonhandling();
		//hmpage.checkboxhandling();
		//hmpage.selecthandling();
		//hmpage.oldselecthandling();
		//hmpage.multiselecthandling();
		//hmpage.linktexthandling("Click Here for Valid Link");
		hmpage.mouseactions();
		Assert.assertEquals(true, true);
	}

}

