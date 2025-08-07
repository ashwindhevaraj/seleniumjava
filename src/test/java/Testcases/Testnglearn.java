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
@Test
public void testcase1() {
	System.out.println("checking testcase1");
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
@Test(enabled=false)
public void testcase2() {
	Assert.assertEquals(m.message(), "ash");
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