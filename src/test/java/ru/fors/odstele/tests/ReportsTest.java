package ru.fors.odstele.tests;

import ru.fors.odstele.pages.LoginPage;
import ru.fors.odstele.pages.MainPage;
import ru.fors.odstele.pages.MapPage;
import ru.fors.odstele.pages.ReportsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
	@Stories("Отчет \"Сводка выхода техники на ОДХ\"")
	@Test
	public void reportCarOutTest() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutTestOpen();
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка выхода техники на ОДХ\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Сводка выхода техники на ОДХ за период"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Техника в работе\"")
	@Test
	public void reportCarAtWork() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkOpen();
		assertEquals("Техника в работе", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Техника в работе на"));
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Техника в работе за период\"")
	@Test
	public void reportCarAtWorkPeriod() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodOpen();
		assertEquals("Техника в работе за период", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Техника в работе за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Анализ работы техники\"")
	@Test
	public void reportCarAtWorkAnalysis() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkAnalysisOpen();
		assertEquals("Анализ работы техники", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ работы техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ работы техники за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Выход техники за период\"")
	@Test
	public void reportCarOutPeriod() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarOutPeriodOpen();
		assertEquals("Выход техники за период", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Выход техники за период\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Выход техники за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Анализ вывоза снега\"")
	@Test
	public void reportSnowRemovalAnalysis() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("Анализ вывоза снега", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("АвД СВАО");
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ вывоза снега\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ вывоза снега за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Детализация вывоза снега по машинам\"")
	@Test
	public void reportSnowRemovalDetail() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("Детализация вывоза снега по машинам", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("АвД СВАО");
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Детализация вывоза снега по машинам\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Детализация вывоза снега по машинам за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Протокол нарушений\"")
	@Test
	public void reportViolation() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("Протокол нарушений", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("АвД СВАО");
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Протокол нарушений\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Протокол нарушений за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Статистика получения показаний от мобильных устройств\"")
	@Test
	public void reportGpsSignalStatsOdh() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportGpsSignalStatOdhOpen();
		assertEquals("Статистика получения показаний от мобильных устройств", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика получения показаний от мобильных устройств\" не построен",
				reportsPage.isReportBuilds());
		assertTrue(
				reportsPage.getBuildReportsName().contains("Статистика получения показаний от мобильных устройств на"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Анализ загрузки снегосплавных пунктов (ССП/МСП)\"")
	@Test
	public void reportSspLoading() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.sspLoadingReportOpen();
		assertEquals("Анализ загрузки снегосплавных пунктов (ССП/МСП)", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ загрузки снегосплавных пунктов (ССП/МСП)\" не построен",
				reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ загрузки снегосплавных пунктов (ССП / МСП) на"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Техника в работе за период (с детализацией) (сводный)\"")
	@Test
	public void reportCarAtWorkPeriodDetail() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportCarAtWorkPeriodDetailOpen();
		assertEquals("Техника в работе за период (с детализацией) (сводный)", reportsPage.getBuildReportName());
		reportsPage.setPeriod("4 часа");
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Техника в работе за период (с детализацией) (сводный)\" не построен",
				reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName()
				.contains("Отчет «Техника в работе за период (с детализацией) (сводный)»"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Перечень ОДХ, на которые не выходила техника\"")
	@Test
	public void reportNotVisitedOdh() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.notVisitedOdhReportOpen();
		assertEquals("Перечень ОДХ, на которые не выходила техника", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Перечень ОДХ, на которые не выходила техника\" не построен", reportsPage.isReportBuilds());
		assertTrue(
				reportsPage.getBuildReportsName().contains("Перечень ОДХ, на которые не выходила техника за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Статистика перемещения техники\"")
	@Test
	public void reportStatsMove() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("Статистика перемещения техники", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("АвД СВАО");
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика перемещения техники за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Контроль движения колонн\"")
	@Test
	public void reportTrafficLineControl() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("Контроль движения колонн", reportsPage.getBuildReportName());
		reportsPage.userSetCustomer("АвД СВАО");
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Контроль движения колонн\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Контроль движения колонн за период с"));

	}

	@Features("Отчеты")
	@Stories("Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\"")
	@Test
	public void reportReglamentOperationsSummary() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportReglamentOperationsSummaryOpen();
		assertEquals("Сводка о выполнении регламентных операций, нарушениях и простое техники",
				reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Сводка о выполнении регламентных операций, нарушениях и простое техники\" не построен",
				reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName()
				.contains("Сводка о выполнении регламентных операций, нарушениях и простое техники за период с"));
	}
	
	@Features("Отчеты")
	@Stories("Отчет \"Анализ вывоза снега\"")
	@Test
	public void reportSnowRemovalAnalysisCust() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalAnalysisOpen();
		assertEquals("Анализ вывоза снега", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Анализ вывоза снега\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Анализ вывоза снега за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Детализация вывоза снега по машинам\"")
	@Test
	public void reportSnowRemovalDetailCust() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportSnowRemovalDetailOpen();
		assertEquals("Детализация вывоза снега по машинам", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Детализация вывоза снега по машинам\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Детализация вывоза снега по машинам за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Протокол нарушений\"")
	@Test
	public void reportViolationCust() {

		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportViolationOpen();
		assertEquals("Протокол нарушений", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Протокол нарушений\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Протокол нарушений за период с"));
}
	@Features("Отчеты")
	@Stories("Отчет \"Статистика перемещения техники\"")
	@Test
	public void reportStatsMoveCust() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportStatsMoveOpen();
		assertEquals("Статистика перемещения техники", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Статистика перемещения техники\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Статистика перемещения техники за период с"));
	}

	@Features("Отчеты")
	@Stories("Отчет \"Контроль движения колонн\"")
	@Test
	public void reportTrafficLineControlCust() {
		ReportsPage reportsPage = new ReportsPage(driver);
		reportsPage.reportTrafficLineControlOpen();
		assertEquals("Контроль движения колонн", reportsPage.getBuildReportName());
		reportsPage.userBuildReport();
		assertTrue("Отчет \"Контроль движения колонн\" не построен", reportsPage.isReportBuilds());
		assertTrue(reportsPage.getBuildReportsName().contains("Контроль движения колонн за период с"));
	}
}
