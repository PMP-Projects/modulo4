package br.com.fatec.modulo4;

import br.com.fatec.modulo4.controller.adapter.PessoaControllerAdapter;
import br.com.fatec.modulo4.controller.dto.request.PessoaCreateRequest;
import br.com.fatec.modulo4.entity.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PessoaControllerAdapterTest {

    @Test
    void shouldConvertRequestToPessoa() {
        PessoaCreateRequest request = new PessoaCreateRequest("João", LocalDate.of(2000, 1, 1));

        Pessoa pessoa = PessoaControllerAdapter.cast(request);

        assertEquals("João", pessoa.nome());
        assertEquals(LocalDate.of(2000, 1, 1), pessoa.dataNascimento());
    }
}
