package br.com.infnet.selenium.actions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FormCompleteTest extends BaseSeleniumTest{
    private final long SHORT_WAIT = 500;
    @Test
    @DisplayName("Deve navegar Da Home até o form")
    void deveNavegar() throws InterruptedException {
        driver.get("http://formy-project.herokuapp.com/");
        Thread.sleep(SHORT_WAIT);
        WebElement linkText = driver.findElement(By.linkText("Form"));

        linkText.click();
        Thread.sleep(SHORT_WAIT);
        assertThat(driver.getCurrentUrl(), containsString("/form"));
        WebElement titulo = driver.findElement(By.tagName("h1"));
        assertThat(titulo.getText(), containsString("Complete Web Form"));
    }

    @Test
    @DisplayName("deve preencher formulario completo")
    void devePreencherFormularioCompleto() throws InterruptedException {
        driver.get("http://formy-project.herokuapp.com/form");
        Thread.sleep(SHORT_WAIT);

        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("Arthur");
        Thread.sleep(SHORT_WAIT);

        assertThat(firstNameInput.getAttribute("value"), is("Arthur"));

        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys("Ribeiro");
        Thread.sleep(SHORT_WAIT);

        assertThat(lastNameInput.getAttribute("value"), is("Ribeiro"));

        WebElement jobTitleInput = driver.findElement(By.id("job-title"));
        jobTitleInput.click();
        jobTitleInput.clear();
        jobTitleInput.sendKeys("Aluno / engenheiro");
        Thread.sleep(SHORT_WAIT);

        assertThat(jobTitleInput.getAttribute("value"), is("Aluno / engenheiro"));

        WebElement highSchoolRadio = driver.findElement(By.id("radio-button-1"));
        WebElement collegeRadio = driver.findElement(By.id("radio-button-2"));
        WebElement gradSchoolRadio = driver.findElement(By.id("radio-button-3"));

        collegeRadio.click();
        Thread.sleep(SHORT_WAIT);

        assertThat(collegeRadio.isSelected(), is(true));
        assertThat(gradSchoolRadio.isSelected(), is(false));
        assertThat(highSchoolRadio.isSelected(), is(false));

        WebElement maleCheckbox = driver.findElement(By.id("checkbox-1"));
        WebElement femaleCheckbox = driver.findElement(By.id("checkbox-2"));
        WebElement preferNotCheckbox = driver.findElement(By.id("checkbox-3"));

        maleCheckbox.click();
        preferNotCheckbox.click();
        Thread.sleep(SHORT_WAIT);

        assertThat(maleCheckbox.isSelected(), is(true));
        assertThat(preferNotCheckbox.isSelected(), is(true));
        assertThat(femaleCheckbox.isSelected(), is(false));

        WebElement yearsSelectElement = driver.findElement(By.id("select-menu"));
        Select yearSelect = new Select(yearsSelectElement);
        yearSelect.selectByVisibleText("5-9");
        Thread.sleep(SHORT_WAIT);

        assertThat(yearSelect.getFirstSelectedOption().getText(), is("5-9"));

        WebElement datePickerInput = driver.findElement(By.id("datepicker"));
        datePickerInput.click();
        datePickerInput.sendKeys("05/25/2025");
        datePickerInput.sendKeys(Keys.ENTER);
        Thread.sleep(SHORT_WAIT);

        WebElement submitButton = driver.findElement(By.cssSelector("a.btn.btn-lg.btn-primary"));
        submitButton.click();
        Thread.sleep(5_000);

        assertThat(driver.getCurrentUrl(), containsString("/thanks"));

        WebElement titulo = driver.findElement(By.tagName("h1"));
        assertThat(titulo.getText(), containsString("Thanks for submitting your form"));
    }
    @Test
    @DisplayName("Deve abrir e fechar o modal")
    void deveAbrirEFechar(){
        driver.get("http://formy-project.herokuapp.com/modal");

        driver.findElement(By.id("modal-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement modal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-dialog"))
        );

        WebElement tituloModal = modal.findElement(By.tagName("h5"));
        assertThat(tituloModal.getText(), containsStringIgnoringCase("modal"));

        driver.findElement(By.id("close-button")).click();

        wait.until(
          ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-dialog"))
        );

        WebElement modalFechado = driver.findElement(By.cssSelector(".modal-dialog"));
        assertThat(modalFechado.isDisplayed(), is(false));
    }

    @Test
    @DisplayName("Deve aguardar o loading")
    void deveMostrarUserNameComHover() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");
        List<WebElement> figuras = driver.findElements(By.cssSelector(".figure"));
        assertThat(figuras.size(), greaterThan(1));
        Actions actions = new Actions(driver);

        for (WebElement figura : figuras) {
            actions.moveToElement(figura).pause(200).perform();
            WebElement caption = figura.findElement(By.cssSelector(".figcaption > h5"));
            assertThat(caption.getText(), containsString("name: user"));
        }

    }
}
