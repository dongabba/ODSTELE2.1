package ru.fors.odstele.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends Page {
	


	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	By usernameField = By.name("j_username");
	By passwordField = By.name("j_password");
	By loginButton = By.linkText("Войти");


	@Step("Пользователь входит в систему как {0}")
	public MapPage userLogin(String username, String password){
		type(usernameField, username);
		type(passwordField, password);
		click(loginButton);
		return new MapPage(driver); 
		
	}
}
