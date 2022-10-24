package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import br.com.alura.leilao.PageObject;
import br.com.alura.leiloes.LeiloesPage;

public class LoginPage extends PageObject{
	
	private static final String URL_LOGIN = "http://localhost:8080/login";
	
	public LoginPage() {	
		super(null);
		this.browser.navigate().to(URL_LOGIN);
	}
	
	public void preencheFormularioDeLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}
	
	public LeiloesPage efetuaLogin() {
		browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}
	
	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(URL_LOGIN);
	}

	public String getNomeUserLogado() {
		try {
			String user = browser.findElement(By.id("usuario-logado")).getText();
			return user;
		} catch (NoSuchElementException ex) {
			return null;
		}		
	}
	
	public void navegaParaPaginaDeLances() {
		browser.navigate().to("http://localhost:8080/leiloes/2");	
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}	
}
	
