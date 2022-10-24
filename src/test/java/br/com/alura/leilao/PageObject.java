package br.com.alura.leilao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
	
	protected WebDriver browser;
	
	public PageObject(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		
		if (browser == null) {
			this.browser = new ChromeDriver();
		} else {
			this.browser = browser;
		}	
		
		//alguns elementos da pagina podem travar/demorar a carregar
		//o que pode fazer com que eles "sumam" da página
		//gerando erros nos testes 
		this.browser.manage().timeouts()
		.implicitlyWait(5, TimeUnit.SECONDS)
		.pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void fechar() {
		this.browser.quit();
	}
}
