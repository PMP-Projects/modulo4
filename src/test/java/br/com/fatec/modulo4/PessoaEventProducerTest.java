package br.com.fatec.modulo4;

import br.com.fatec.modulo4.entity.Pessoa;
import br.com.fatec.modulo4.event.PessoaEventProducer;
import br.com.fatec.modulo4.exception.KafkaProducerException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PessoaEventProducerTest {

    @Test
    void shouldSendMessageSuccessfully() throws Exception {
        KafkaTemplate<String, Pessoa> kafkaTemplate = mock(KafkaTemplate.class);

        CompletableFuture<SendResult<String, Pessoa>> future = new CompletableFuture<>();
        future.complete(null);

        when(kafkaTemplate.send(anyString(), anyString(), any()))
                .thenReturn(future);

        PessoaEventProducer producer = new PessoaEventProducer(kafkaTemplate, "test-topic");

        producer.send(new Pessoa("Ana", LocalDate.now()));

        verify(kafkaTemplate, times(1)).send(anyString(), anyString(), any());
    }

    @Test
    void shouldThrowKafkaProducerExceptionWhenExecutionFails() {
        KafkaTemplate<String, Pessoa> kafkaTemplate = mock(KafkaTemplate.class);

        CompletableFuture<SendResult<String, Pessoa>> future = new CompletableFuture<>();
        future.completeExceptionally(new ExecutionException("erro", new RuntimeException()));

        when(kafkaTemplate.send(anyString(), anyString(), any()))
                .thenReturn(future);

        PessoaEventProducer producer = new PessoaEventProducer(kafkaTemplate, "test-topic");

        assertThrows(KafkaProducerException.class,
                () -> producer.send(new Pessoa("Ana", LocalDate.now()))
        );
    }

    @Test
    void shouldThrowKafkaProducerExceptionWhenTimeoutOccurs() {
        KafkaTemplate<String, Pessoa> kafkaTemplate = mock(KafkaTemplate.class);

        CompletableFuture<SendResult<String, Pessoa>> future = spy(new CompletableFuture<>());

        try {
            doThrow(new TimeoutException("timeout"))
                    .when(future).get(5, TimeUnit.SECONDS);
        } catch (Exception ignored) {}

        when(kafkaTemplate.send(anyString(), anyString(), any()))
                .thenReturn(future);

        PessoaEventProducer producer = new PessoaEventProducer(kafkaTemplate, "test-topic");

        assertThrows(KafkaProducerException.class,
                () -> producer.send(new Pessoa("Ana", LocalDate.now()))
        );
    }

    @Test
    void shouldThrowKafkaProducerExceptionWhenInterrupted() {
        KafkaTemplate<String, Pessoa> kafkaTemplate = mock(KafkaTemplate.class);

        CompletableFuture<SendResult<String, Pessoa>> future = spy(new CompletableFuture<>());

        try {
            doThrow(new InterruptedException("interrupted"))
                    .when(future).get(5, TimeUnit.SECONDS);
        } catch (Exception ignored) {}

        when(kafkaTemplate.send(anyString(), anyString(), any()))
                .thenReturn(future);

        PessoaEventProducer producer = new PessoaEventProducer(kafkaTemplate, "test-topic");

        assertThrows(KafkaProducerException.class,
                () -> producer.send(new Pessoa("Ana", LocalDate.now()))
        );
    }
}
