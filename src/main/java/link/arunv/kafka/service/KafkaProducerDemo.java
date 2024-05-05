package link.arunv.kafka.service;

import link.arunv.kafka.model.Movies;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static link.arunv.kafka.Util.KafkaConfigs.getProducerProperties;
import static link.arunv.kafka.Util.KafkaConfigs.gettopicName;

//@Component
@Service
@Slf4j
public class KafkaProducerDemo {

    public KafkaProducer getProducer() {
        return new KafkaProducer<>(getProducerProperties());
    }

    public void getData() {

    }

    public void produceData(List<Movies> movies) throws IOException {
        KafkaProducer<String, String> producer = getProducer();
        for (Movies movie : movies) {
            log.info("movie name:{}", movie.getMovie_name());
            log.info("director name:{}", movie.getDirector());
            log.info("id:{}", movie.getId());
            ProducerRecord<String, String> producerRecord = new
                    ProducerRecord<>(gettopicName(), 1, "movie", movie.toString());
            producer.send(producerRecord);
        }
//        for (int j = 0; j <= getPartitions(); j++) {
//            for (int i = 0; i < 10; i++) {
//                String key = "id_" + j;
//                String value = "Hello" + i;
//                ProducerRecord<String, String> producerRecord = new
//                        ProducerRecord<>(gettopicName(), j, key, value);
//                producer.send(producerRecord, new Callback() {
//                    @Override
//                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
//                        if (e == null) {
//                            log.info("Key" + key + "Partition" + recordMetadata.partition());
//                            log.info("key: {}, partition: {} ", key, recordMetadata.partition());
//                        } else {
//                            log.error("Error while producing", e);
//                        }
//                    }
//                });
//            }
//        }
        producer.flush();
        producer.close();
    }
}
