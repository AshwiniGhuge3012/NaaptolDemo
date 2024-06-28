package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports configureReports() {

		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter htmlreporter = new ExtentSparkReporter("Extent_Reports.html");
		reports.attachReporter(htmlreporter);

		reports.setSystemInfo("SuiteName", "Regression");
		reports.setSystemInfo("Createdby", "Ashwini");
		return reports;

	}

}
