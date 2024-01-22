package dev.simonrowe.java21demo;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class CatFactService {

    private final Faker faker = new Faker();

    @NotNull
    @SneakyThrows
    public CatFact getCatFact() throws InterruptedException {
        Thread.sleep(300);
        var catfact = faker.cat().name();
        return new CatFact(catfact, catfact.length());
    }
}
