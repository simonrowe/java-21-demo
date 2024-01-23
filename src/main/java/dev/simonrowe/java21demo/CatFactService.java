package dev.simonrowe.java21demo;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CatFactService {

    private final Faker faker = new Faker();

    @NotNull
    @SneakyThrows
    public CatFact getCatFact() throws InterruptedException {
        Thread.sleep(300);
        var catfact = String.format("%s: %s", faker.cat().name(), faker.chuckNorris().fact());
        log.info("Retrieved catfact: {}", catfact);
        return new CatFact(catfact, catfact.length());
    }
}
