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

	void taskExecuter(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executorService.execute(() -> {
                System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }

    public static void main(String[] args) throws IOException {
        KafkaProducerDemo kafkaProducerDemo = new KafkaProducerDemo();
//        kafkaProducerDemo.sendData();
        SpringApplication.run(KafkaApplication.class, args);
    }
}
