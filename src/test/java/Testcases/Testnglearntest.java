package Testcases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Testnglearnings;
public class Testnglearntest extends BaseTest{
	Testnglearnings m = new Testnglearnings("ash");
	@DataProvider(name="testdata")
	public Object[][] checkdata(){
		return new Object[][] {{2,3},{4,5}};
	}
	@DataProvider(name="testdata2")
	public Object[][] checkdata3(){
		return new Object[][] {{new Testdatacheck(8,9)}};
	}
@BeforeMethod
public void beforeMethod() {
   System.out.println("in beforeMethod");
}
@AfterMethod
public void afterMethod() {
   System.out.println("in afterMethod");
}
@BeforeClass
public void beforeClass() {
   System.out.println("in beforeClass");
}
@AfterClass
public void afterClass() {
   System.out.println("in afterClass");
}
@BeforeTest
public void beforeTest() {
   System.out.println("in beforeTest");
}
@AfterTest
public void afterTest() {
   System.out.println("in afterTest");
}
@BeforeSuite
public void beforeSuite() {
   System.out.println("in beforeSuite");
}

@AfterSuite
public void afterSuite() {
   System.out.println("in afterSuite");
}
@Test(groups= {"firstgroup"})
public void testcase1() {
	System.out.println("checking testcase1");
	Assert.assertEquals(m.message(), "ash");
}
@Test(enabled=false, groups= {"firstgroup","secondgroup"})
public void testcase2() {
	System.out.println("checking testcase2");
	Assert.assertEquals(m.message(), "ash");
}
@Test(groups= {"secondgroup"})
public void testcase3() {
	System.out.println("checking testcase3");
	Assert.assertEquals(m.message(), "ash");
}
@Test(expectedExceptions = ArithmeticException.class,groups= {"expectedexceptions"})
public void testcase4() {
	m.checkException();
}
@Test(groups= {"expectedexceptions"},enabled=true)
public void testcase5() {
	m.checkException();
}
@Test(groups= {"expectedexceptions"},dependsOnMethods = {"testcase5"}, enabled=true)
public void testcase6() {
	m.dependsoncheck();
}
@Test(groups= {"expectedexceptions"})
@Parameters("browser")
public void testcase7(String browser) {
	System.out.println("passed this parameter from testng file "+browser);
}
@Test(groups= {"dataprovidercheck"}, dataProvider="testdata")
public void testcase7(Integer i,Integer j) {
	System.out.println("Data from dataprovider "+i+"and another value "+j);
	}
@Test(groups = {"dataprovidercheck"}, dataProvider="testdata2")
public void testcase8(Testdatacheck v) {
	System.out.println(v.getI()+" "+v.getK());
}
}

//in beforeSuite
//in beforeTest
//in beforeClass
//in beforeMethod
//checking testcase1
//in afterMethod
//in afterClass
//in afterTest
//in afterSuite