package link.arunv.kafka.controller;

import link.arunv.kafka.model.Movies;
import link.arunv.kafka.service.KafkaConsumerDemo;
import link.arunv.kafka.service.KafkaProducerDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/kafka/api")
public class KafkaController {

    @Autowired
    private KafkaProducerDemo kafkaProducerDemo;

    @Autowired
    private KafkaConsumerDemo kafkaConsumerDemo;

    @PostMapping(path = "/sendData")
    public ResponseEntity sendData(@RequestBody List<Movies> movies) {
        try {
            kafkaProducerDemo.produceData(movies);
            return ResponseEntity.ok("data sent to kafka topic");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/pollData")
    public ResponseEntity pollData() {
        kafkaConsumerDemo.pollData();
        return ResponseEntity.ok("polling");
    }
}
