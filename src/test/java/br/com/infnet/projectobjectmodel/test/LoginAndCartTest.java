package br.com.infnet.projectobjectmodel.test;

import br.com.infnet.projectobjectmodel.core.BaseTest;
import br.com.infnet.projectobjectmodel.pagesLogin.InventoryPage;
import br.com.infnet.projectobjectmodel.pagesLogin.LoginPage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginAndCartTest extends BaseTest {
    @Test
    void deveLogarEAdicionarUmProdutoAoCarrinho() throws InterruptedException {
        InventoryPage inventoryPage = new LoginPage(driver).abrir()
                .preencherUsuario("standard_user")
                .preencherSenha("secret_sauce")
                .logarComSucesso().aguardarPagina();

        assertThat(inventoryPage.carregou(), is(true));

        inventoryPage.produtoPorNome("Sauce Labs Backpack").adicionarNoCarrinho();
        inventoryPage.produtoPorNome("Sauce Labs Bike Light").adicionarNoCarrinho();
        inventoryPage.produtoPorNome("Sauce Labs Onesie").adicionarNoCarrinho();

        int cartCount = inventoryPage.getHeader().getCartCount();
        assertThat(cartCount, is(3));
        inventoryPage.produtoPorNome("Sauce Labs Bike Light").removerDoCarrinho();
        Thread.sleep(2000);
        assertThat(inventoryPage.getHeader().getCartCount(), is(2));

    }
}
