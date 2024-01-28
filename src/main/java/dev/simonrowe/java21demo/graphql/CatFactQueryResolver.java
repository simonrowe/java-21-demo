package dev.simonrowe.java21demo.graphql;

import dev.simonrowe.java21demo.domain.CatFact;
import dev.simonrowe.java21demo.rest.CatFactClient;
import dev.simonrowe.java21demo.service.CatFactService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CatFactQueryResolver implements GraphQLQueryResolver {

    private final CatFactClient catFactClient;
    private final CatFactService catFactService;

    @SneakyThrows
    public CatFact catFact() {
        return catFactService.getCatFact();
    }
}
