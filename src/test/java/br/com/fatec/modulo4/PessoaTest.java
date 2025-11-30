package br.com.fatec.modulo4;

import br.com.fatec.modulo4.entity.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PessoaTest {

    @Test
    void shouldCreatePessoa() {
        Pessoa pessoa = new Pessoa("Lucas", LocalDate.of(1995, 8, 15));

        assertEquals("Lucas", pessoa.nome());
        assertEquals(LocalDate.of(1995, 8, 15), pessoa.dataNascimento());
    }
}
