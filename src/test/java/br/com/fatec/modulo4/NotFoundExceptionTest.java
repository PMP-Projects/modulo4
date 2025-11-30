package br.com.fatec.modulo4;

import br.com.fatec.modulo4.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class NotFoundExceptionTest {

    @Test
    void shouldCreateWithMessage() {
        NotFoundException ex = new NotFoundException("Erro");
        assertEquals("Erro", ex.getMessage());
    }
}
