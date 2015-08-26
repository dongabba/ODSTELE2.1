package ru.fors.odstele.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import ru.fors.odstele.utils.Browser;
import ru.fors.odstele.utils.PropertyLoader;
import ru.fors.odstele.utils.WebDriverFactory;

public class TestBase {
	
	protected static WebDriver driver;
	public String baseUrl;
	
	@BeforeClass
	public void init(){
		baseUrl = PropertyLoader.loadProperty("site.url");
		Browser browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		driver = WebDriverFactory.getInstance(browser);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyLoader.loadProperty("imp.wait")), TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	
	@AfterClass(alwaysRun = true)
	public void stop() {
		driver.quit();
	}
	
	public static WebDriver getWebDriver(){
		return driver;
	}
	
	
	

}
