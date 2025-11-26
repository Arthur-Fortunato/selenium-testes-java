package br.com.infnet.projectobjectmodel.test;

import br.com.infnet.projectobjectmodel.core.BaseTest;
import br.com.infnet.projectobjectmodel.pagesLogin.LoginPage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseTest {
    @Test
    public void loginComUsuarioErrado(){
        LoginPage retorno = new LoginPage(driver).abrir()
                .preencherUsuario("teste")
                .preencherSenha("123456")
                .submeterLoginErrado()
                .esperarAteAparecerErro();

        assertThat(retorno.lerErro(), containsString("Username and password do not match any user in this service"));
    }

    @Test
    public void loginComUsuarioLento(){
        new LoginPage(driver).abrir()
                .preencherUsuario("performance_glitch_user")
                .preencherSenha("secret_sauce")
                .logarComSucesso();
        //assertThat(retorno.lerErro(), containsString("Username and password do not match"));
    }
}
