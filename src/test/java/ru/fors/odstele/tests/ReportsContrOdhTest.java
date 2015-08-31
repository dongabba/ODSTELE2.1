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

public class ReportsContrOdhTest extends TestBase {



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
	@Stories("���� ��������� �� ���, ����� \"������ ������ ������� �� ���\"")
	@Test
	@Parameters({"custName"})
	public void reportCarOut(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutTestOpen();
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ������� �� ��� �� ������"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"������� � ������\"")
	@Parameters({"custName"})
	@Test
	public void reportCarAtWork(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkOpen();
		assertEquals("������� � ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� � ������ ��"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}
	
	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"������� � ������ �� ������\"")
	@Parameters({"custName"})
	@Test
	public void reportCarAtWorkPeriod(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodOpen();
		assertEquals("������� � ������ �� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� � ������ �� ������ �"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"������ ������ �������\"")
	@Parameters({"custName"})
	@Test
	public void reportCarAtWorkAnalysis(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkAnalysisOpen();
		assertEquals("������ ������ �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ������� �� ������ �"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"����� ������� �� ������\"")
	@Parameters({"custName"})
	@Test
	public void reportCarOutPeriod(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutPeriodOpen();
		assertEquals("����� ������� �� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����� ������� �� ������ �"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"������ ������ �����\"")
	@Parameters({"custName"})
	@Test
	public void reportSnowRemovalAnalysis(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("������ ������ �����", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �����\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ����� �� ������ �"));
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"����������� ������ ����� �� �������\"")
	@Parameters({"custName"})
	@Test
	public void reportSnowRemovalDetail(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("����������� ������ ����� �� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"����������� ������ ����� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����������� ������ ����� �� ������� �� ������ �"));
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"�������� ���������\"")
	@Parameters({"custName"})
	@Test
	public void reportViolation(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("�������� ���������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� ��������� �� ������ �"));
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Parameters({"custName", "providerName"})
	@Test
	public void reportGpsSignalStatsOdh(String custName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatOdhOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findProviderInReportName());
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"������ �������� ������������� ������� (���/���)\"")
	@Parameters({"custName"})
	@Test
	public void reportSspLoading(String custName) {
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
	@Stories("���� ��������� �� ���, ����� \"������� � ������ �� ������ (� ������������) (�������)\"")
	@Parameters({"custName"})
	@Test
	public void reportCarAtWorkPeriodDetail(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodDetailOpen();
		assertEquals("������� � ������ �� ������ (� ������������) (�������)", reportsPage.getBuildReportName());
		reportsPage.setPeriod("4 ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������ (� ������������) (�������)\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����� �������� � ������ �� ������ (� ������������) (�������)�"));
		reportsPage.userSetContractor(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������ (� ������������) (�������)\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"�������� ���, �� ������� �� �������� �������\"")
	@Parameters({"custName"})
	@Test
	public void reportNotVisitedOdh(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.notVisitedOdhReportOpen();
		assertEquals("�������� ���, �� ������� �� �������� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���, �� ������� �� �������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� ���, �� ������� �� �������� ������� �� ������ �"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���, �� ������� �� �������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"���������� ����������� �������\"")
	@Parameters({"custName"})
	@Test
	public void reportStatsMove(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"�������� �������� ������\"")
	@Parameters({"custName"})
	@Test
	public void reportTrafficLineControl(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("�������� �������� ������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� �������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� �������� ������ �� ������ �"));

	}

	@Features("������")
	@Stories("���� ��������� �� ���, ����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\"")
	@Parameters({"custName"})
	@Test
	public void reportReglamentOperationsSummary(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportReglamentOperationsSummaryOpen();
		assertEquals("������ � ���������� ������������ ��������, ���������� � ������� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ � ���������� ������������ ��������, ���������� � ������� ������� �� ������ �"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

}
