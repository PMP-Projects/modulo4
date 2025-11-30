package br.com.fatec.modulo4;

import br.com.fatec.modulo4.controller.PessoaEventController;
import br.com.fatec.modulo4.controller.dto.request.PessoaCreateRequest;
import br.com.fatec.modulo4.entity.Pessoa;
import br.com.fatec.modulo4.event.PessoaEventProducer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class PessoaEventControllerTest {

    @Test
    void shouldCallProducerWhenRegisteringPessoa() {
        PessoaEventProducer producer = Mockito.mock(PessoaEventProducer.class);
        PessoaEventController controller = new PessoaEventController(producer);

        PessoaCreateRequest request = new PessoaCreateRequest(
                "Maria",
                LocalDate.of(1990, 5, 10)
        );

        controller.register(request);

        verify(producer, times(1)).send(any(Pessoa.class));
    }
}
