package io.aiven.quickstart.kafka;

import io.aiven.quickstart.elevator.ElevatorData;
import io.aiven.quickstart.serializer.JsonSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaProducerConfig {
    @Value("${host}")
    private String host;

    @Value("${ssl.port}")
    private String sslPort;

    @Value("${ssl.truststore.password}")
    private String truststorePassword;

    @Value("${ssl.keystore.password}")
    private String keystorePassword;

    @Value("${ssl.truststore.location}")
    private String truststoreLocation;

    @Value("${ssl.keystore.location}")
    private String keystoreLocation;

    private Properties getProperties() {
        Properties configProps = new Properties();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, String.format("%s:%s", host, sslPort));
        configProps.put("security.protocol", "SSL");
        configProps.put("ssl.truststore.location", truststoreLocation);
        configProps.put("ssl.truststore.password", truststorePassword);
        configProps.put("ssl.keystore.type", "PKCS12");
        configProps.put("ssl.keystore.location", keystoreLocation);
        configProps.put("ssl.keystore.password", keystorePassword);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return configProps;
    }

    @Bean
    public KafkaProducer<String, ElevatorData> kafkaProducer() {
        return new KafkaProducer<>(getProperties());
    }
}


