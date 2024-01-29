package dev.simonrowe.java21demo.mongo;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v4.decorator.impl.MongockTemplate;
import com.github.javafaker.Faker;
import dev.simonrowe.java21demo.domain.CatFact;
import io.changock.migration.api.annotations.NonLockGuarded;
import io.micrometer.observation.ObservationRegistry;
import io.mongock.runner.springboot.EnableMongock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.observability.ContextProviderFactory;
import org.springframework.data.mongodb.observability.MongoObservationCommandListener;
import org.testcontainers.containers.MongoDBContainer;

@Configuration
@EnableMongock
@ChangeLog
@Slf4j
public class MongoDBConfig {

    @Bean
    @ServiceConnection
    MongoDBContainer mongoDBContainer() {
        return new MongoDBContainer();
    }

    @ChangeSet(order = "0001", id = "seedInitialData", author = "Simon Rowe")
    public void seedData(@NonLockGuarded final MongockTemplate mongockTemplate) {
        final Faker faker = new Faker();
        for (int i = 1; i < 300; i++) {
            var catfact = String.format("%s - %s", faker.cat().name(), faker.chuckNorris().fact());
            var fact = new CatFact(i, catfact, catfact.length());
            log.info("Seeding Catfact; {}", fact);
            mongockTemplate.save(fact, "catfacts");
        }
    }

    @Bean
    MongoClientSettingsBuilderCustomizer mongoMetricsSynchronousContextProvider(ObservationRegistry registry) {
        return (clientSettingsBuilder) -> {
            clientSettingsBuilder.contextProvider(ContextProviderFactory.create(registry))
                .addCommandListener(new MongoObservationCommandListener(registry));
        };
    }
}
