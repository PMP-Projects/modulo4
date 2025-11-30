package br.com.fatec.modulo4;

import br.com.fatec.modulo4.exception.InternalServerException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class InternalServerExceptionTest {

    @Test
    void shouldCreateWithMessage() {
        InternalServerException ex = new InternalServerException("Erro");
        assertEquals("Erro", ex.getMessage());
    }
}
