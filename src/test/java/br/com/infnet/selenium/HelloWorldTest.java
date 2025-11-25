package br.com.infnet.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.*;

public class HelloWorldTest {
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
    @Test
    void helloWorld() throws InterruptedException {
        driver.get("http://example.com");
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);
        assertThat(title, equalTo("Example Domain"));
        assertThat(title, isEmptyOrNullString());
    }
    @AfterEach
    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }

}
