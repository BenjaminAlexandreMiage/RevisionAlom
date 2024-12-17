package alom.consumer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws UnknownHostException {
    	
    	Properties config = new Properties();
    	
    	config.put(ConsumerConfig.CLIENT_ID_CONFIG,InetAddress.getLocalHost().getHostName());
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,LongDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
    	
        KafkaConsumer<Long,String> consumer = new KafkaConsumer<>(config);
        
        Boolean enCours = true;
        
        // Version 1 avec assign
        
        
        List<TopicPartition> listPartition1 = new ArrayList(); // On créer une liste pour stocker les topics
        TopicPartition topic1 = new TopicPartition("topic",0); // On crée le topic
        listPartition1.add(topic1); // On ajoute le topic à la liste
        
        
        consumer.assign(listPartition1); // On fait l'assignation avec la méthode assign
        
        while(enCours) { // Boucle pour que le code fonctionne en continue
        	
        	ConsumerRecords<Long, String> record1 = consumer.poll(1000); // On récupère les messages avec poll
        	
        	record1.forEach(record -> {
                System.out.printf(record.value()); // On affiche les messages
            });
        }
        
        consumer.close();
        
        
        
        // Version 2 avec listTopics
        
        /*
        
        Map<String, List<PartitionInfo>> mapPartition2 = consumer.listTopics(); // On récupère les topics existants
        
        PartitionInfo partitionInfo2 = mapPartition2.get("topic").get(0); // On récupère la partition du topics qui nous intéresse
       
        TopicPartition topic2 = new TopicPartition(partitionInfo2.topic(),partitionInfo2.partition()); // On crée un objet TopicPartition
        
        List<TopicPartition> listPartition2 = new ArrayList(); // On créer une liste pour stocker les topics
        
        listPartition2.add(topic2); // On ajoute le topic à la liste
        
        consumer.assign(listPartition2); // On fait l'assignation avec la méthode assign
        
        while(enCours) { // Boucle pour que le code fonctionne en continue
        	
        	ConsumerRecords<Long, String> record1 = consumer.poll(1000); // On récupère les messages avec poll
        	
        	record1.forEach(record -> {
                System.out.printf(record.value()); // On affiche les messages
            });
        }
        
        */
        
        consumer.close();
        
    }
}
