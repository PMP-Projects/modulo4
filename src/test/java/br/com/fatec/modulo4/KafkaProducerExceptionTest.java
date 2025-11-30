package br.com.fatec.modulo4;

import br.com.fatec.modulo4.exception.KafkaProducerException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class KafkaProducerExceptionTest {

    @Test
    void shouldCreateKafkaProducerException() {
        Exception cause = new RuntimeException("Falha");
        KafkaProducerException ex = new KafkaProducerException("Erro Kafka", cause);

        assertEquals("Erro Kafka", ex.getMessage());
        assertEquals(cause, ex.getCause());
    }
}
