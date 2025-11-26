package br.com.infnet.projectobjectmodel.pagesLogin;

import br.com.infnet.projectobjectmodel.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage {
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By menuBtn = By.id("react-burger-menu-btn");
    private final By cartLink = By.id("shopping_cart_container");

    public Header(WebDriver driver) {
        super(driver);
    }

    public int getCartCount(){
        if(driver.findElements(cartBadge).isEmpty()) return 0;
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }

    public void abrirMenu(){
        click(menuBtn);
    }

    public void carrinho(){
        click(cartLink);
    }
}
