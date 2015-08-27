package ru.fors.odstele.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru Date: 16.08.15
 */
public class ReportsPage extends Page{

	By reportName = By.cssSelector(".main-table__item-second>div>h4>span"); // ��������
																			// �
																			// �����
																			// ������
	By reportCarAtWorkLocator = By.linkText("������� � ������");
	By reportCarOutLocacator = By.linkText("������ ������ ������� �� ���");
	By reportCarAtWorkPeriodLocator = By.linkText("������� � ������ �� ������");
	By reportCarAtWorkAnalysisLocator = By.linkText("������ ������ �������");
	By reportCarOutPeriodLocator = By.linkText("����� ������� �� ������");
	By reportSnowRemovalAnalysisLocator = By.linkText("������ ������ �����");
	By reportSnowRemovalDetailLocator = By.linkText("����������� ������ ����� �� �������");
	By reportStatsMoveLocator = By.linkText("���������� ����������� �������");
	By reportViolationLocator = By.linkText("�������� ���������");
	By reportGpsSignalStatsOdhLocator = By.linkText("���������� ��������� ��������� �� ��������� ���������");
	By sspLoadingReportLocator = By.linkText("������ �������� ������������� ������� (���/���)");
	By notVisitedOdhReportLocator = By.linkText("�������� ���, �� ������� �� �������� �������");
	By reportCarAtWorkPeriodDetailLocator = By.linkText("������� � ������ �� ������ (� ������������) (�������)");
	By reportTrafficLineControlLocator = By.linkText("�������� �������� ������");
	By reportReglamentOperationsSummaryLocator = By
			.linkText("������ � ���������� ������������ ��������, ���������� � ������� �������");
	By buildButton = By.linkText("���������");
	By buildReportNameLocator = By.cssSelector("h3");
	By customerSelectButton = By.xpath("//*[@class='form-table fixed']/tbody/tr[1]/td[4]//a"); // ������
																								// ������
																								// ���������
	By customerFieldInCustomerSelectWindow = By.cssSelector("input[name*='nameOrShortNameLike']"); // ����
																									// ���
																									// �����
																									// ���������
																									// �
																									// ����
																									// ������
																									// ���������
	By findButton = By.linkText("�����"); // ������ ����� � ���� ������
											// ���������
	By resultInCustonerSelectWindow = By.xpath("//div[@class='modal-window']/table/tbody/tr"); // ������
																								// ������
																								// �
																								// �����������
																								// ������
																								// �
																								// ����
																								// ������
																								// ���������
	By selectCustomerButton = By.linkText("������� ���������"); // ������ ������
																// ��������� �
																// ���� ������
	By setPeriodLocator = By.cssSelector("select[name='panel:panel_body:period']"); // �����
																					// �������
																					// ���
																					// ��������
																					// ������
	By reportGpsSignalStatWstLocator = By.linkText("���������� ��������� ��������� �� ��������� ���������"); //������
	By reportGarbageTrackMoveLocator = By.linkText("���������� ����������� ��� ��� ���������� �� �������"); //������
	By carAppearanceYardReportLocator = By.linkText("����� ������� �� �������� ����������"); //�����
	By reportYardCleanState = By.linkText("��������� ������"); //�����
	By reportGpsSignalStatYardLocator = By.linkText("���������� ��������� ��������� �� ��������� ���������"); //�����
	By reportStatMoveYardLocator = By.linkText("���������� ����������� �������"); //�����
	By reportGpsSignalStatOznLocator = By.linkText("���������� ��������� ��������� �� ��������� ���������"); //���
	By reportOznWorksCompletionLocator = By.linkText("���������� �������� ����� ����� �� ���������� �������� ����������"); //���
	By reportCurrentStateOznLocator = By.linkText("������� ��������� �������� ����������"); //���
	By reportCarOutSummaryOznLocator = By.linkText("������� ����� �� ������ �������, ��������������� �� �������� ����������"); //���
	By reportGpsSignal4ProviderLocator = By.linkText("���������� ���������� ��������� � ��������� ���������"); //���������
	By odhContainerLocator = By.xpath("//div[1]/h4/span"); //��������� ���
	By wstContainerLocator = By.xpath("//div[2]/h4/span"); //��������� ������
	By yardContainerLocator = By.xpath("//div[3]/h4/span"); //��������� �����
	By oznContainerLocator = By.xpath("//div[4]/h4/span"); //��������� ���
	By allContainerLocator = By.xpath("//div[5]/h4/span"); //��������� �����


	public ReportsPage(WebDriver driver) {
		super(driver);
	}

	@Step("���������, ��� ����� ����������")
	public boolean isReportBuilds() {
		return isElementPresent(driver, buildReportNameLocator);
	}

	@Step("���������, ��� �������� � ������� �����������")
	public String getBuildReportName() {
		return driver.findElement(reportName).getText();
	}

	@Step("��������� ����� \"������� � ������\"")
	public ReportsPage reportCarAtWorkOpen() {
		driver.findElement(reportCarAtWorkLocator).click();
		return this;
	}

	@Step("��������� ����� \"������� � ������ �� ������\"")
	public ReportsPage reportCarAtWorkPeriodOpen() {
		driver.findElement(reportCarAtWorkPeriodLocator).click();
		return this;
	}

	@Step("��������� ����� \"������ ������ �������\"")
	public ReportsPage reportCarAtWorkAnalysisOpen() {
		driver.findElement(reportCarAtWorkAnalysisLocator).click();
		return this;
	}

	@Step("��������� ����� \"����� ������� �� ������\"")
	public ReportsPage reportCarOutPeriodOpen() {
		driver.findElement(reportCarOutPeriodLocator).click();
		return this;
	}

