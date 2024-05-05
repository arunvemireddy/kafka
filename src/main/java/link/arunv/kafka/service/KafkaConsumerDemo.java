package link.arunv.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;

import static link.arunv.kafka.Util.KafkaConfigs.getConsumerProperties;
import static link.arunv.kafka.Util.KafkaConfigs.gettopicName;

@Slf4j
@Service
public class KafkaConsumerDemo {

    public KafkaConsumer<String, String> getConsumerr() {
        return new KafkaConsumer<>(getConsumerProperties());
    }

    public void pollData() {
        KafkaConsumer<String, String> consumer = getConsumerr();
        consumer.subscribe(Arrays.asList(gettopicName()));
        while (true) {
            log.info("Polling");
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record :
                    records) {
                log.info("Key: {} , Value: {}", record.key(), record.value());
                log.info("Partition:{}, Offset:{}", record.partition(), record.offset());
            }
        }
    }
}
