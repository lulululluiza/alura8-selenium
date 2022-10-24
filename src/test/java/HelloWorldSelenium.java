

import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {
	
	@Test
	public void hello() {
		//informar o caminho do drive baixado
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		
		//Selenium abre o navegador.. (ChromeDriver, FirefoxDriver...)
		WebDriver browser = new ChromeDriver();
		
		//Selenium abre no navegador acima o link abaixo
		browser.navigate().to("http://localhost:8080/leilao");
		
		//Fecha o navegador
		browser.quit();
	}

}
