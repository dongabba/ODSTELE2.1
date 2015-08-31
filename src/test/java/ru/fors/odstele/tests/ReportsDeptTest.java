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
	
	@Features("Отчеты")
	@Stories("Отчет \"Сводка выхода техники на ОДХ\"")
	@Test
	@Parameters({"contrName", "custName"})
	public void reportCarOut(String contrName, String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutTestOpen();
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Сводка выхода техники на ОДХ за период"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		
		
	}

	@Features("Отчеты")
	@Stories("Отчет \"Техника в работе\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarAtWork(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkOpen();
		assertEquals("Техника в работе", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Техника в работе на"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Техника в работе за период\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarAtWorkPeriod(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodOpen();
		assertEquals("Техника в работе за период", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Техника в работе за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Анализ работы техники\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarAtWorkAnalysis(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkAnalysisOpen();
		assertEquals("Анализ работы техники", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ работы техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ работы техники за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ работы техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ работы техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ работы техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Выход техники за период\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarOutPeriod(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutPeriodOpen();
		assertEquals("Выход техники за период", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Выход техники за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Анализ вывоза снега\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSnowRemovalAnalysis(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("Анализ вывоза снега", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ вывоза снега\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ вывоза снега за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ вывоза снега\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Детализация вывоза снега по машинам\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSnowRemovalDetail(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("Детализация вывоза снега по машинам", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Детализация вывоза снега по машинам\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Детализация вывоза снега по машинам за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Детализация вывоза снега по машинам\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Протокол нарушений\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportViolation(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("Протокол нарушений", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Протокол нарушений\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Протокол нарушений за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Протокол нарушений\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Статистика получения показаний от мобильных устройств\"")
	@Parameters({"contrName", "custName", "providerName"})
	@Test
	public void reportGpsSignalStatsOdh(String custName, String contrName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatOdhOpen();
		assertEquals("Статистика получения показаний от мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика получения показаний от мобильных устройств на"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Анализ загрузки снегосплавных пунктов (ССП/МСП)\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSspLoading(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.sspLoadingReportOpen();
		assertEquals("Анализ загрузки снегосплавных пунктов (ССП/МСП)", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ загрузки снегосплавных пунктов (ССП/МСП)\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ загрузки снегосплавных пунктов (ССП / МСП) на"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Техника в работе за период (с детализацией) (сводный)\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportCarAtWorkPeriodDetail(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodDetailOpen();
		assertEquals("Техника в работе за период (с детализацией) (сводный)", reportsPage.getBuildReportName());
		reportsPage.setPeriod("4 часа");
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период (с детализацией) (сводный)\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Отчет «Техника в работе за период (с детализацией) (сводный)»"));
		reportsPage.userSetProvider(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период (с детализацией) (сводный)\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearProviderField();
		reportsPage.userSetContractor(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период (с детализацией) (сводный)\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetContractor(custName);
		reportsPage.userSetProvider(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период (с детализацией) (сводный)\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Перечень ОДХ, на которые не выходила техника\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportNotVisitedOdh(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.notVisitedOdhReportOpen();
		assertEquals("Перечень ОДХ, на которые не выходила техника", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Перечень ОДХ, на которые не выходила техника\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Перечень ОДХ, на которые не выходила техника за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Перечень ОДХ, на которые не выходила техника\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Перечень ОДХ, на которые не выходила техника\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Перечень ОДХ, на которые не выходила техника\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Статистика перемещения техники\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportStatsMove(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("Статистика перемещения техники", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика перемещения техники за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Контроль движения колонн\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportTrafficLineControl(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("Контроль движения колонн", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Контроль движения колонн\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Контроль движения колонн за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Контроль движения колонн\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());

	}

	@Features("Отчеты")
	@Stories("Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportReglamentOperationsSummary(String custName, String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportReglamentOperationsSummaryOpen();
		assertEquals("Сводка о выполнении регламентных операций, нарушениях и простое техники", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Сводка о выполнении регламентных операций, нарушениях и простое техники за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Анализ вывоза снега\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSnowRemovalAnalysisCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("Анализ вывоза снега", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ вывоза снега\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ вывоза снега за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ вывоза снега\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Детализация вывоза снега по машинам\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportSnowRemovalDetailCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("Детализация вывоза снега по машинам", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Детализация вывоза снега по машинам\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Детализация вывоза снега по машинам за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Детализация вывоза снега по машинам\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Протокол нарушений\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportViolationCust(String contrName) {

		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("Протокол нарушений", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Протокол нарушений\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Протокол нарушений за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Протокол нарушений\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
}
	@Features("Отчеты")
	@Stories("Отчет \"Статистика перемещения техники\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportStatsMoveCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("Статистика перемещения техники", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика перемещения техники за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Отчет \"Контроль движения колонн\"")
	@Parameters({"contrName", "custName"})
	@Test
	public void reportTrafficLineControlCust(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("Контроль движения колонн", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Контроль движения колонн\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Контроль движения колонн за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Контроль движения колонн\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}
	
	@BeforeGroups(groups="wst")
	public void openWstContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickWstContainer();
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Статистика получения показаний от мобильных устройств по Отходам\"")
	@Parameters({"contrName", "custName", "providerName"})
	@Test(groups="wst")
	public void report2GpsSignalStatWst(String contrName, String custName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatWstOpen();
		assertEquals("Статистика получения показаний от мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика получения показаний от мобильных устройств на"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findWstOwnerInReportName());
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findWstCustInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findWstOwnerInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Статистика перемещения СТС без назначения на маршрут\"")
	@Parameters({"contrName", "custName"})
	@Test(groups="wst")
	public void report1GarbageTrackMove(String contrName, String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGarbageTrackMoveOpen();
		assertEquals("Статистика перемещения СТС без назначения на маршрут", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения СТС без назначения на маршрут\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Справка «Статистика перемещения СТС без назначения на маршрут» за период с"));
		reportsPage.userSetCustomer(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения СТС без назначения на маршрут\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findWstContrInReportName());
	}
	
	@BeforeGroups(groups="yard")
	public void openYardContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickYardContainer();
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Выход техники на дворовые территории\"")
	@Parameters({"contrName", "custName"})
	@Test(groups="yard")
	public void carAppearanceYardReport(String contrName, String custName) {
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
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники на дворовые территории\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardCustInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники на дворовые территории\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Состояние уборки\"")
	@Parameters({"contrName", "custName"})
	@Test(groups="yard")
	public void reportYardClean(String contrName, String custName) {
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
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Состояние уборки\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardCustInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Состояние уборки\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Статистика получения показаний от мобильных устройств\"")
	@Parameters({"contrName", "custName", "providerName"})
	@Test(groups="yard")
	public void reportGpsSignalStatYard(String contrName, String custName, String providerName) {
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
		reportsPage.clearContractorField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardCustInReportName());
		reportsPage.clearCustomerField();
		reportsPage.userSetCustomer(custName);
		reportsPage.userSetContractor(contrName);
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Статистика перемещения техники по дворам\"")
	@Parameters({"contrName", "custName"})
	@Test(groups="yard")
	public void reportStatMoveYard(String contrName, String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatMoveYardOpen();
		assertEquals("Статистика перемещения техники", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика перемещения техники за период с"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findYardContrInReportName());
	}
	
	@BeforeGroups(groups="ozn")
	public void openOznContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickOznContainer();
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Статистика получения показаний от мобильных устройств по ОЗН\"")
	@Test(groups="ozn")
	public void reportGpsSignalStatOzn() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatOznOpen();
		assertEquals("Статистика получения показаний от мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика получения показаний от мобильных устройств на"));
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Выполнение основных видов работ по содержанию объектов озеленения\"")
	@Test(groups="ozn")
	public void reportOznWorksCompletion() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportOznWorksCompletion();
		assertEquals("Выполнение основных видов работ по содержанию объектов озеленения", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выполнение основных видов работ по содержанию объектов озеленения\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Выполнение основных видов работ по содержанию объектов озеленения"));
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Текущее состояние объектов озеленения\"")
	@Test(groups="ozn")
	public void reportCurrentStateOzn() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCurrentStateOznOpen();
		assertEquals("Текущее состояние объектов озеленения", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Текущее состояние объектов озеленения\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Текущее состояние объектов озеленения"));
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Сводный отчет по выходу техники, задействованной на объектах озеленения\"")
	@Test(groups="yard")
	public void reportCarOutSummaryOzn() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutSummaryOznOpen();
		assertEquals("Сводный отчет по выходу техники, задействованной на объектах озеленения", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводный отчет по выходу техники, задействованной на объектах озеленения\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Сводный отчет по выходу техники, задействованной на объектах озеленения"));
	}
	
	@BeforeGroups(groups="provider")
	public void openAllContainer(){
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.clickOdhContainer();
		reportsPage.clickAllContainer();
	}
	
	@Features("Отчеты")
	@Stories("Роль Поставщик, Отчет \"Статистика переданных показаний с мобильных устройств\"")
	@Test(groups="provider")
	public void reportGpsSignal4Provider() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignal4ProviderOpen();;
		assertEquals("Статистика переданных показаний с мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \" Статистика переданных показаний с мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика переданных показаний с мобильных устройств на"));
	}
	
	@Features("Отчеты")
	@Stories("Роль Образователь, Отчет \"Статистика получения показаний от мобильных устройств\"")
	@Parameters({"contrName", "providerName"})
	@Test
	public void reportGpsSignalStatsWstCust(String contrName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		assertEquals("Статистика получения показаний от мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика получения показаний от мобильных устройств"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue(reportsPage.findWstOwnerInReportName());
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertEquals(true, reportsPage.findProviderInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Роль Транспортировщик, Отчет \"Статистика получения показаний от мобильных устройств\"")
	@Parameters({"custName", "providerName"})
	@Test
	public void reportGpsSignalStatsWstContr(String custName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		assertEquals("Статистика получения показаний от мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика получения показаний от мобильных устройств"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue(reportsPage.findWstCustInReportName());
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertEquals(true, reportsPage.findProviderInReportName());
	}
}
