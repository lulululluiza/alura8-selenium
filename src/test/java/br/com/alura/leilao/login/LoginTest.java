package br.com.alura.leilao.login;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private LoginPage paginaDeLogin;	
	
	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}
		
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {	
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuaLogin();
		
		Assertions.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assertions.assertEquals("fulano", paginaDeLogin.getNomeUserLogado());
}
	
	@Test
	public void naoDeveriaLogarComDadosInvalidos() {
		paginaDeLogin.preencheFormularioDeLogin("blabla", "123");
		paginaDeLogin.efetuaLogin();

		Assertions.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assertions.assertNull(paginaDeLogin.getNomeUserLogado());
		
		Assertions.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	}

	@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.navegaParaPaginaDeLances();
		
		Assertions.assertTrue(paginaDeLogin.isPaginaDeLogin());
		Assertions.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}
}
