package br.com.fatec.modulo4;

import br.com.fatec.modulo4.controller.advice.RestExceptionHandler;
import br.com.fatec.modulo4.controller.dto.response.ErrorResponse;
import br.com.fatec.modulo4.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class RestExceptionHandlerTest {

    private final RestExceptionHandler handler = new RestExceptionHandler();

    private HttpServletRequest mockRequest() {
        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getServletPath()).thenReturn("/test");
        return req;
    }

    @Test
    void shouldHandleInternalServerException() {
        ErrorResponse response = handler.handleInternalServerError(
                new InternalServerException("Erro interno"),
                mockRequest()
        );

        assertEquals(500, response.status());
    }

    @Test
    void shouldHandleNotFoundException() {
        ErrorResponse response = handler.handleNotFound(
                new NotFoundException("Não encontrado"),
                mockRequest()
        );

        assertEquals(404, response.status());
    }

    @Test
    void shouldHandleBadRequestException() {
        ErrorResponse response = handler.handleBadRequest(
                new BadRequestException("Requisição inválida"),
                mockRequest()
        );

        assertEquals(400, response.status());
    }

    @Test
    void shouldHandleKafkaProducerException() {
        ErrorResponse response = handler.handleKafkaProducerException(
                new KafkaProducerException("Erro Kafka", new RuntimeException()),
                mockRequest()
        );

        assertEquals(500, response.status());
        assertEquals("Erro ao enviar mensagem para Kafka", response.error());
    }
}
