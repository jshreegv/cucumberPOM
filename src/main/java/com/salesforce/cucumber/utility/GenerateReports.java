package com.salesforce.cucumber.utility;

import static com.salesforce.cucumber.utility.Constants.GENERATE_REPORT_PATH;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.salesforce.cucumber.utility.GenerateReports;

public class GenerateReports {

	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	private static GenerateReports ob;
	static String testcaseName = null;
	
	private GenerateReports() {
		
	}
	
	public static GenerateReports getInstance() {
		if(ob==null) {
			ob=new GenerateReports();
		}
		return ob;
	}

	public void startExtentReport() {
		htmlReporter = new ExtentHtmlReporter(GENERATE_REPORT_PATH);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Salesforce");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Jayashree");

		htmlReporter.config().setDocumentTitle("Test Execution Report");
		htmlReporter.config().setReportName("Salesforce Regression Test");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public void startSingleTestReport(String testName) {
		testcaseName = testName;
		logger = extent.createTest(testName);
	}

	public void logTestInfo(String message) {
		logger.log(Status.INFO, message);
	}

	public void logTestpassed() {
		logger.log(Status.PASS, MarkupHelper.createLabel(testcaseName + "is pass Test", ExtentColor.GREEN));
	}

	public void logTestFailed() {
		logger.log(Status.FAIL, MarkupHelper.createLabel(testcaseName + "is not pass Test", ExtentColor.RED));
	}

	public void endTestReport() {
		extent.flush();
	}
}
