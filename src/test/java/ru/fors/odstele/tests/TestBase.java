package ru.fors.odstele.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ru.fors.odstele.utils.Browser;
import ru.fors.odstele.utils.PropertyLoader;
import ru.fors.odstele.utils.WebDriverFactory;

public class TestBase {
	
	protected WebDriver driver;
	public String baseUrl;
	
	@BeforeTest
	public void init(){
		baseUrl = PropertyLoader.loadProperty("site.url");
		Browser browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		driver = WebDriverFactory.getInstance(browser);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyLoader.loadProperty("imp.wait")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	public void close(){
		driver.close();
	}
	
	public WebDriver getWebDriver(){
		return driver;
	}
	
	
	

}
