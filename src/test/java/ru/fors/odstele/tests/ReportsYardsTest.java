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
	
	@Features("Отчеты")
	@Stories("Роль Балансодержатель, Отчет \"Выход техники на дворовые территории\"")
	@Parameters({"contrName"})
	@Test
	public void carAppearanceYardReportCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.carAppearanceYardReportOpen();
		assertEquals("Выход техники на дворовые территории", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники на дворовые территории\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Выход техники на дворовые территории за"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники на дворовые территории\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Роль Балансодержатель, Отчет \"Состояние уборки\"")
	@Parameters({"contrName"})
	@Test
	public void reportYardCleanCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportYardCleanOpen();
		assertEquals("Состояние уборки", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Состояние уборки\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Состояние уборки за"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Состояние уборки\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Роль Балансодержатель, Отчет \"Статистика получения показаний от мобильных устройств\"")
	@Parameters({"contrName", "providerName"})
	@Test
	public void reportGpsSignalStatYardCust(String contrName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatYardOpen();
		assertEquals("Статистика получения показаний от мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика получения показаний от мобильных устройств на"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Роль Балансодержатель, Отчет \"Статистика перемещения техники по дворам\"")
	@Parameters({"contrName"})
	@Test
	public void reportStatMoveYardCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatMoveYardOpen();
		assertEquals("Статистика перемещения техники", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика перемещения техники за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Роль Подрядчик ДТ, Отчет \"Выход техники на дворовые территории\"")
	//@Parameters({"custName"})
	@Test
	public void carAppearanceYardReportContr() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.carAppearanceYardReportOpen();
		assertEquals("Выход техники на дворовые территории", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники на дворовые территории\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Выход техники на дворовые территории за"));
		//reportsPage.userSetCustomer(custName);
		//reportsPage.userBuildReport();
		//assertTrue("Отчет \"Выход техники на дворовые территории\" не построен", reportsPage.isReportBuilds());
		//assertTrue(reportsPage.findYardCustInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Роль Подрядчик ДТ, Отчет \"Состояние уборки\"")
	//@Parameters({"custName"})
	@Test
	public void reportYardCleanContr() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportYardCleanOpen();
		assertEquals("Состояние уборки", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Состояние уборки\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Состояние уборки за"));
		//reportsPage.userSetCustomer(custName);
		//reportsPage.userBuildReport();
		//assertTrue("Отчет \"Состояние уборки\" не построен", reportsPage.isReportBuilds());
		//assertTrue(reportsPage.findYardCustInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Роль Подрядчик ДТ, Отчет \"Статистика получения показаний от мобильных устройств\"")
	@Parameters({"providerName"})
	@Test
	public void reportGpsSignalStatYardContr(String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatYardOpen();
		assertEquals("Статистика получения показаний от мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика получения показаний от мобильных устройств на"));
		//reportsPage.userSetCustomer(custName);
		//reportsPage.userBuildReport();
		//assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		//assertTrue(reportsPage.findYardCustInReportName());
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Статистика перемещения техники по дворам\"")
	//@Parameters({"custName"})
	@Test
	public void reportStatMoveYardContr() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatMoveYardOpen();
		assertEquals("Статистика перемещения техники", reportsPage.getBuildReportName());
		//reportsPage.userSetCustomer(custName);
		//reportsPage.userBuildReport();
		//assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		//assertTrue(reportsPage.getBuildReportsName().contains("Статистика перемещения техники за период с"));
	}
}
