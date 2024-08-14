package com.comcast.crm.listenerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.genericutility.BaseClass;

public class ListImpClass implements ITestListener, ISuiteListener {

	public ExtentReports report;
	//in future if we go for non functional testing,distributed cross browser testing,cross platform testing static is not advisable.
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		// step1:we have implemented this report to configure the report
		//Every Execution it is going to generate a report with differnt different names and it will not override the Screnshot
		//this is how we can take a backup of every execution.
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Environment information and Create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	//ontestfailure i have implemented a program to take a screenshot if any testcase got failed
	//i wana take a Screenshot
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}
	
	//to create a testcase inside the extentreport onteststart will get executed
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("======>" + result.getMethod().getMethodName() + ">=======");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setText(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"===>Started <===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("======>" + result.getMethod().getMethodName() + ">===END====");
		test.log(Status.PASS,result.getMethod().getMethodName()+"===> COMPLETED <===");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		test.log(Status.FAIL,result.getMethod().getMethodName()+"===> FAILED<===");

//		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
//		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
//		String time = new Date().toString().replace(" ", "_").replace(":", "_");
//		try {
//			FileUtils.copyFile(srcFile, new File("./screenshot/" + testName + "+" + time + ".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// Take ScreenShot
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+time);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+"===> SKIPPED <===");
	}

}
