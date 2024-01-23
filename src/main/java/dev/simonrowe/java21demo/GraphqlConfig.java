package dev.simonrowe.java21demo;

import static io.micrometer.context.ContextExecutorService.wrap;

import io.micrometer.context.ContextSnapshot;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfig {

    //@Bean("graphqlAsyncTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        return wrap(Executors.newVirtualThreadPerTaskExecutor(), ContextSnapshot::captureAll);
    }
}
