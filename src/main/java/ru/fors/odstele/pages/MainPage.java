package ru.fors.odstele.pages;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends Page {

	
	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("���������, ��� ��������� �� ������� ��������")
	public String getUrl(){
		return driver.getCurrentUrl();
	}

}
