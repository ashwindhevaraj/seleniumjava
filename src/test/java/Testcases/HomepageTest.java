package Testcases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pages.Baseclass;
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
	@DataProvider(name ="excelread1")
	public Object[][] openexcel() throws IOException{
		File f=new File("src/test/resources/testdata.xlsx");
		FileInputStream file = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		Object data[][] = new Object[rowcount-1][colcount];
		for(int i=1;i<rowcount;i++) {
			Row row=sheet.getRow(i);
			for(int j=0;j<colcount;j++) {
				data[i-1][j]=row.getCell(j).toString();
			}
		}
		workbook.close();
		file.close();
		return data;
	}
	@Test()
	public void test_login() throws IOException {
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
		//hmpage.mouseactions();
		//hmpage.slideraction();
		//hmpage.progressbar();
		//hmpage.datepicker("June","2026","9");
		//hmpage.datepicker2("02:30","17");
		//hmpage.keyboardaction();
		//hmpage.fileupload();
		//hmpage.windowhandling();
		//try {
		//	hmpage.webtablehandling();
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//hmpage.brokenlinkcheck();
		hmpage.tooltipvalidations();
		Assert.assertEquals(true, true);
	}
	@Test(dataProvider="excelread1")
	public void testlogin(String username,String password) {
		System.out.println(username+"  "+password);
	}

}

