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
	@Stories("Роль Заказчик по ОДХ, Отчет \"Сводка выхода техники на ОДХ\"")
	@Test
	@Parameters({"contrName"})
	public void reportCarOut(String contrName) {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutTestOpen();
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Сводка выхода техники на ОДХ за период"));
		reportsPage.userSetContractor(contrName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findContractorInReportName());
	}

	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Техника в работе\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarAtWork(String contrName) {
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
	}
	
	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Техника в работе за период\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarAtWorkPeriod(String contrName) {
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
	}

	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Анализ работы техники\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarAtWorkAnalysis(String contrName) {
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
	}

	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Выход техники за период\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarOutPeriod(String contrName) {
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
	}

	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Статистика получения показаний от мобильных устройств\"")
	@Parameters({"contrName", "providerName"})
	@Test
	public void reportGpsSignalStatsOdh(String contrName, String providerName) {
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
		reportsPage.userSetProvider(providerName);
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.findProviderInReportName());
	}
	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Анализ загрузки снегосплавных пунктов (ССП/МСП)\"")
	@Test
	public void reportSspLoading() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.sspLoadingReportOpen();
		assertEquals("Анализ загрузки снегосплавных пунктов (ССП/МСП)", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ загрузки снегосплавных пунктов (ССП/МСП)\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ загрузки снегосплавных пунктов (ССП / МСП) на"));
	}

	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Техника в работе за период (с детализацией) (сводный)\"")
	@Parameters({"contrName"})
	@Test
	public void reportCarAtWorkPeriodDetail(String contrName) {
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
	}

	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Перечень ОДХ, на которые не выходила техника\"")
	@Parameters({"contrName"})
	@Test
	public void reportNotVisitedOdh(String contrName) {
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
	}

	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\"")
	@Parameters({"contrName"})
	@Test
	public void reportReglamentOperationsSummary(String contrName) {
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
	}
	
	@Features("Отчеты")
	@Stories("Роль Заказчик по ОДХ, Отчет \"Анализ вывоза снега\"")
	@Parameters({"contrName"})
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
	@Stories("Роль Заказчик по ОДХ, Отчет \"Детализация вывоза снега по машинам\"")
	@Parameters({"contrName"})
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
	@Stories("Роль Заказчик по ОДХ, Отчет \"Протокол нарушений\"")
	@Parameters({"contrName"})
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
	@Stories("Роль Заказчик по ОДХ, Отчет \"Статистика перемещения техники\"")
	@Parameters({"contrName"})
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
	@Stories("Роль Заказчик по ОДХ, Отчет \"Контроль движения колонн\"")
	@Parameters({"contrName"})
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
}
