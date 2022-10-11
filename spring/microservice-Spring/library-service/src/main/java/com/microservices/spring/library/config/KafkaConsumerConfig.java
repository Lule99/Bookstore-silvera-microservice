package com.microservices.spring.library.config;

import com.microservices.spring.library.model.dto.LibraryEntryDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "localhost:9092")
    private String bootstrapServers;

    @Bean
    public ConsumerFactory<String, LibraryEntryDto> consumerFactory() {
        Map<String, Object> props = new HashMap<>();

        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(JsonDeserializer.KEY_DEFAULT_TYPE, String.class);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, LibraryEntryDto.class);
        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(LibraryEntryDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, LibraryEntryDto>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, LibraryEntryDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}