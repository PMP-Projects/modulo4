package br.com.fatec.modulo4;

import br.com.fatec.modulo4.controller.dto.response.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ErrorResponseTest {

    @Test
    void shouldCreateErrorResponse() {
        LocalDateTime now = LocalDateTime.now();

        ErrorResponse response = new ErrorResponse(
                now, "/test", 400, "Bad Request", "Erro"
        );

        assertEquals(now, response.date());
        assertEquals("/test", response.path());
        assertEquals(400, response.status());
        assertEquals("Bad Request", response.error());
        assertEquals("Erro", response.message());
    }
}
