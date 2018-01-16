package de.seventy2eleven.spring.runtimebeandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BrokerConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(BrokerConfiguration.class);

    private final ApplicationContext context;

    private BrokerProperties properties;

    @Autowired
    public BrokerConfiguration(BrokerProperties properties, ApplicationContext context) {
        this.properties = properties;
        this.context = context;
    }

    @PostConstruct
    public void registerBeans() {
        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) this.context;
        properties.getBroker().forEach(brokerDefinition -> {
                    LOGGER.info("Creating Broker Bean " + brokerDefinition.getName());
                    context.getBeanFactory().registerSingleton(brokerDefinition.getName(), new Broker(brokerDefinition));
                }
        );
    }
}
