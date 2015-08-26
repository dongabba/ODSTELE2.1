package ru.fors.odstele.tests;

import ru.fors.odstele.pages.LoginPage;
import ru.fors.odstele.pages.MapPage;
import ru.fors.odstele.pages.ReportsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru Date: 16.08.15
 */
public class ReportsTest extends TestBase {



	@BeforeClass
	@Parameters({"username", "password"})
	public void goToReportsPage(String username, String password){
		LoginPage loginPage = new LoginPage(driver);
		MapPage mapPage = loginPage.userLogin(username, password);
		ReportsPage reportsPage = mapPage.userGotoReportsPage();
		assertEquals("������ ������ ������� �� ���", reportsPage.getBuildReportName());
	}
	
	@BeforeTest
	@Parameters({"username", "password"})
	public void checkConnections(String username, String password){
		if(driver==null){
			goToReportsPage(username, password);
		}
	}
	
	@Features("������")
	@Stories("����� \"������ ������ ������� �� ���\"")
	@Test
	public void reportCarOutTest() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ������� �� ��� �� ������"));
	}
/*
	@Features("������")
	@Stories("���� �����������, ����� \"������� � ������\"")
	@Test
	public void reportCarAtWork() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportCarAtWorkOpen();
		assertEquals("������� � ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� � ������ ��"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"������� � ������ �� ������\"")
	@Test
	public void reportCarAtWorkPeriod() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportCarAtWorkPeriodOpen();
		assertEquals("������� � ������ �� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� � ������ �� ������ �"));
		quit();

	}

	@Features("������")
	@Stories("���� �����������, ����� \"������ ������ �������\"")
	@Test
	public void reportCarAtWorkAnalysis() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportCarAtWorkAnalysisOpen();
		assertEquals("������ ������ �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ������� �� ������ �"));
		quit();

	}

	@Features("������")
	@Stories("���� �����������, ����� \"����� ������� �� ������\"")
	@Test
	public void reportCarOutPeriod() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportCarOutPeriodOpen();
		assertEquals("����� ������� �� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����� ������� �� ������ �"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"������ ������ �����\"")
	@Test
	public void reportSnowRemovalAnalysis() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("������ ������ �����", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ���");
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �����\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ����� �� ������ �"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"����������� ������ ����� �� �������\"")
	@Test
	public void reportSnowRemovalDetail() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("����������� ������ ����� �� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ���");
		reportsPage.userBuildReport();
		assertTrue("����� \"����������� ������ ����� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����������� ������ ����� �� ������� �� ������ �"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"�������� ���������\"")
	@Test
	public void reportViolation() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportViolationOpen();
		assertEquals("�������� ���������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ���");
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� ��������� �� ������ �"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Test
	public void reportGpsSignalStatsOdh() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportGpsSignalStatOdhOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������",
				reportsPage.isReportBuilds());
		assertTrue(
				reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"������ �������� ������������� ������� (���/���)\"")
	@Test
	public void reportSspLoading() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.sspLoadingReportOpen();
		assertEquals("������ �������� ������������� ������� (���/���)", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ �������� ������������� ������� (���/���)\" �� ��������",
				reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ �������� ������������� ������� (��� / ���) ��"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"������� � ������ �� ������ (� ������������) (�������)\"")
	@Test
	public void reportCarAtWorkPeriodDetail() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportCarAtWorkPeriodDetailOpen();
		assertEquals("������� � ������ �� ������ (� ������������) (�������)", reportsPage.getBuildReportName());
		reportsPage.setPeriod("4 ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������ (� ������������) (�������)\" �� ��������",
				reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName()
				.contains("����� �������� � ������ �� ������ (� ������������) (�������)�"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"�������� ���, �� ������� �� �������� �������\"")
	@Test
	public void reportNotVisitedOdh() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.notVisitedOdhReportOpen();
		assertEquals("�������� ���, �� ������� �� �������� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���, �� ������� �� �������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(
				reportsPage.getBuildReportsName().contains("�������� ���, �� ������� �� �������� ������� �� ������ �"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"���������� ����������� �������\"")
	@Test
	public void reportStatsMove() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportStatsMoveOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"�������� �������� ������\"")
	@Test
	public void reportTrafficLineControl() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("�������� �������� ������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ���");
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� �������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� �������� ������ �� ������ �"));
		quit();
	}

	@Features("������")
	@Stories("���� �����������, ����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\"")
	@Test
	public void reportReglamentOperationsSummary() {
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		ReportsPage reportsPage = new ReportsPage(driver);

		loginPage.userLogin(dept_login, dept_pass);
		mainPage.userGotoReportsPage();
		reportsPage.reportReglamentOperationsSummaryOpen();
		assertEquals("������ � ���������� ������������ ��������, ���������� � ������� �������",
				reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\" �� ��������",
				reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName()
				.contains("������ � ���������� ������������ ��������, ���������� � ������� ������� �� ������ �"));
		quit();
	}
	*/

}

