package de.seventy2eleven.spring.runtimebeandemo;

import org.springframework.beans.factory.config.BeanDefinition;

public class Broker {
    private BrokerDefinition brokerDefinition;

    public Broker(BrokerDefinition brokerDefinition) {
        this.brokerDefinition = brokerDefinition;
    }

    @Override
    public String toString() {
        return "Broker['" + brokerDefinition.getName() + "' @ '" + brokerDefinition.getUrl() + "']";
    }
}
