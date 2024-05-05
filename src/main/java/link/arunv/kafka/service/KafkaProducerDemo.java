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
                    ProducerRecord<>(gettopicName(), 1, "movie-info", movie.toString());
            producer.send(producerRecord);
        }
        producer.flush();
        producer.close();
    }
}
