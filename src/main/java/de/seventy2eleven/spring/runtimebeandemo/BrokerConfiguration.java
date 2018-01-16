package de.seventy2eleven.spring.runtimebeandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BrokerConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(BrokerConfiguration.class);

    private final AnnotationConfigApplicationContext context;

    private BrokerProperties properties;

    @Autowired
    public BrokerConfiguration(BrokerProperties properties, AnnotationConfigApplicationContext context) {
        this.properties = properties;
        this.context = context;
    }

    @PostConstruct
    public void registerBeans() {
        AnnotationConfigApplicationContext context = this.context;
        properties.getBroker().forEach(brokerDefinition -> {
                    LOGGER.info("Creating Broker Bean " + brokerDefinition.getName());
                    context.getBeanFactory().registerSingleton(brokerDefinition.getName(), new Broker(brokerDefinition));
                }
        );
    }
}
