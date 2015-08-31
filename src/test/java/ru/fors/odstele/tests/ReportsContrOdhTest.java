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
		assertEquals("Сводка выхода техники на ОДХ", reportsPage.getBuildReportName());
	}
	
	@BeforeMethod
	@Parameters({"username", "password"})
	public void checkConnections(String username, String password){
		if(driver==null){
			goToReportsPage(username, password);
		}
	}
	
	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Сводка выхода техники на ОДХ\"")
	@Test
	@Parameters({"custName"})
	public void reportCarOut(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutTestOpen();
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Сводка выхода техники на ОДХ за период"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Техника в работе\"")
	@Parameters({"custName"})
	@Test
	public void reportCarAtWork(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkOpen();
		assertEquals("Техника в работе", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Техника в работе на"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}
	
	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Техника в работе за период\"")
	@Parameters({"custName"})
	@Test
	public void reportCarAtWorkPeriod(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodOpen();
		assertEquals("Техника в работе за период", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Техника в работе за период с"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Анализ работы техники\"")
	@Parameters({"custName"})
	@Test
	public void reportCarAtWorkAnalysis(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkAnalysisOpen();
		assertEquals("Анализ работы техники", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ работы техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ работы техники за период с"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ работы техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Выход техники за период\"")
	@Parameters({"custName"})
	@Test
	public void reportCarOutPeriod(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutPeriodOpen();
		assertEquals("Выход техники за период", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Выход техники за период с"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Анализ вывоза снега\"")
	@Parameters({"custName"})
	@Test
	public void reportSnowRemovalAnalysis(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("Анализ вывоза снега", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ вывоза снега\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ вывоза снега за период с"));
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Детализация вывоза снега по машинам\"")
	@Parameters({"custName"})
	@Test
	public void reportSnowRemovalDetail(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("Детализация вывоза снега по машинам", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Детализация вывоза снега по машинам\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Детализация вывоза снега по машинам за период с"));
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Протокол нарушений\"")
	@Parameters({"custName"})
	@Test
	public void reportViolation(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("Протокол нарушений", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Протокол нарушений\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Протокол нарушений за период с"));
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Статистика получения показаний от мобильных устройств\"")
	@Parameters({"custName", "providerName"})
	@Test
	public void reportGpsSignalStatsOdh(String custName, String providerName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatOdhOpen();
		assertEquals("Статистика получения показаний от мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика получения показаний от мобильных устройств на"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findProviderInReportName());
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Анализ загрузки снегосплавных пунктов (ССП/МСП)\"")
	@Parameters({"custName"})
	@Test
	public void reportSspLoading(String custName) {
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
	@Stories("Роль подрядчик по ОДХ, Отчет \"Техника в работе за период (с детализацией) (сводный)\"")
	@Parameters({"custName"})
	@Test
	public void reportCarAtWorkPeriodDetail(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodDetailOpen();
		assertEquals("Техника в работе за период (с детализацией) (сводный)", reportsPage.getBuildReportName());
		reportsPage.setPeriod("4 часа");
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период (с детализацией) (сводный)\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Отчет «Техника в работе за период (с детализацией) (сводный)»"));
		reportsPage.userSetContractor(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период (с детализацией) (сводный)\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Перечень ОДХ, на которые не выходила техника\"")
	@Parameters({"custName"})
	@Test
	public void reportNotVisitedOdh(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.notVisitedOdhReportOpen();
		assertEquals("Перечень ОДХ, на которые не выходила техника", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Перечень ОДХ, на которые не выходила техника\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Перечень ОДХ, на которые не выходила техника за период с"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Перечень ОДХ, на которые не выходила техника\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Статистика перемещения техники\"")
	@Parameters({"custName"})
	@Test
	public void reportStatsMove(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("Статистика перемещения техники", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика перемещения техники за период с"));
	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Контроль движения колонн\"")
	@Parameters({"custName"})
	@Test
	public void reportTrafficLineControl(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("Контроль движения колонн", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Контроль движения колонн\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Контроль движения колонн за период с"));

	}

	@Features("Отчеты")
	@Stories("Роль подрядчик по ОДХ, Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\"")
	@Parameters({"custName"})
	@Test
	public void reportReglamentOperationsSummary(String custName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportReglamentOperationsSummaryOpen();
		assertEquals("Сводка о выполнении регламентных операций, нарушениях и простое техники", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Сводка о выполнении регламентных операций, нарушениях и простое техники за период с"));
		reportsPage.userSetCustomer(custName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findCustomerInReportName());
	}

}
