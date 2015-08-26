package ru.fors.odstele.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.fors.odstele.pages.LoginPage;
import ru.fors.odstele.pages.MainPage;
import ru.fors.odstele.pages.MapPage;
import ru.yandex.qatools.allure.annotations.Features;


public class LoginTests extends TestBase {
	
	
	
	@Features("¬ход в систему")
	@Test
	@Parameters({"username", "password", "role"})
	public void userLogin(String username, String password, String role){
		LoginPage loginPage = new LoginPage(driver);
		MapPage mapPage = loginPage.userLogin(username, password);
		equals(mapPage.getUserRole().contains(role));
		MainPage mainPage = mapPage.userLogout();
		equals(mainPage.getUrl().contains(baseUrl));
	}
	

}
