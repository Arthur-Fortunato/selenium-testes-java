package br.com.infnet.hamcrest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.*;

public class HamcrestDemo {
    @Test
    public void helloWorld(){
        assertTrue(true);

        int soma = 3*7;
        assertThat(soma, is(21));
        assertThat(soma, equalTo(21));

        assertThat("Java", not("Python"));

        assertThat("Selenium Web Driver", containsString("Selenium"));
        assertThat("InfneT", equalToIgnoringCase("infnet"));
        assertThat("", emptyOrNullString());
        assertThat(null, emptyOrNullString());

        List<String> nomes = List.of("Ana", "Leo", "Pedro");
        assertThat(nomes, hasSize(3));
        assertThat(nomes, hasItem("Leo"));

        assertThat(10, greaterThan(5));
        assertThat(2.5, lessThan(3.0));
        assertThat(7, greaterThanOrEqualTo(7));

        assertThat("Maria", anyOf(equalTo("Joao"), equalTo("Maria")));
    }
}
