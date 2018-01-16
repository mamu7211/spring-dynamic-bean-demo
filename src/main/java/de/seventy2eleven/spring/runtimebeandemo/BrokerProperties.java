package de.seventy2eleven.spring.runtimebeandemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "setting")
public class BrokerProperties {
    private List<BrokerDefinition> broker;

    public List<BrokerDefinition> getBroker() {
        return broker;
    }

    public void setBroker(List<BrokerDefinition> broker) {
        this.broker = broker;
    }
}

