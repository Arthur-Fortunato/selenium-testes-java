package br.com.infnet.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SeleniumHelloWorldConfiguracoesTest {
    private WebDriver driver;

    @BeforeAll
    static void configurarDriverBinario() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void configurarEIniciarDriver() {
        ChromeOptions options = new ChromeOptions();

        //
        // =====================
        // CONFIGURAÇÕES POSSÍVEIS
        // =====================
        //

        // 1. Modo Headless (sem interface gráfica)
        options.addArguments("--headless=new"); // novo headless do Chrome

        // 2. Iniciar navegador maximizado
        // options.addArguments("--start-maximized");

        // 3. Definir tamanho da janela manualmente
        // options.addArguments("--window-size=1280,800");

        // 4. Navegador em modo incógnito
        // options.addArguments("--incognito");

        // 5. Desabilitar notificações e popups
        // options.addArguments("--disable-notifications");
        // options.addArguments("--disable-popup-blocking");

        // 6. Desabilitar extensões
        // options.addArguments("--disable-extensions");

        // 7. User-Agent personalizado (para testar comportamento mobile, por exemplo)
        // options.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 16_0) AppleWebKit/605.1");

        // 8. Desabilitar GPU (útil em alguns ambientes)
        // options.addArguments("--disable-gpu");

        // 9. Silenciar logs do ChromeDriver
        // System.setProperty("webdriver.chrome.silentOutput", "true");
        // options.addArguments("--log-level=3"); // somente erros

        // 10. Usar Proxy
        // options.addArguments("--proxy-server=http://localhost:8888");

        // 11. Bloquear imagens (para acelerar teste)
        // Map<String, Object> prefs = new HashMap<>();
        // prefs.put("profile.managed_default_content_settings.images", 2);
        // options.setExperimentalOption("prefs", prefs);

        // 12. Rodar sem sandbox (para ambientes CI que não permitem sandbox)
        // options.addArguments("--no-sandbox");

        // 13. Rodar dentro de container Linux (recomendação do próprio Google)
        // options.addArguments("--disable-dev-shm-usage");

        // 14. Modo "kiosk" (tela cheia)
        // options.addArguments("--kiosk");

        // 15. Forçar idioma da UI
        // options.addArguments("--lang=pt-BR");

        //
        // Você pode habilitar quantas opções quiser acima.
        //

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterEach
    void fecharDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void hello_world_selenium() {
        driver.get("https://example.com");

        String titulo = driver.getTitle();
        assertThat(titulo, containsString("Example Domain"));
    }
}