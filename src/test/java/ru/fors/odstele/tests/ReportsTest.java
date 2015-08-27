package ru.fors.odstele.tests;

import ru.fors.odstele.pages.LoginPage;
import ru.fors.odstele.pages.MainPage;
import ru.fors.odstele.pages.MapPage;
import ru.fors.odstele.pages.ReportsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * @author Alexander Zhaleiko alexander.zhaleyko@fors.ru Date: 16.08.15
 */
public class ReportsTest extends TestBase {



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
	@Stories("����� \"������ ������ ������� �� ���\"")
	@Test
	public void reportCarOutTest() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutTestOpen();
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ ������� �� ���\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ������� �� ��� �� ������"));
	}

	@Features("������")
	@Stories("����� \"������� � ������\"")
	@Test
	public void reportCarAtWork() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkOpen();
		assertEquals("������� � ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� � ������ ��"));
	}
	
	@Features("������")
	@Stories("����� \"������� � ������ �� ������\"")
	@Test
	public void reportCarAtWorkPeriod() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodOpen();
		assertEquals("������� � ������ �� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� � ������ �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"������ ������ �������\"")
	@Test
	public void reportCarAtWorkAnalysis() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkAnalysisOpen();
		assertEquals("������ ������ �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ������� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"����� ������� �� ������\"")
	@Test
	public void reportCarOutPeriod() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutPeriodOpen();
		assertEquals("����� ������� �� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����� ������� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"������ ������ �����\"")
	@Test
	public void reportSnowRemovalAnalysis() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("������ ������ �����", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �����\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ����� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"����������� ������ ����� �� �������\"")
	@Test
	public void reportSnowRemovalDetail() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("����������� ������ ����� �� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"����������� ������ ����� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����������� ������ ����� �� ������� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"�������� ���������\"")
	@Test
	public void reportViolation() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("�������� ���������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� ��������� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Test
	public void reportGpsSignalStatsOdh() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatOdhOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������",
				reportsPage.isReportBuilds());
		assertTrue(
				reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
	}

	@Features("������")
	@Stories("����� \"������ �������� ������������� ������� (���/���)\"")
	@Test
	public void reportSspLoading() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.sspLoadingReportOpen();
		assertEquals("������ �������� ������������� ������� (���/���)", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ �������� ������������� ������� (���/���)\" �� ��������",
				reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ �������� ������������� ������� (��� / ���) ��"));
	}

	@Features("������")
	@Stories("����� \"������� � ������ �� ������ (� ������������) (�������)\"")
	@Test
	public void reportCarAtWorkPeriodDetail() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodDetailOpen();
		assertEquals("������� � ������ �� ������ (� ������������) (�������)", reportsPage.getBuildReportName());
		reportsPage.setPeriod("4 ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"������� � ������ �� ������ (� ������������) (�������)\" �� ��������",
				reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName()
				.contains("����� �������� � ������ �� ������ (� ������������) (�������)�"));
	}

	@Features("������")
	@Stories("����� \"�������� ���, �� ������� �� �������� �������\"")
	@Test
	public void reportNotVisitedOdh() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.notVisitedOdhReportOpen();
		assertEquals("�������� ���, �� ������� �� �������� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���, �� ������� �� �������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(
				reportsPage.getBuildReportsName().contains("�������� ���, �� ������� �� �������� ������� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"���������� ����������� �������\"")
	@Test
	public void reportStatsMove() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"�������� �������� ������\"")
	@Test
	public void reportTrafficLineControl() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("�������� �������� ������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� ����");
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� �������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� �������� ������ �� ������ �"));

	}

	@Features("������")
	@Stories("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\"")
	@Test
	public void reportReglamentOperationsSummary() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportReglamentOperationsSummaryOpen();
		assertEquals("������ � ���������� ������������ ��������, ���������� � ������� �������",
				reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ � ���������� ������������ ��������, ���������� � ������� �������\" �� ��������",
				reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName()
				.contains("������ � ���������� ������������ ��������, ���������� � ������� ������� �� ������ �"));
	}
	
	@Features("������")
	@Stories("����� \"������ ������ �����\"")
	@Test
	public void reportSnowRemovalAnalysisCust() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("������ ������ �����", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"������ ������ �����\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������ ������ ����� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"����������� ������ ����� �� �������\"")
	@Test
	public void reportSnowRemovalDetailCust() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("����������� ������ ����� �� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"����������� ������ ����� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����������� ������ ����� �� ������� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"�������� ���������\"")
	@Test
	public void reportViolationCust() {

		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("�������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� ��������� �� ������ �"));
}
	@Features("������")
	@Stories("����� \"���������� ����������� �������\"")
	@Test
	public void reportStatsMoveCust() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
	}

	@Features("������")
	@Stories("����� \"�������� �������� ������\"")
	@Test
	public void reportTrafficLineControlCust() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("�������� �������� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"�������� �������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("�������� �������� ������ �� ������ �"));
	}
	@BeforeGroups(groups="wst")
	public void openWstContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickWstContainer();
	}
	
	@Features("������")
	@Stories("����� \"���������� ��������� ��������� �� ��������� ��������� �� �������\"")
	@Test(groups="wst")
	public void reportGpsSignalStatWst() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatWstOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
	}
	
	@Features("������")
	@Stories("����� \"���������� ����������� ��� ��� ���������� �� �������\"")
	@Test(groups="wst")
	public void reportGarbageTrackMove() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGarbageTrackMoveOpen();
		assertEquals("���������� ����������� ��� ��� ���������� �� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� ��� ��� ���������� �� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("������� ����������� ����������� ��� ��� ���������� �� ������� �� ������ �"));
	}
	
	@BeforeGroups(groups="yard")
	public void openYardContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickYardContainer();
	}
	
	@Features("������")
	@Stories("����� \"����� ������� �� �������� ����������\"")
	@Test(groups="yard")
	public void carAppearanceYardReport() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.carAppearanceYardReportOpen();
		assertEquals("����� ������� �� �������� ����������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����� ������� �� �������� ���������� ��"));
	}
	
	@Features("������")
	@Stories("����� \"��������� ������\"")
	@Test(groups="yard")
	public void reportYardClean() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportYardCleanOpen();
		assertEquals("��������� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"��������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("��������� ������ ��"));
	}
	
	@Features("������")
	@Stories("����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Test(groups="yard")
	public void reportGpsSignalStatYard() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatYardOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
	}
	
	@Features("������")
	@Stories("����� \"���������� ����������� ������� �� ������\"")
	@Test(groups="yard")
	public void reportStatMoveYard() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatMoveYardOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("��� \"�� ������ �����\"");
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
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
}
