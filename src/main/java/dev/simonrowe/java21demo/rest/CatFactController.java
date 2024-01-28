package dev.simonrowe.java21demo.rest;


import dev.simonrowe.java21demo.domain.CatFact;
import dev.simonrowe.java21demo.service.CatFactServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CatFactController {

    private final CatFactClient catFactClient;
    private final CatFactServiceImpl catFactService;

    @GetMapping("/catfact/proxy")
    CatFact catFactProxy() {
        final CatFact catFact = catFactClient.randomFact();
        log.info("CatFact returned is {}", catFact);
        return catFact;
    }

    @GetMapping("/catfact/faker")
    @SneakyThrows
    CatFact catFactFaker() {
        return catFactService.getCatFact();
    }


}
