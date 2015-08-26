package ru.fors.odstele.pages;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends Page {

	
	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("ѕровер€ем, что оказались на главной странице")
	public String getUrl(){
		return driver.getCurrentUrl();
	}

}
