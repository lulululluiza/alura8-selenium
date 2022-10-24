package br.com.alura.leilao.lance;

import br.com.alura.leilao.PageObject;

public class LancesPage extends PageObject {
		
	private static final String URL_LANCE = "http://localhost:8080/leiloes/2";
	
	public LancesPage() {
		super(null);
		this.browser.navigate().to(URL_LANCE);
	}
		
	public Boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_LANCE);
	}
}
