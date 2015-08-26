package ru.fors.odstele.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Step;

public class MapPage extends Page {

	
	public MapPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By mapLayer = By.cssSelector("img[src*='GEO.MOSCOW']"); //слой карты
	By userRole = By.xpath("//*[@id='logo']/div/div[2]"); //роль пользователя
	By logoutLink = By.linkText("Выход"); //ссылка "Выход"
	By reportPageLink = By.linkText("Отчеты"); // ссылка для перехода в отчеты
	
	@Step("Проверяем роль пользователя")
	public String getUserRole(){
		waitForElementPresent(driver, userRole, 6);
		System.out.println(driver.findElement(userRole).getText());
		return driver.findElement(userRole).getText();
	}
	
	@Step("Выходим из приложения")
	public MainPage userLogout(){
		click(logoutLink);
		return new MainPage(driver);
	}

	@Step("Пользователь переходит на вкладку отчеты")
	public ReportsPage userGotoReportsPage() {
		driver.findElement(reportPageLink).click();
		return new ReportsPage(driver);
	}

}
