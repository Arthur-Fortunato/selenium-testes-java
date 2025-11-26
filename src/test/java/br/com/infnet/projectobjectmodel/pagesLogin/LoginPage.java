package br.com.infnet.projectobjectmodel.pagesLogin;

import br.com.infnet.projectobjectmodel.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private static final String URL = "https://www.saucedemo.com/";
    private final By user = By.id("user-name");
    private final By password = By.id("password");
    private final By btnLogin = By.id("login-button");
    private final By error = By.cssSelector("[data-test='error']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage abrir() {
        driver.get(URL);
        return this;
    }

    public LoginPage preencherUsuario(String usuario) {
        type(user, usuario);
        return this;
    }

    public LoginPage preencherSenha(String senha) {
        type(password, senha);
        return this;
    }

    public LoginPage submeterLoginErrado() {
        click(btnLogin);
        return this;
    }

    public InventoryPage logarComSucesso() {
        click(btnLogin);
        return new InventoryPage(driver);
    }

    public String lerErro() {
        return $(error).getText().isEmpty() ? "" : $(error).getText();
    }

    public LoginPage esperarAteAparecerErro(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        return this;
    }
}
