package dev.simonrowe.java21demo.rest;

import dev.simonrowe.java21demo.domain.CatFact;
import org.springframework.web.service.annotation.GetExchange;

public interface CatFactClient {

    @GetExchange("https://catfact.ninja/fact")
    CatFact randomFact();
}
