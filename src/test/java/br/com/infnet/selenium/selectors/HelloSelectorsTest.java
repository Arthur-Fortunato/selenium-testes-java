package br.com.infnet.selenium.selectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.*;

public class HelloSelectorsTest {
    private WebDriver driver;
    @BeforeAll
    public static void configurarDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void abrirNavegador() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    // a função abaixo não tem nada a ver com testes, é só para ver os comandos msm
    @Test
    void hello_world() throws InterruptedException {
        driver.get("http://example.com");
        //Thread.sleep(2000);

        WebElement campoBusca = driver.findElement(By.id("searchInput"));

        WebElement search = driver.findElement(By.id("search"));

        WebElement infobox = driver.findElement(By.id("infobox"));

        List<WebElement> todosOsParagrafos = driver.findElements(By.id("p"));
        List<WebElement> todosOsLinks = driver.findElements(By.id("a"));
        List<WebElement> h2 = driver.findElements(By.id("h2"));
        assertThat(todosOsParagrafos.size(), greaterThan(10));

        WebElement doar = driver.findElement(By.linkText("Doar"));
        WebElement partial = driver.findElement(By.partialLinkText("Criar"));

        WebElement tituloCss = driver.findElement(By.cssSelector("#firstHeading"));
        WebElement infoCss = driver.findElement(By.cssSelector(".infobox"));
        WebElement tabelaCss = driver.findElement(By.cssSelector("table.infobox"));

        By.cssSelector(".infobox th");
        By.cssSelector("ul > li");
        By.cssSelector("a[class'mw-jump-link']");
        By.cssSelector("a[href^='en']");

        WebElement tituloComH1 = driver.findElement(By.xpath("//h1"));
        WebElement campoComBuscaViaXPath = driver.findElement(By.xpath("//input[@id='searchInput']"));
        WebElement spanXPath = driver.findElement(By.xpath("//span[text()='História']"));
    }
    @AfterEach
    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}