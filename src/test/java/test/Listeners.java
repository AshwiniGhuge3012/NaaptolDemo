package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utility.Reports;

public class Listeners extends BaseTest implements ITestListener {

	private static ThreadLocal<ExtentTest> test1 = new ThreadLocal<>();

	public void onStart(ITestContext result) {
		reports = Reports.configureReports();
	}

	public void onFinish(ITestContext result) {
		reports.flush();
	}

	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = reports.createTest(result.getMethod().getMethodName());
		test1.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName());
	}

}