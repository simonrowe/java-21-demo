package dev.simonrowe.java21demo;

import com.github.javafaker.Faker;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@Observed
@Slf4j
@RequiredArgsConstructor
public class CatFactServiceImpl implements CatFactService {

    private final Faker faker = new Faker();

    private final ObservationRegistry observationRegistry;

    @Override
    public CatFact getCatFact() {
        var databaseSpan = Observation.createNotStarted("database-call", observationRegistry);
        databaseSpan.observe(pause(300));

        var apiSpan = Observation.createNotStarted("api-call", observationRegistry);
        apiSpan.observe(pause(50));
        var catfact = String.format("%s: %s", faker.cat().name(), faker.chuckNorris().fact());
        log.info("{} Retrieved catfact: {}", Thread.currentThread(), catfact);
        return new CatFact(catfact, catfact.length());
    }

    @NotNull
    private static Runnable pause(int time) {
        return () ->
        {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
