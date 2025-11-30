package br.com.fatec.modulo4;

import br.com.fatec.modulo4.config.KafkaTopicConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class KafkaTopicConfigTest {

    @Test
    void shouldCreateNewTopic() {
        KafkaTopicConfig config = new KafkaTopicConfig();

        NewTopic topic = config.kafkaTopic("test-topic", 3, (short) 1);

        assertNotNull(topic);
        assertEquals("test-topic", topic.name());
        assertEquals(3, topic.numPartitions());
        assertEquals(1, topic.replicationFactor());
    }
}
