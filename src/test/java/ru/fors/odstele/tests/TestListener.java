package ru.fors.odstele.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ru.yandex.qatools.allure.annotations.Attachment;

public class TestListener implements ITestListener {

	TestBase tb;
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		takeAttach();
		tb.close();
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		
	}
	
	@Attachment("ScreenShot")
	public byte[] takeAttach() {
		return ((TakesScreenshot) tb.getWebDriver()).getScreenshotAs(OutputType.BYTES);
	}

}
