package ru.fors.odstele.tests;

import ru.fors.odstele.pages.LoginPage;
import ru.fors.odstele.pages.MapPage;
import ru.fors.odstele.pages.ReportsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru Date: 16.08.15
 */

public class ReportsDeptTest extends TestBase {



	@BeforeTest
	@Parameters({"username", "password"})
	public void goToReportsPage(String username, String password){
		LoginPage loginPage = new LoginPage(driver);
		MapPage mapPage = loginPage.userLogin(username, password);
		ReportsPage reportsPage = mapPage.userGotoReportsPage();
	}
	
	@BeforeMethod
	@Parameters({"username", "password"})
	public void checkConnections(String username, String password){
		if(driver==null){
			goToReportsPage(username, password);
		}
	}
	
	@Features("������")
	@Stories("����� \"������ ������ ������� �� ���\"")
	@Test
	@Parameters({"contrName", "custName"})
	public void reportCarOut(String contrName, String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutTestOpen();
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ������� �� ��� �� ������"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		
		
	}

	@Features("������")
	@Stories("����� \"������� � ������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarAtWork(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkOpen();
		assertEquals("������� � ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� � ������ ��"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}
	
	@Features("������")
	@Stories("����� \"������� � ������ �� ������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarAtWorkPeriod(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodOpen();
		assertEquals("������� � ������ �� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� � ������ �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"������ ������ �������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarAtWorkAnalysis(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkAnalysisOpen();
		assertEquals("������ ������ �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"����� ������� �� ������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarOutPeriod(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutPeriodOpen();
		assertEquals("����� ������� �� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����� ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"������ ������ �����\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSnowRemovalAnalysis(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("������ ������ �����", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �����\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ����� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �����\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"����������� ������ ����� �� �������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSnowRemovalDetail(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("����������� ������ ����� �� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����������� ������ ����� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����������� ������ ����� �� ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����������� ������ ����� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"�������� ���������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportViolation(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("�������� ���������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� ��������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Parameters({"contrName", "custName", "providerName"})
	@Test
	public void reportGpsSignalStatsOdh(String custName, String contrName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatOdhOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"������ �������� ������������� ������� (���/���)\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSspLoading(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.sspLoadingReportOpen();
		assertEquals("������ �������� ������������� ������� (���/���)", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ �������� ������������� ������� (���/���)\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ �������� ������������� ������� (��� / ���) ��"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("������")
	@Stories("����� \"������� � ������ �� ������ (� ������������) (�������)\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarAtWorkPeriodDetail(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodDetailOpen();
		assertEquals("������� � ������ �� ������ (� ������������) (�������)", reportsPage.getBuildReportName());
		reportsPage.setPeriod("4 ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������ (� ������������) (�������)\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����� �������� � ������ �� ������ (� ������������) (�������)�"));
		reportsPage.userSetProvider(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������ (� ������������) (�������)\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearProviderField();
		reportsPage.userSetContractor(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������ (� ������������) (�������)\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetContractor(custName);
		reportsPage.userSetProvider(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������ (� ������������) (�������)\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"�������� ���, �� ������� �� �������� �������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportNotVisitedOdh(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.notVisitedOdhReportOpen();
		assertEquals("�������� ���, �� ������� �� �������� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���, �� ������� �� �������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� ���, �� ������� �� �������� ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���, �� ������� �� �������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���, �� ������� �� �������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���, �� ������� �� �������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"���������� ����������� �������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportStatsMove(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"�������� �������� ������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportTrafficLineControl(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("�������� �������� ������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� �������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� �������� ������ �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� �������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());

	}

	@Features("������")
	@Stories("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportReglamentOperationsSummary(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportReglamentOperationsSummaryOpen();
		assertEquals("������ � ���������� ������������ ��������, ���������� � ������� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ � ���������� ������������ ��������, ���������� � ������� ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}
	
	@Features("������")
	@Stories("����� \"������ ������ �����\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSnowRemovalAnalysisCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("������ ������ �����", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �����\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ����� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �����\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"����������� ������ ����� �� �������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSnowRemovalDetailCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("����������� ������ ����� �� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"����������� ������ ����� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����������� ������ ����� �� ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����������� ������ ����� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"�������� ���������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportViolationCust(String contrName) {

		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("�������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� ��������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
}
	@Features("������")
	@Stories("����� \"���������� ����������� �������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportStatsMoveCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("����� \"�������� �������� ������\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportTrafficLineControlCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("�������� �������� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� �������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� �������� ������ �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� �������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}
	
	@BeforeGroups(groups="wst")
	public void openWstContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickWstContainer();
	}
	
	@Features("������")
	@Stories("����� \"���������� ��������� ��������� �� ��������� ��������� �� �������\"")
	@Parameters({"contrName", "custName", "providerName"})
	@Test(groups="wst")
	public void report2GpsSignalStatWst(String contrName, String custName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatWstOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findWstOwnerInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findWstCustInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findWstOwnerInReportName());
	}
	
	@Features("������")
	@Stories("����� \"���������� ����������� ��� ��� ���������� �� �������\"")
	@Parameters({"contrName", "custName"})
	@Test(groups="wst")
	public void report1GarbageTrackMove(String contrName, String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGarbageTrackMoveOpen();
		assertEquals("���������� ����������� ��� ��� ���������� �� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� ��� ��� ���������� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� ����������� ����������� ��� ��� ���������� �� ������� �� ������ �"));
		reportsPage.userSetCustomer(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� ��� ��� ���������� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findWstContrInReportName());
	}
	
	@BeforeGroups(groups="yard")
	public void openYardContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickYardContainer();
	}
	
	@Features("������")
	@Stories("����� \"����� ������� �� �������� ����������\"")
	@Parameters({"contrName", "custName"})
	@Test(groups="yard")
	public void carAppearanceYardReport(String contrName, String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.carAppearanceYardReportOpen();
		assertEquals("����� ������� �� �������� ����������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����� ������� �� �������� ���������� ��"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardCustInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("������")
	@Stories("����� \"��������� ������\"")
	@Parameters({"contrName", "custName"})
	@Test(groups="yard")
	public void reportYardClean(String contrName, String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportYardCleanOpen();
		assertEquals("��������� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"��������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("��������� ������ ��"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"��������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"��������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardCustInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"��������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("������")
	@Stories("����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Parameters({"contrName", "custName", "providerName"})
	@Test(groups="yard")
	public void reportGpsSignalStatYard(String contrName, String custName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatYardOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardCustInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("������")
	@Stories("����� \"���������� ����������� ������� �� ������\"")
	@Parameters({"contrName", "custName"})
	@Test(groups="yard")
	public void reportStatMoveYard(String contrName, String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatMoveYardOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@BeforeGroups(groups="ozn")
	public void openOznContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickOznContainer();
	}
	
	@Features("������")
	@Stories("����� \"���������� ��������� ��������� �� ��������� ��������� �� ���\"")
	@Test(groups="ozn")
	public void reportGpsSignalStatOzn() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatOznOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
	}
	
	@Features("������")
	@Stories("����� \"���������� �������� ����� ����� �� ���������� �������� ����������\"")
	@Test(groups="ozn")
	public void reportOznWorksCompletion() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportOznWorksCompletion();
		assertEquals("���������� �������� ����� ����� �� ���������� �������� ����������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� �������� ����� ����� �� ���������� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� �������� ����� ����� �� ���������� �������� ����������"));
	}
	
	@Features("������")
	@Stories("����� \"������� ��������� �������� ����������\"")
	@Test(groups="ozn")
	public void reportCurrentStateOzn() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCurrentStateOznOpen();
		assertEquals("������� ��������� �������� ����������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� ��������� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� ��������� �������� ����������"));
	}
	
	@Features("������")
	@Stories("����� \"������� ����� �� ������ �������, ��������������� �� �������� ����������\"")
	@Test(groups="yard")
	public void reportCarOutSummaryOzn() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutSummaryOznOpen();
		assertEquals("������� ����� �� ������ �������, ��������������� �� �������� ����������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� ����� �� ������ �������, ��������������� �� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� ����� �� ������ �������, ��������������� �� �������� ����������"));
	}
	
	@BeforeGroups(groups="provider")
	public void openAllContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickAllContainer();
	}
	
	@Features("������")
	@Stories("���� ���������, ����� \"���������� ���������� ��������� � ��������� ���������\"")
	@Test(groups="provider")
	public void reportGpsSignal4Provider() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignal4ProviderOpen();;
		assertEquals("���������� ���������� ��������� � ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \" ���������� ���������� ��������� � ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ���������� ��������� � ��������� ��������� ��"));
	}
	
	@Features("������")
	@Stories("���� ������������, ����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Parameters({"contrName", "providerName"})
	@Test
	public void reportGpsSignalStatsWstCust(String contrName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ���������"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue(reportsPage.findWstOwnerInReportName());
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertEquals(true, reportsPage.findProviderInReportName());
	}
	
	@Features("������")
	@Stories("���� ����������������, ����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Parameters({"custName", "providerName"})
	@Test
	public void reportGpsSignalStatsWstContr(String custName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ���������"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue(reportsPage.findWstCustInReportName());
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertEquals(true, reportsPage.findProviderInReportName());
	}
}
