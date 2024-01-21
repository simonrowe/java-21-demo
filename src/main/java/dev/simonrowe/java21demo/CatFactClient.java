package dev.simonrowe.java21demo;

import org.springframework.web.service.annotation.GetExchange;

public interface CatFactClient {

    @GetExchange("https://catfact.ninja/fact")
    CatFact randomFact();
}
