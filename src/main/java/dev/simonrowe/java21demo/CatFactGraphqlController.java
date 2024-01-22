package dev.simonrowe.java21demo;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CatFactGraphqlController {

    private final CatFactClient catFactClient;
    private final CatFactService catFactService;

    @QueryMapping
    @SneakyThrows
    CatFact catFact() {
        return catFactService.getCatFact();
    }


}
