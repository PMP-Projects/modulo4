package br.com.fatec.modulo4;

import br.com.fatec.modulo4.entity.Pessoa;
import br.com.fatec.modulo4.event.PessoaEventProducer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ActiveProfiles;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class PessoaEventProducerTest {

    @Test
    void shouldSendMessageSuccessfully() throws Exception {
        KafkaTemplate<String, Pessoa> kafkaTemplate = mock(KafkaTemplate.class);

        when(kafkaTemplate.send(anyString(), anyString(), any()))
                .thenReturn(CompletableFuture.completedFuture(null));

        PessoaEventProducer producer = new PessoaEventProducer(kafkaTemplate, "test-topic");

        producer.send(new Pessoa("Ana", LocalDate.now()));

        verify(kafkaTemplate, times(1)).send(anyString(), anyString(), any());
    }


}
