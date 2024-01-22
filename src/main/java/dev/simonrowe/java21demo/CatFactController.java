package dev.simonrowe.java21demo;


import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatFactController {

    private final CatFactClient catFactClient;
    private final Faker faker = new Faker();

    public CatFactController(CatFactClient catFactClient) {
        this.catFactClient = catFactClient;
    }

    @GetMapping("/catfact/proxy")
    CatFact catFactProxy() {
        return catFactClient.randomFact();
    }

    @GetMapping("/catfact/faker")
    @SneakyThrows
    CatFact catFactFaker() {
        Thread.sleep(300);
        var catfact = faker.cat().name();
        return new CatFact(catfact, catfact.length());
    }


}
