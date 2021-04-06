package cn.sharit.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class KafkaProducerStart {

    public static final String brokerList = "192.168.1.200:9092";
    public static final String topic = "topic-first";

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);


        while (true) {
            KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, "Hello, Kafka! " + new Random().nextInt());
            kafkaProducer.send(producerRecord, (RecordMetadata var1, Exception var2) -> {
                System.out.println("Callback");
            });

            kafkaProducer.close(); // 这个一定要关闭？？？

            TimeUnit.SECONDS.sleep(1);
        }


    }

}
