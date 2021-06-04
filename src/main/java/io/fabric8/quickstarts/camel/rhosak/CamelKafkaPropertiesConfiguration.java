package io.fabric8.quickstarts.camel.rhosak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka")
public class CamelKafkaPropertiesConfiguration {

    private String clientId;

    private String clientSecret;

    private String brokers;

    private String saslMechanism;

    private String securityProtocol;

    private String saslJaasConfig;

    private String sslEnabledProtocols;

    private String sslProtocol;

    private int maxPollRecords;

    private String groupId;

    private String seekTo;

    private int consumersCount;

    private String topic;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getBrokers() {
        return brokers;
    }

    public void setBrokers(String brokers) {
        this.brokers = brokers;
    }

    public String getSaslMechanism() {
        return saslMechanism;
    }

    public void setSaslMechanism(String saslMechanism) {
        this.saslMechanism = saslMechanism;
    }

    public String getSecurityProtocol() {
        return securityProtocol;
    }

    public void setSecurityProtocol(String securityProtocol) {
        this.securityProtocol = securityProtocol;
    }

    public String getSaslJaasConfig() {
        return saslJaasConfig;
    }

    public void setSaslJaasConfig(String saslJaasConfig) {
        this.saslJaasConfig = saslJaasConfig;
    }

    public String getSslEnabledProtocols() {
        return sslEnabledProtocols;
    }

    public void setSslEnabledProtocols(String sslEnabledProtocols) {
        this.sslEnabledProtocols = sslEnabledProtocols;
    }

    public String getSslProtocol() {
        return sslProtocol;
    }

    public void setSslProtocol(String sslProtocol) {
        this.sslProtocol = sslProtocol;
    }

    public int getMaxPollRecords() {
        return maxPollRecords;
    }

    public void setMaxPollRecords(int maxPollRecords) {
        this.maxPollRecords = maxPollRecords;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSeekTo() {
        return seekTo;
    }

    public void setSeekTo(String seekTo) {
        this.seekTo = seekTo;
    }

    public int getConsumersCount() {
        return consumersCount;
    }

    public void setConsumersCount(int consumersCount) {
        this.consumersCount = consumersCount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
