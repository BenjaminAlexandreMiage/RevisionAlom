package alom.producer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws UnknownHostException, InterruptedException, ExecutionException
    {
        
        Properties config = new Properties();
        
        config.put(ProducerConfig.CLIENT_ID_CONFIG,InetAddress.getLocalHost().getHostName());
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,LongSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        config.put(ProducerConfig.ACKS_CONFIG,"all");
        
        KafkaProducer<Long,String> producer = new KafkaProducer<>(config);
        
        final ProducerRecord<Long, String> record = new ProducerRecord<>("topic", System.currentTimeMillis(), "message test");
        
        Future<RecordMetadata> future = producer.send(record);
        
        RecordMetadata metadata = future.get();
        
        producer.close();
        
    }
}
