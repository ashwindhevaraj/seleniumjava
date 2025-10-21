package Testcases;
import org.testng.TestListenerAdapter;
import org.testng.ITestResult;

public class Listenerreportcheck extends TestListenerAdapter{
	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println(tr.getName()+"......"+"is passed");
	}
	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println(tr.getName()+"........"+"is skipped");
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println(tr.getName()+"........"+"is failed");
	}

}
// above class extends TestListenerAdapter which implements ITestListener with empty methods
//so here we are overriding our needed methods only
