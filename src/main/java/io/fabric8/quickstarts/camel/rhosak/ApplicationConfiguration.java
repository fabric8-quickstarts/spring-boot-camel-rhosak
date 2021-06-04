package io.fabric8.quickstarts.camel.rhosak;

import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaConfiguration;
import org.apache.camel.component.kafka.KafkaEndpoint;
import org.apache.camel.impl.DefaultShutdownStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public KafkaComponent kafka(KafkaConfiguration kafkaconfiguration){
        KafkaComponent component = new KafkaComponent();
        component.setConfiguration(kafkaconfiguration);
        return component;
    }

    @Bean
    public KafkaConfiguration kafkaConfiguration(CamelKafkaPropertiesConfiguration camelKafkaPropertiesConfiguration){
        KafkaConfiguration kafkaConfiguration = new KafkaConfiguration();
        kafkaConfiguration.setBrokers(camelKafkaPropertiesConfiguration.getBrokers());
        kafkaConfiguration.setSaslMechanism(camelKafkaPropertiesConfiguration.getSaslMechanism());
        kafkaConfiguration.setSecurityProtocol(camelKafkaPropertiesConfiguration.getSecurityProtocol());
        kafkaConfiguration.setSaslJaasConfig(camelKafkaPropertiesConfiguration.getSaslJaasConfig());
        kafkaConfiguration.setSslEnabledProtocols(camelKafkaPropertiesConfiguration.getSslEnabledProtocols());
        kafkaConfiguration.setSslProtocol(camelKafkaPropertiesConfiguration.getSslProtocol());
        kafkaConfiguration.setMaxPollRecords(camelKafkaPropertiesConfiguration.getMaxPollRecords());
        kafkaConfiguration.setGroupId(camelKafkaPropertiesConfiguration.getGroupId());
        kafkaConfiguration.setSeekTo(camelKafkaPropertiesConfiguration.getSeekTo());
        kafkaConfiguration.setConsumersCount(camelKafkaPropertiesConfiguration.getConsumersCount());
        kafkaConfiguration.setTopic(camelKafkaPropertiesConfiguration.getTopic());
        return kafkaConfiguration;
    }

    @Bean
    public KafkaEndpoint kafkaConsumerEndpoint(KafkaConfiguration kafkaconfiguration){
        KafkaEndpoint kafkaEndpoint = new KafkaEndpoint();
        kafkaEndpoint.setConfiguration(kafkaconfiguration);
        return kafkaEndpoint;
    }

    @Bean
    public KafkaEndpoint kafkaProducerEndpoint(KafkaConfiguration kafkaconfiguration){
        KafkaEndpoint kafkaEndpoint = new KafkaEndpoint();
        kafkaEndpoint.setConfiguration(kafkaconfiguration);
        return kafkaEndpoint;
    }

    @Bean
    public DefaultShutdownStrategy defaultShutdownStrategy(){
        DefaultShutdownStrategy defaultShutdownStrategy = new DefaultShutdownStrategy();
        defaultShutdownStrategy.setTimeout(10);
        defaultShutdownStrategy.setSuppressLoggingOnTimeout(true);
        defaultShutdownStrategy.setShutdownNowOnTimeout(true);
        return defaultShutdownStrategy;
    }




}
