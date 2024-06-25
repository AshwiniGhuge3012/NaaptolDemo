package test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;



public class Listeners extends BaseTest implements ITestListener{
	

	
	public void onTestStart(ITestResult result) {
	System.out.println("Test Started"+ result.getName());
		

		}
	
	public void onTestSuccess(ITestResult result) {
	System.out.println("Test Passed"+ result.getName());
		
	

		}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed"+ result.getName());
		


}
	public void onTestSkipped(ITestResult result) {
			System.out.println("Test Skipped"+ result.getName());


			
		}


	
	
}