package dev.simonrowe.java21demo;

import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CatFactQueryResolver implements GraphQLQueryResolver {

    private final CatFactClient catFactClient;
    private final CatFactService catFactService;
    private final ExecutorService executorService = Executors.newFixedThreadPool(50);
    //private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    @SneakyThrows
    public CatFact catFact() {
        return catFactService.getCatFact();
    }

    @SneakyThrows
    public CompletableFuture<CatFact> catFactAsync() {
        return CompletableFuture.supplyAsync(() -> catFact(), executorService);
    }
}
