package br.com.infnet.projectobjectmodel.pagesLogin;

import br.com.infnet.projectobjectmodel.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class InventoryPage extends BasePage {
    private final Header header;
    private By inventoryItems = By.className("inventory_item");
    
    public InventoryPage(WebDriver driver){
        super(driver);
        header = new Header(driver);
    }
    
    public Header getHeader(){
        return header;
    }
    
    public List<ProdutoCard> produtos(){
        List<WebElement> produtos = $$(inventoryItems);
        return produtos.stream()
                .map(el -> new ProdutoCard(driver, el)).toList();
    }

    public InventoryPage aguardarPagina(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryItems));
        return this;
    }

    public ProdutoCard produtoPorNome(String nome){
        return produtos().stream().filter(p -> p.nome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado! " + nome));
    }

    public boolean carregou(){
        return !$$(inventoryItems).isEmpty();
    }
}
