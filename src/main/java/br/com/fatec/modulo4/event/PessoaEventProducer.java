package br.com.fatec.modulo4.event;

import br.com.fatec.modulo4.entity.Pessoa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class PessoaEventProducer {

    private final String topic;
    private final KafkaTemplate<String, Pessoa> kafkaTemplate;

    private static final Logger log = LoggerFactory.getLogger(PessoaEventProducer.class);


    public PessoaEventProducer(
            KafkaTemplate<String, Pessoa> kafkaTemplate,
            @Value("${spring.kafka.topic.lambda.kafka}") String topic) {

        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Pessoa message) throws Exception {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), message)
                .get(5, TimeUnit.SECONDS);

        log.info("📤 Enviado para o tópico: " + topic);
    }
}
