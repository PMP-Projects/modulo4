package br.com.fatec.modulo4;

import br.com.fatec.modulo4.exception.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class BadRequestExceptionTest {

    @Test
    void shouldCreateExceptionWithMessage() {
        BadRequestException ex = new BadRequestException("Erro");
        assertEquals("Erro", ex.getMessage());
    }
}
