package dev.simonrowe.java21demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatFactController {

    private final CatFactClient catFactClient;

    public CatFactController(CatFactClient catFactClient) {
        this.catFactClient = catFactClient;
    }

    @GetMapping("/catfact")
    CatFact catFact() {
        return catFactClient.randomFact();
    }

}