	@Step("��������� ����� \"������ ������ �����\"")
	public ReportsPage reportSnowRemovalAnalysisOpen() {
		driver.findElement(reportSnowRemovalAnalysisLocator).click();
		return this;
	}

	@Step("��������� ����� \"����������� ������ ����� �� �������\"")
	public ReportsPage reportSnowRemovalDetailOpen() {
		driver.findElement(reportSnowRemovalDetailLocator).click();
		return this;
	}

	@Step("��������� ����� \"���������� ����������� �������\"")
	public ReportsPage reportStatsMoveOpen() {
		driver.findElement(reportStatsMoveLocator).click();
		return this;
	}

	@Step("��������� ����� \"�������� ���������\"")
	public ReportsPage reportViolationOpen() {
		driver.findElement(reportViolationLocator).click();
		return this;
	}

	@Step("��������� ����� \"���������� ��������� ��������� �� ��������� ���������\"")
	public ReportsPage reportGpsSignalStatOdhOpen() {
		driver.findElement(reportGpsSignalStatsOdhLocator).click();
		return this;
	}

	@Step("��������� ����� \"������ �������� ������������� ������� (���/���)\"")
	public ReportsPage sspLoadingReportOpen() {
		driver.findElement(sspLoadingReportLocator).click();
		return this;
	}

	@Step("��������� ����� \"�������� ���, �� ������� �� �������� �������\"")
	public ReportsPage notVisitedOdhReportOpen() {
		driver.findElement(notVisitedOdhReportLocator).click();
		return this;
	}

	@Step("��������� ����� \"������� � ������ �� ������ (� ������������) (�������)\"")
	public ReportsPage reportCarAtWorkPeriodDetailOpen() {
		driver.findElement(reportCarAtWorkPeriodDetailLocator).click();
		return this;
	}

	@Step("������������� ������ ������ - {0}")
	public void setPeriod(String period) {
		Select select = new Select(driver.findElement(setPeriodLocator));
		select.selectByVisibleText(period);
		waitForAjaxIndicatorOff(driver, 6);
	}

	@Step("��������� ����� \"�������� �������� ������\"")
	public ReportsPage reportTrafficLineControlOpen() {
		driver.findElement(reportTrafficLineControlLocator).click();
		return this;
	}

	@Step("��������� ����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\"")
	public ReportsPage reportReglamentOperationsSummaryOpen() {
		driver.findElement(reportReglamentOperationsSummaryLocator).click();
		return this;
	}

	@Step("������ �����")
	public ReportsPage userBuildReport() {
		driver.findElement(buildButton).click();
		return this;
	}

	@Step("���������, ��� ����� ������ ����������")
	public String getBuildReportsName() {
		return driver.findElement(buildReportNameLocator).getText();
	}

	@Step("�������� ��������� {0}")
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
	@Step("��������� ����� \"������ ������ ������� �� ���\"")
	public void reportCarOutTestOpen() {
		click(reportCarOutLocacator);
		
	}
	@Step("������� �� ���������� \"������\"")
	public void clickWstContainer(){
		click(wstContainerLocator);
	}
	
	@Step("������� �� ���������� \"�����\"")
	public void clickYardContainer(){
		click(yardContainerLocator);
	}
	
	@Step("������� �� ���������� \"���\"")
	public void clickOznContainer(){
		click(oznContainerLocator);
	}
	
	@Step("������� �� ���������� \"���\"")
	public void clickOdhContainer(){
		click(odhContainerLocator);
	}
	
	@Step("������� �� ���������� \"�����\"")
	public void clickAllContainer(){
		click(allContainerLocator);
	}
	
	@Step("��������� ����� \"���������� ��������� ��������� �� ��������� ��������� �� �������\"")
	public void reportGpsSignalStatWstOpen() {
		click(reportGpsSignalStatWstLocator);
	}
	
	@Step("��������� ����� \"���������� ����������� ��� ��� ���������� �� �������\"")
	public void reportGarbageTrackMoveOpen() {
		click(reportGarbageTrackMoveLocator);
	}
	
	@Step("��������� ����� \"����� ������� �� �������� ����������\"")
	public void carAppearanceYardReportOpen() {
		click(carAppearanceYardReportLocator);
	}
	
	@Step("��������� ����� \"��������� ������\"")
	public void reportYardCleanOpen() {
		click(reportYardCleanState);
	}
	
	@Step("��������� ����� \"���������� ��������� ��������� �� ��������� ��������� �� ������\"")
	public void reportGpsSignalStatYardOpen() {
		click(reportGpsSignalStatYardLocator);
	}
	
	@Step("��������� ����� \"���������� ����������� �������\"")
	public void reportStatMoveYardOpen() {
		click(reportStatMoveYardLocator);
	}
	
	@Step("��������� ����� \"���������� ��������� ��������� �� ��������� ��������� �� ���\"")
	public void reportGpsSignalStatOznOpen() {
		click(reportGpsSignalStatOznLocator);
	}
	@Step("��������� ����� \"���������� �������� ����� ����� �� ���������� �������� ����������\"")
	public void reportOznWorksCompletion() {
		click(reportOznWorksCompletionLocator);
	}
	@Step("��������� ����� \"������� ��������� �������� ����������\"")
	public void reportCurrentStateOznOpen() {
		click(reportCurrentStateOznLocator);
	}
	@Step("��������� ����� \"������� ����� �� ������ �������, ��������������� �� �������� ����������\"")
	public void reportCarOutSummaryOznOpen() {
		click(reportCarOutSummaryOznLocator);
	}
	@Step("��������� ����� \"���������� ���������� ��������� � ��������� ���������\"")
	public void reportGpsSignal4ProviderOpen() {
		click(reportGpsSignal4ProviderLocator);
	}
}
