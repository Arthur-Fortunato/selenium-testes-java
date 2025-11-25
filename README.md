# 🧪 Projeto de Testes em Java — Selenium + Hamcrest

Este repositório foi criado apenas para **estudos e prática de testes automatizados em Java**, usando **Selenium WebDriver**, **JUnit 5** e **Hamcrest**.  
O projeto não contém código em `src/main/java`: todos os exemplos estão em **src/test/java**.

---

## 🔍 Teste Principal — Selenium: `FormCompleteTest`

`Localização:`
src/test/java/br/com/infnet/selenium/actions/FormCompleteTest.java


Este é o teste mais completo nesse projeto. Ele demonstra, na prática, como automatizar um formulário real, incluindo:

### ✔ Navegação e interações
- Abre o site `http://formy-project.herokuapp.com/form`
- Clica em links, navega entre páginas e valida URLs

### ✔ Preenchimento de campos
- Usa: `sendKeys`, `click`, `clear`
- Preenche: `first-name`, `last-name`, `job-title`

### ✔ Radio buttons e checkboxes
- Seleciona o nível de escolaridade
- Marca e valida múltiplos checkboxes

### ✔ Combobox (`Select`)
- Seleciona opções via `selectByVisibleText`
- Confere a opção selecionada

### ✔ DatePicker
- Envia uma data com teclado
- Confirma seleção com ENTER

### ✔ Submissão do formulário
- Clica no botão Submit
- Valida a página de sucesso (`/thanks`)

### ✔ Modal (uso do WebDriverWait)
- Abre modal
- Valida título do modal
- Fecha modal e aguarda ele desaparecer

### ✔ Actions
- Hover sobre elementos no site `the-internet.herokuapp.com/hovers`
- Valida legendas exibidas ao passar o mouse

Este arquivo serve como um **guia de automação Selenium**, contendo:
- Navegação
- Preenchimento
- Interações diversas
- Esperas explícitas

---

## 🧩 Teste Principal — Hamcrest: `HamcrestDemo`

`Localização:`
src/test/java/br/com/infnet/hamcrest/HamcrestDemo.java


Este arquivo demonstra o uso dos principais **matchers Hamcrest**, como:

### ✔ Comparações e igualdade
- `is(21)`
- `equalTo(21)`
- `not(...)`

### ✔ Strings
- `containsString("Selenium")`
- `equalToIgnoringCase("infnet")`
- `emptyOrNullString()`

### ✔ Listas
- `hasSize(3)`
- `hasItem("Leo")`

### ✔ Números
- `greaterThan(5)`
- `lessThan(3.0)`
- `greaterThanOrEqualTo(7)`

### ✔ Combinação de condições
- `anyOf(...)`  
  Exemplo: aceitar "Joao" ou "Maria"

Este arquivo funciona como um *playground para aprender e testar Hamcrest*, mostrando como usar matchers mais expressivos do que os asserts tradicionais do JUnit.
