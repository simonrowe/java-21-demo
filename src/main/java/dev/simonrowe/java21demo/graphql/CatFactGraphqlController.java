package dev.simonrowe.java21demo.graphql;


import dev.simonrowe.java21demo.domain.CatFact;
import dev.simonrowe.java21demo.rest.CatFactClient;
import dev.simonrowe.java21demo.service.CatFactService;
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
