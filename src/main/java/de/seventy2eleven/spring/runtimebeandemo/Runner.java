package de.seventy2eleven.spring.runtimebeandemo;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Getter
@Setter
@Configuration
public class Runner implements CommandLineRunner {

    private static Logger LOGGER = getLogger(Runner.class);

    private Broker firstBroker;
    private Broker secondBroker;

    @Autowired
    public Runner(@Qualifier("firstBroker") Broker firstBroker, @Qualifier("secondBroker") Broker secondBroker) {
        this.firstBroker = firstBroker;
        this.secondBroker = secondBroker;
    }

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("Broker = " + firstBroker);
        LOGGER.info("Broker = " + secondBroker);
    }
}
