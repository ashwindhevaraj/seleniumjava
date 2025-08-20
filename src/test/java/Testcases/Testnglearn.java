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
import org.testng.annotations.Test;
import pages.Testnglearnings;
public class Testnglearn {
	Testnglearnings m = new Testnglearnings("ash");
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
@Test(groups= {"expectedexceptions"})
public void testcase5() {
	m.checkException();
}
@Test(groups= {"expectedexceptions"},dependsOnMethods = {"testcase5"}, alwaysRun = true)
public void testcase6() {
	m.dependsoncheck();
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