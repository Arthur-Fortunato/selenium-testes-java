package br.com.infnet.projectobjectmodel.pagesLogin;

import br.com.infnet.projectobjectmodel.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoCard extends BasePage {
    private final WebElement root;

    public ProdutoCard(WebDriver driver, WebElement root){
        super(driver);
        this.root = root;
    }

    public String nome(){
        return root.findElement(By.className("inventory_item_name")).getText();
    }

    public String preco(){
        return root.findElement(By.className("inventory_item_price")).getText();
    }

    public void adicionarNoCarrinho(){
        root.findElement(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory")).click();
    }

    public void removerDoCarrinho(){
        root.findElement(By.cssSelector("button.btn.btn_secondary.btn_small.btn_inventory")).click();
    }
}
