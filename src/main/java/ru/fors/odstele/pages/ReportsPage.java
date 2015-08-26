package ru.fors.odstele.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru Date: 16.08.15
 */
public class ReportsPage extends Page{

	By reportName = By.cssSelector(".main-table__item-second>div>h4>span"); // название
																			// в
																			// шапке
																			// отчета
	By reportCarAtWorkLocator = By.linkText("Техника в работе");
	By reportCarOutLocacator = By.linkText("Сводка выхода техники на ОДХ");
	By reportCarAtWorkPeriodLocator = By.linkText("Техника в работе за период");
	By reportCarAtWorkAnalysisLocator = By.linkText("Анализ работы техники");
	By reportCarOutPeriodLocator = By.linkText("Выход техники за период");
	By reportSnowRemovalAnalysisLocator = By.linkText("Анализ вывоза снега");
	By reportSnowRemovalDetailLocator = By.linkText("Детализация вывоза снега по машинам");
	By reportStatsMoveLocator = By.linkText("Статистика перемещения техники");
	By reportViolationLocator = By.linkText("Протокол нарушений");
	By reportGpsSignalStatsOdhLocator = By.linkText("Статистика получения показаний от мобильных устройств");
	By sspLoadingReportLocator = By.linkText("Анализ загрузки снегосплавных пунктов (ССП/МСП)");
	By notVisitedOdhReportLocator = By.linkText("Перечень ОДХ, на которые не выходила техника");
	By reportCarAtWorkPeriodDetailLocator = By.linkText("Техника в работе за период (с детализацией) (сводный)");
	By reportTrafficLineControlLocator = By.linkText("Контроль движения колонн");
	By reportReglamentOperationsSummaryLocator = By
			.linkText("Сводка о выполнении регламентных операций, нарушениях и простое техники");
	By buildButton = By.linkText("Построить");
	By buildReportNameLocator = By.cssSelector("h3");
	By customerSelectButton = By.xpath("//*[@class='form-table fixed']/tbody/tr[1]/td[4]//a"); // кнопка
																								// выбора
																								// Заказчика
	By customerFieldInCustomerSelectWindow = By.cssSelector("input[name*='nameOrShortNameLike']"); // поле
																									// для
																									// ввода
																									// заказчика
																									// в
																									// окне
																									// выбора
																									// заказчика
	By findButton = By.linkText("Поиск"); // кнопка поиск в окне выбора
											// заказчика
	By resultInCustonerSelectWindow = By.xpath("//div[@class='modal-window']/table/tbody/tr"); // первая
																								// строка
																								// в
																								// результатах
																								// поиска
																								// в
																								// окне
																								// выбора
																								// заказчика
	By selectCustomerButton = By.linkText("Выбрать найденное"); // кнопка выбора
																// заказчика в
																// окне поиска
	By setPeriodLocator = By.cssSelector("select[name='panel:panel_body:period']"); // выбор
																					// периода
																					// для
																					// сводного
																					// отчета


	public ReportsPage(WebDriver driver) {
		super(driver);
	}

	@Step("Проверяем, что отчет построился")
	public boolean isReportBuilds() {
		return isElementPresent(driver, buildReportNameLocator);
	}

	@Step("Проверяем, что страница с отчетом загрузилась")
	public String getBuildReportName() {
		return driver.findElement(reportName).getText();
	}

	@Step("Открываем отчет \"Техника в работе\"")
	public ReportsPage reportCarAtWorkOpen() {
		driver.findElement(reportCarAtWorkLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Техника в работе за период\"")
	public ReportsPage reportCarAtWorkPeriodOpen() {
		driver.findElement(reportCarAtWorkPeriodLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Анализ работы техники\"")
	public ReportsPage reportCarAtWorkAnalysisOpen() {
		driver.findElement(reportCarAtWorkAnalysisLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Выход техники за период\"")
	public ReportsPage reportCarOutPeriodOpen() {
		driver.findElement(reportCarOutPeriodLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Анализ вывоза снега\"")
	public ReportsPage reportSnowRemovalAnalysisOpen() {
		driver.findElement(reportSnowRemovalAnalysisLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Детализация вывоза снега по машинам\"")
	public ReportsPage reportSnowRemovalDetailOpen() {
		driver.findElement(reportSnowRemovalDetailLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Статистика перемещения техники\"")
	public ReportsPage reportStatsMoveOpen() {
		driver.findElement(reportStatsMoveLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Протокол нарушений\"")
	public ReportsPage reportViolationOpen() {
		driver.findElement(reportViolationLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Статистика получения показаний от мобильных устройств\"")
	public ReportsPage reportGpsSignalStatOdhOpen() {
		driver.findElement(reportGpsSignalStatsOdhLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Анализ загрузки снегосплавных пунктов (ССП/МСП)\"")
	public ReportsPage sspLoadingReportOpen() {
		driver.findElement(sspLoadingReportLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Перечень ОДХ, на которые не выходила техника\"")
	public ReportsPage notVisitedOdhReportOpen() {
		driver.findElement(notVisitedOdhReportLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Техника в работе за период (с детализацией) (сводный)\"")
	public ReportsPage reportCarAtWorkPeriodDetailOpen() {
		driver.findElement(reportCarAtWorkPeriodDetailLocator).click();
		return this;
	}

	@Step("Устанавливаем период отчета - {0}")
	public void setPeriod(String period) {
		Select select = new Select(driver.findElement(setPeriodLocator));
		select.selectByVisibleText(period);
		waitForAjaxIndicatorOff(driver, 6);
	}

	@Step("Открываем отчет \"Контроль движения колонн\"")
	public ReportsPage reportTrafficLineControlOpen() {
		driver.findElement(reportTrafficLineControlLocator).click();
		return this;
	}

	@Step("Открываем отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\"")
	public ReportsPage reportReglamentOperationsSummaryOpen() {
		driver.findElement(reportReglamentOperationsSummaryLocator).click();
		return this;
	}

	@Step("Строим отчет")
	public ReportsPage userBuildReport() {
		driver.findElement(buildButton).click();
		return this;
	}

	@Step("Проверяем, что шапка отчета правильная")
	public String getBuildReportsName() {
		return driver.findElement(buildReportNameLocator).getText();
	}

	@Step("Выбираем заказчика {0}")
	public void userSetCustomer(String custName) {
		driver.findElement(customerSelectButton).click();
		driver.findElement(customerFieldInCustomerSelectWindow).click();
		driver.findElement(customerFieldInCustomerSelectWindow).sendKeys(custName);
		driver.findElement(findButton).click();
		waitForAjaxIndicatorOff(driver, 6);
		driver.findElement(resultInCustonerSelectWindow).click();
		waitForAjaxIndicatorOff(driver, 6);
		driver.findElement(selectCustomerButton).click();
		waitForAjaxIndicatorOff(driver, 6);
	}

	public void reportCarOutTestOpen() {
		click(reportCarOutLocacator);
		
	}

}
