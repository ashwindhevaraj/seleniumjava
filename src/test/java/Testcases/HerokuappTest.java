package Testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

//import com.sun.tools.sjavac.Log;

import pages.Baseclass;
import pages.Herokuapppages;
import pages.Homepage;

import static org.testng.AssertJUnit.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


class HerokuappTest extends BaseTest {
	public Herokuapppages heropage;
	@BeforeTest
	public void setup() {
		heropage=new Herokuapppages(driver);
	}
	@AfterTest
	public void rampdown() {
		teardown();
	}
	
	@Test()
	public void test_heroapp() throws IOException {
		
		//this line extracts data from resource bundle available in src/main/resources/config.properties
		ResourceBundle rb=ResourceBundle.getBundle("config");
		System.out.println(rb.getString("username"));
		driver.get("https://the-internet.herokuapp.com");
		//heropage.brokenimagehandler();
		//heropage.tabledataprint();
		//heropage.contextoperation();
		//heropage.draganddrop();
		heropage.frameoperations();
		Assert.assertEquals(true, true);
	}

}

