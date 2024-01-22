package dev.simonrowe.java21demo;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CatFactController {

    private final CatFactClient catFactClient;
    private final CatFactService catFactService;


    @GetMapping("/catfact/proxy")
    CatFact catFactProxy() {
        return catFactClient.randomFact();
    }

    @GetMapping("/catfact/faker")
    @SneakyThrows
    CatFact catFactFaker() {
        return catFactService.getCatFact();
    }


}
