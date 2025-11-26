package br.com.infnet.projectobjectmodel.pagesWiki;

import br.com.infnet.projectobjectmodel.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadoBuscaPage extends BasePage {
    private final By tituloPrimeiroResultado = By.id("firstHeading");

    public ResultadoBuscaPage(WebDriver driver) {
        super(driver);
    }

    public String getTituloPrincipal() {
        return $(tituloPrimeiroResultado).getText();
    }
}
