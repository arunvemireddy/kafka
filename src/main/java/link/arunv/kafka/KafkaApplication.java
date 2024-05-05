package link.arunv.kafka;

import link.arunv.kafka.service.KafkaProducerDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j
@SpringBootApplication(scanBasePackages = {"link.arunv.kafka"})
public class KafkaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(KafkaApplication.class, args);
    }
}
