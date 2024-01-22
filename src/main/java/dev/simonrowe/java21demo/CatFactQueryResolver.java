package dev.simonrowe.java21demo;

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
