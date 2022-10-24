package br.com.alura.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject{
	
	private final String URL_CADASTRO_LEILOES = "http://localhost:8080/leiloes/new";
	private final String URL_LEILOES = "http://localhost:8080/leiloes";

	/*ele é chamado pelo método de efetuar login, que 
	 * redireciona para a pagina com os leiloes*/
	
	public LeiloesPage(WebDriver browser) {
		super(browser);
	}
	
	public CadastroLeilaoPage navegarParaCadastroDeLeiloes() {
		this.browser.navigate().to(URL_CADASTRO_LEILOES);
		return new CadastroLeilaoPage(browser);
	}
	
	public Boolean isLeilaoCadastrado(String hoje, String nome, String valor) {
		WebElement linhaDaTabela = browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		String colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)")).getText();
		String colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)")).getText();
		String colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)")).getText();
		
		return colunaNome.equals(nome) 
				&& colunaDataAbertura.equals(hoje) 
				&& colunaValorInicial.equals(valor);
		}
	
	public Boolean isPaginaAtual() {
		return this.browser.getCurrentUrl().equals(URL_LEILOES);
	}	
}
