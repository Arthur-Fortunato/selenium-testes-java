package br.com.infnet.selenium.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseSeleniumTest {
    protected WebDriver driver;
    @BeforeAll
    static void inicializarDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void abrirNavegador() {
        ChromeOptions options = configurarChrome();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterEach
    void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }

    private ChromeOptions configurarChrome() {
        ChromeOptions options = new ChromeOptions();

//        options.addArguments("--headless");
//        options.addArguments("--incognito");
//        options.addArguments("--window-size=1280,800");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--lang=pt-BR");
        return options;
    }
}
