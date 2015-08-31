package ru.fors.odstele.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	By reportReglamentOperationsSummaryLocator = By.linkText("Сводка о выполнении регламентных операций, нарушениях и простое техники");
	By buildButton = By.linkText("Построить");
	By buildReportNameLocator = By.cssSelector("h3");
	By buildReportName2ndLineLocator = By.xpath("//h3/text()[2]"); //вторая строка в шапке отчета
	By buildReportName3rdLineLocator = By.xpath("//h3/text()[3]"); //третья строка в шапке отчета
	By customerSelectButton = By.xpath("//*[@class='form-table fixed']/tbody/tr[1]/td[4]//a"); //кнопка выбора Заказчика
	By customerDeleteButton = By.xpath("//*[@class='form-table fixed']/tbody/tr[1]/td[4]//a[1]"); //кнопка очистки поля Заказчик
	By contractorSelectButton = By.xpath("//*[@class='form-table fixed']/tbody/tr[2]/td[4]//a"); //кнопка выбора Подрядчика
	By contractorDeleteButton = By.xpath("//*[@class='form-table fixed']/tbody/tr[2]/td[4]//a[1]"); //кнопка Очистки поля Подрядчик
	By providerSelectButton = By.xpath("//*[@class='form-table fixed']/tbody/tr[3]/td[4]//a"); //кнопка выбора Поcтавщика
	By providerDeleteButton = By.xpath("//*[@class='form-table fixed']/tbody/tr[3]/td[4]//a[1]"); //кнопка очистки Поcтавщика
	By customerFieldInCustomerSelectWindow = By.cssSelector("input[name*='nameOrShortNameLike']"); // поле для ввода заказчика в окне выбора заказчика
	By findButton = By.linkText("Поиск"); // кнопка поиск в окне выбора заказчика
	By resultInCustonerSelectWindow = By.xpath("//div[@class='modal-window']/table/tbody/tr"); // первая строка в результатах поиска в окне выбора заказчика
	By selectCustomerButton = By.linkText("Выбрать найденное"); // кнопка выбора заказчика в окне поиска
	By setPeriodLocator = By.cssSelector("select[name='panel:panel_body:period']"); // выбор периода для сводного отчета
	By reportGpsSignalStatWstLocator = By.linkText("Статистика получения показаний от мобильных устройств"); //Отходы
	By reportGarbageTrackMoveLocator = By.linkText("Статистика перемещения СТС без назначения на маршрут"); //Отходы
	By carAppearanceYardReportLocator = By.linkText("Выход техники на дворовые территории"); //Дворы
	By reportYardCleanState = By.linkText("Состояние уборки"); //Дворы
	By reportGpsSignalStatYardLocator = By.linkText("Статистика получения показаний от мобильных устройств"); //Дворы
	By reportStatMoveYardLocator = By.linkText("Статистика перемещения техники"); //Дворы
	By reportGpsSignalStatOznLocator = By.linkText("Статистика получения показаний от мобильных устройств"); //ОЗН
	By reportOznWorksCompletionLocator = By.linkText("Выполнение основных видов работ по содержанию объектов озеленения"); //ОЗН
	By reportCurrentStateOznLocator = By.linkText("Текущее состояние объектов озеленения"); //ОЗН
	By reportCarOutSummaryOznLocator = By.linkText("Сводный отчет по выходу техники, задействованной на объектах озеленения"); //ОЗН
	By reportGpsSignal4ProviderLocator = By.linkText("Статистика переданных показаний с мобильных устройств"); //поставщик
	By odhContainerLocator = By.xpath("//div[1]/h4/span"); //контейнер ОДХ
	By wstContainerLocator = By.xpath("//div[2]/h4/span"); //контейнер Отходы
	By yardContainerLocator = By.xpath("//div[3]/h4/span"); //контейнер Дворы
	By oznContainerLocator = By.xpath("//div[4]/h4/span"); //контейнер ОЗН
	By allContainerLocator = By.xpath("//div[5]/h4/span"); //контейнер Общее


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
	
	public boolean findContractorInReportName() {
		return driver.findElement(By.xpath("//h3[contains(.,\"Подрядчик\")]")) != null;
	}
	
	public boolean findCustomerInReportName() {
		return driver.findElement(By.xpath("//h3[contains(.,\"Заказчик\")]")) != null;
	}
	
	public boolean findProviderInReportName() {
		return driver.findElement(By.xpath("//h3[contains(.,\"Поставщик телеметрических услуг\")]")) != null;
	}
	
	public boolean findWstContrInReportName() {
		return driver.findElement(By.xpath("//h3[contains(.,\"Транспортировщик\")]")) != null;
	}
	
	public boolean findWstCustInReportName() {
		return driver.findElement(By.xpath("//h3[contains(.,\"Образователь\")]")) != null;
	}
	
	public boolean findWstOwnerInReportName() {
		return driver.findElement(By.xpath("//h3[contains(.,\"Владелец техники\")]")) != null;
	}
	
	public boolean findYardContrInReportName() {
		return driver.findElement(By.xpath("//h3[contains(.,\"Подрядная организация\")]")) != null;
	}
	
	public boolean findYardCustInReportName() {
		return driver.findElement(By.xpath("//h3[contains(.,\"Балансодержатель\")]")) != null;
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
	public void userSetValue(By element, String value){
		click(element);
		click(customerFieldInCustomerSelectWindow);
		type(customerFieldInCustomerSelectWindow, value);
		click(findButton);
		waitForAjaxIndicatorOff(driver, 6);
		click(resultInCustonerSelectWindow);
		waitForAjaxIndicatorOff(driver, 6);
		click(selectCustomerButton);
		waitForAjaxIndicatorOff(driver, 6);
	}
	
	@Step("Выбираем заказчика {0}")
	public void userSetCustomer(String custName) {
		userSetValue(customerSelectButton, custName);
	}
	
	@Step("Выбираем подрядчика {0}")
	public void userSetContractor(String contrName) {
		userSetValue(contractorSelectButton, contrName);
	}
	
	@Step("Выбираем поставщика {0}")
	public void userSetProvider(String providerName) {
		userSetValue(providerSelectButton, providerName);
	}
	
	@Step("Очищаем поле заказчик")
	public void clearCustomerField(){
		click(customerDeleteButton);
		waitForAjaxIndicatorOff(driver, 6);
	}
	@Step("Очищаем поле подрядчик")
	public void clearContractorField(){
		click(contractorDeleteButton);
		waitForAjaxIndicatorOff(driver, 6);
	}
	
	@Step("Очищаем поле поставщик")
	public void clearProviderField(){
		click(providerDeleteButton);
		waitForAjaxIndicatorOff(driver, 6);
	}
	
	@Step("Открываем отчет \"Сводка выхода техники на ОДХ\"")
	public void reportCarOutTestOpen() {
		click(reportCarOutLocacator);
		
	}
	@Step("Кликаем по контейнеру \"Отходы\"")
	public void clickWstContainer(){
		click(wstContainerLocator);
	}
	
	@Step("Кликаем по контейнеру \"Дворы\"")
	public void clickYardContainer(){
		click(yardContainerLocator);
	}
	
	@Step("Кликаем по контейнеру \"ОЗН\"")
	public void clickOznContainer(){
		click(oznContainerLocator);
	}
	
	@Step("Кликаем по контейнеру \"ОДХ\"")
	public void clickOdhContainer(){
		click(odhContainerLocator);
	}
	
	@Step("Кликаем по контейнеру \"Общее\"")
	public void clickAllContainer(){
		click(allContainerLocator);
	}
	
	@Step("Открываем отчет \"Статистика получения показаний от мобильных устройств по Отходам\"")
	public void reportGpsSignalStatWstOpen() {
		click(reportGpsSignalStatWstLocator);
	}
	
	@Step("Открываем отчет \"Статистика перемещения СТС без назначения на маршрут\"")
	public void reportGarbageTrackMoveOpen() {
		click(reportGarbageTrackMoveLocator);
	}
	
	@Step("Открываем отчет \"Выход техники на дворовые территории\"")
	public void carAppearanceYardReportOpen() {
		click(carAppearanceYardReportLocator);
	}
	
	@Step("Открываем отчет \"Состояние уборки\"")
	public void reportYardCleanOpen() {
		click(reportYardCleanState);
	}
	
	@Step("Открываем отчет \"Статистика получения показаний от мобильных устройств по Дворам\"")
	public void reportGpsSignalStatYardOpen() {
		click(reportGpsSignalStatYardLocator);
	}
	
	@Step("Открываем отчет \"Статистика перемещения техники\"")
	public void reportStatMoveYardOpen() {
		click(reportStatMoveYardLocator);
	}
	
	@Step("Открываем отчет \"Статистика получения показаний от мобильных устройств по ОЗН\"")
	public void reportGpsSignalStatOznOpen() {
		click(reportGpsSignalStatOznLocator);
	}
	@Step("Открываем отчет \"Выполнение основных видов работ по содержанию объектов озеленения\"")
	public void reportOznWorksCompletion() {
		click(reportOznWorksCompletionLocator);
	}
	@Step("Открываем отчет \"Текущее состояние объектов озеленения\"")
	public void reportCurrentStateOznOpen() {
		click(reportCurrentStateOznLocator);
	}
	@Step("Открываем отчет \"Сводный отчет по выходу техники, задействованной на объектах озеленения\"")
	public void reportCarOutSummaryOznOpen() {
		click(reportCarOutSummaryOznLocator);
	}
	@Step("Открываем отчет \"Статистика переданных показаний с мобильных устройств\"")
	public void reportGpsSignal4ProviderOpen() {
		click(reportGpsSignal4ProviderLocator);
	}
	
	
}
