package br.com.infnet.projectobjectmodel.test;

import br.com.infnet.projectobjectmodel.core.BaseTest;
import br.com.infnet.projectobjectmodel.pagesWiki.HomePage;
import br.com.infnet.projectobjectmodel.pagesWiki.ResultadoBuscaPage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HomePageTest extends BaseTest {
    @Test
    public void deveBuscarLHCNaWiki() throws InterruptedException {
        ResultadoBuscaPage resultadoBuscaPage = new HomePage(driver).abrir()
                .buscarPor("LHC");
        Thread.sleep(2000);
        assertThat(resultadoBuscaPage.getTituloPrincipal(), containsString("Grande Colisor de Hádrons"));
    }
}
