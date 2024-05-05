package link.arunv.kafka.Util;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaConfigs {
    public static String gettopicName() {
        String topic_name = "tollywood-movie-details";
        return topic_name;
    }

    public static int getPartitions() {
        int num_of_partitions = 3;
        return num_of_partitions;
    }

    public static Properties getProducerProperties() {
        Properties properties = new Properties();
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        properties.setProperty("bootstrap.servers", "aruns-macbook:9092");
        return properties;
    }

    public static Properties getConsumerProperties() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "aruns-macbook:9092");
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());
        properties.setProperty("group.id", "my-java-application");
        properties.setProperty("auto.offset.reset", "earliest");
        return properties;
    }
}
