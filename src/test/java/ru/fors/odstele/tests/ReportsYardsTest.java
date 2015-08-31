package ru.fors.odstele.tests;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.fors.odstele.pages.LoginPage;
import ru.fors.odstele.pages.MapPage;
import ru.fors.odstele.pages.ReportsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class ReportsYardsTest extends TestBase {
	
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
	@Stories("���� ����������������, ����� \"����� ������� �� �������� ����������\"")
	@Parameters({"contrName"})
	@Test
	public void carAppearanceYardReportCust(String contrName) {
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
	}
	
	@Features("������")
	@Stories("���� ����������������, ����� \"��������� ������\"")
	@Parameters({"contrName"})
	@Test
	public void reportYardCleanCust(String contrName) {
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
	}
	
	@Features("������")
	@Stories("���� ����������������, ����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Parameters({"contrName", "providerName"})
	@Test
	public void reportGpsSignalStatYardCust(String contrName, String providerName) {
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
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("������")
	@Stories("���� ����������������, ����� \"���������� ����������� ������� �� ������\"")
	@Parameters({"contrName"})
	@Test
	public void reportStatMoveYardCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatMoveYardOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("������")
	@Stories("���� ��������� ��, ����� \"����� ������� �� �������� ����������\"")
	//@Parameters({"custName"})
	@Test
	public void carAppearanceYardReportContr() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.carAppearanceYardReportOpen();
		assertEquals("����� ������� �� �������� ����������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"����� ������� �� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("����� ������� �� �������� ���������� ��"));
		//reportsPage.userSetCustomer(custName);
		//reportsPage.userBuildReport();
		//assertTrue("����� \"����� ������� �� �������� ����������\" �� ��������", reportsPage.isReportBuilds());
		//assertTrue(reportsPage.findYardCustInReportName());
	}
	
	@Features("������")
	@Stories("���� ��������� ��, ����� \"��������� ������\"")
	//@Parameters({"custName"})
	@Test
	public void reportYardCleanContr() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportYardCleanOpen();
		assertEquals("��������� ������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"��������� ������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("��������� ������ ��"));
		//reportsPage.userSetCustomer(custName);
		//reportsPage.userBuildReport();
		//assertTrue("����� \"��������� ������\" �� ��������", reportsPage.isReportBuilds());
		//assertTrue(reportsPage.findYardCustInReportName());
	}
	
	@Features("������")
	@Stories("���� ��������� ��, ����� \"���������� ��������� ��������� �� ��������� ���������\"")
	@Parameters({"providerName"})
	@Test
	public void reportGpsSignalStatYardContr(String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatYardOpen();
		assertEquals("���������� ��������� ��������� �� ��������� ���������", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("���������� ��������� ��������� �� ��������� ��������� ��"));
		//reportsPage.userSetCustomer(custName);
		//reportsPage.userBuildReport();
		//assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		//assertTrue(reportsPage.findYardCustInReportName());
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("����� \"���������� ��������� ��������� �� ��������� ���������\" �� ��������", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("������")
	@Stories("����� \"���������� ����������� ������� �� ������\"")
	//@Parameters({"custName"})
	@Test
	public void reportStatMoveYardContr() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatMoveYardOpen();
		assertEquals("���������� ����������� �������", reportsPage.getBuildReportName());
		//reportsPage.userSetCustomer(custName);
		//reportsPage.userBuildReport();
		//assertTrue("����� \"���������� ����������� �������\" �� ��������", reportsPage.isReportBuilds());
		//assertTrue(reportsPage.getBuildReportsName().contains("���������� ����������� ������� �� ������ �"));
	}
}
