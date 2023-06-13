package testNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Test4 implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("on test starts",true);
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("on test success", true);
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("on test failure",true);
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("on test skipped",true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("on Test Failed But With in Success Percentage",true);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("on test failed with timeout",true);
	}

	public void onStart(ITestContext context) {
		Reporter.log("on start of the test case",true);
	}

	public void onFinish(ITestContext context) {
		Reporter.log("on finish of the test case",true);
	}

}
