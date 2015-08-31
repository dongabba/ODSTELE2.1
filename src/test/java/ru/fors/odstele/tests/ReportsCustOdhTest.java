package ru.fors.odstele.tests;

import ru.fors.odstele.pages.LoginPage;
import ru.fors.odstele.pages.MapPage;
import ru.fors.odstele.pages.ReportsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru Date: 16.08.15
 */

public class ReportsCustOdhTest extends TestBase {



	@BeforeTest
	@Parameters({"username", "password"})
	public void goToReportsPage(String username, String password){
		LoginPage loginPage = new LoginPage(driver);
		MapPage mapPage = loginPage.userLogin(username, password);
		ReportsPage reportsPage = mapPage.userGotoReportsPage();
		assertEquals("������ ������ ������� �� ���", reportsPage.getBuildReportName());
	}
	
	@BeforeMethod
	@Parameters({"username", "password"})
	public void checkConnections(String username, String password){
		if(driver==null){
			goToReportsPage(username, password);
		}
	}
	
	@Features("������")
	@Stories("���� �������� �� ���, ����� \"������ ������ ������� �� ���\"")
	@Test
	@Parameters({"contrName"})
	public void reportCarOut(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutTestOpen();
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ������� �� ��� �� ������"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("������")
	@Stories("���� �������� �� ���, ����� \"������� � ������\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarAtWork(String contrName) {
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
	}
	
	@Features("������")
	@Stories("���� �������� �� ���, ����� \"������� � ������ �� ������\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarAtWorkPeriod(String contrName) {
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
	}

	@Features("������")
	@Stories("���� �������� �� ���, ����� \"������ ������ �������\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarAtWorkAnalysis(String contrName) {
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
	}

	@Features("������")
	@Stories("���� �������� �� ���, ����� \"����� ������� �� ������\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarOutPeriod(String contrName) {
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
	}

	@Features("������")
	@Stories("���� �������� �� ���, ����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Parameters({"contrName", "providerName"})
	@Test
	public void reportGpsSignalStatsOdh(String contrName, String providerName) {
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
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findProviderInReportName());
	}
	@Features("������")
	@Stories("���� �������� �� ���, ����� \"������ �������� ������������� ������� (���/���)\"")
	@Test
	public void reportSspLoading() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.sspLoadingReportOpen();
		assertEquals("������ �������� ������������� ������� (���/���)", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ �������� ������������� ������� (���/���)\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ �������� ������������� ������� (��� / ���) ��"));
	}

	@Features("������")
	@Stories("���� �������� �� ���, ����� \"������� � ������ �� ������ (� ������������) (�������)\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarAtWorkPeriodDetail(String contrName) {
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
	}

	@Features("������")
	@Stories("���� �������� �� ���, ����� \"�������� ���, �� ������� �� �������� �������\"")
	@Parameters({"contrName"})
	@Test
	public void reportNotVisitedOdh(String contrName) {
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
	}

	@Features("������")
	@Stories("���� �������� �� ���, ����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\"")
	@Parameters({"contrName"})
	@Test
	public void reportReglamentOperationsSummary(String contrName) {
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
	}
	
	@Features("������")
	@Stories("���� �������� �� ���, ����� \"������ ������ �����\"")
	@Parameters({"contrName"})
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
	@Stories("���� �������� �� ���, ����� \"����������� ������ ����� �� �������\"")
	@Parameters({"contrName"})
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
	@Stories("���� �������� �� ���, ����� \"�������� ���������\"")
	@Parameters({"contrName"})
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
	@Stories("���� �������� �� ���, ����� \"���������� ����������� �������\"")
	@Parameters({"contrName"})
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
	@Stories("���� �������� �� ���, ����� \"�������� �������� ������\"")
	@Parameters({"contrName"})
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
}
